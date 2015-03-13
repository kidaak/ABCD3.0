package cu.uci.abcd.management.security.impl.services;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.LoginModule;

import org.eclipse.equinox.security.auth.ILoginContext;

import cu.uci.abcd.management.security.ILoginChangedListener;
import cu.uci.abcd.management.security.ILoginService;
import cu.uci.abcd.management.security.ISecurityDataStore;
import cu.uci.abcd.management.security.LoginException;
import cu.uci.abcd.management.security.impl.config.SecurityParams;
import cu.uci.abcd.management.security.impl.login.context.SecurityLoginContext;
import cu.uci.abcd.management.security.impl.login.modules.DatabaseLoginModule;
import cu.uci.abcd.management.security.impl.login.modules.LDAPLoginModule;
import cu.uci.abcd.management.security.impl.principals.AccountPrincipal;
import cu.uci.abos.util.api.Digest;

public class LoginService implements ILoginService {

	private ILoginContext loginContext;
	private Subject currentSubject;
	private List<ILoginChangedListener> loginChangedEvent;
	private SecurityParams securityParams;

	public LoginService() {
		this.loginChangedEvent = new LinkedList<ILoginChangedListener>();
	}

	@Override
	public void login(final String username, final String password)
			throws LoginException {
		try {
			String passwordEncoded = null;
			LoginModule loginModule = null;
			switch (this.securityParams.getAuthenticationType()) {
			case DATABASE:
				loginModule = new DatabaseLoginModule();
				passwordEncoded = Digest.digest(password, "SHA1");
				break;
			case LDAP:
				loginModule = new LDAPLoginModule(
						this.securityParams.getLdapDomain(),
						this.securityParams.getLdapHost(),
						this.securityParams.getLdapPort());
				passwordEncoded = password;
				break;
			}
			this.loginContext = new SecurityLoginContext(loginModule,
					new UserPassCallbackHandler(username, passwordEncoded));
			this.loginContext.login();
			this.currentSubject = this.loginContext.getSubject();
			this.fireLoginChangedEvent();
		} catch (Exception e1) {
			StackTraceElement[] traces = e1.getStackTrace();
			for (StackTraceElement trace : traces) {
				System.out.println(trace.toString());
			}
			throw new LoginException(e1.getMessage());
		}
	}

	public void logout() throws LoginException {
		try {
			if (this.loginContext != null) {
				this.loginContext.logout();
			}
			this.loginContext = null;
			this.currentSubject = null;
			this.fireLoginChangedEvent();
		} catch (javax.security.auth.login.LoginException e) {
			throw new LoginException(e.getMessage());
		}
	}

	public boolean isLoggedIn() {
		if (this.currentSubject != null) {
			return this.currentSubject.getPrincipals().size() > 0;
		}
		return false;
	}

	public void onLoginChanged(ILoginChangedListener listener) {
		this.loginChangedEvent.add(listener);
	}

	private void fireLoginChangedEvent() {
		for (ILoginChangedListener listener : this.loginChangedEvent) {
			listener.handle();
		}
	}

	public void clearEvents() {
		this.loginChangedEvent.clear();
	}

	private class UserPassCallbackHandler implements CallbackHandler {

		private String username;
		private String password;

		public UserPassCallbackHandler(String username, String password) {
			this.username = username;
			this.password = password;
		}

		@Override
		public void handle(Callback[] callbacks) throws IOException,
				UnsupportedCallbackException {
			for (int i = 0; i < callbacks.length; i++) {
				if (callbacks[i] instanceof NameCallback) {
					NameCallback nc = (NameCallback) callbacks[i];
					nc.setName(this.username);
				} else if (callbacks[i] instanceof PasswordCallback) {
					PasswordCallback pc = (PasswordCallback) callbacks[i];
					pc.setPassword(this.password.toCharArray());
				}
			}
		}
	}

	@Override
	public boolean isEnabled() {
		return this.securityParams.isSecurityEnabled();
	}

	@Override
	public int getSessionTimeout() {
		return this.securityParams.getSessionTimeout();
	}

	public void setSecurityParams(SecurityParams params) {
		this.securityParams = params;
	}

	@Override
	public ISecurityDataStore getSecurityDataStore() {
		AccountPrincipal accountPrincipal = (AccountPrincipal) this.currentSubject
				.getPrincipals().iterator().next();
		return accountPrincipal.getDataStore();
	}
}
