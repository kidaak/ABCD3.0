package cu.uci.abcd.management.security.impl.login.modules;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import cu.uci.abcd.management.security.impl.principals.AccountPrincipal;

public abstract class GenericLoginModule implements LoginModule {
	private Subject subject;
	private CallbackHandler callbackHandler;
	private NameCallback nameCallback;
	private PasswordCallback passwordCallback;
	protected boolean success;
	protected AccountPrincipal accountPrincipal;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.nameCallback = new NameCallback("usuario:");
		this.passwordCallback = new PasswordCallback("contraseña:", false);
	}

	@Override
	public boolean login() throws LoginException {
		try {
			this.callbackHandler.handle(new Callback[] { this.nameCallback,
					this.passwordCallback });
			String username = this.nameCallback.getName();
			char[] tempPassword = this.passwordCallback.getPassword();
			if (tempPassword == null) {
				tempPassword = new char[0];
			}
			String password = new String(tempPassword);
			this.passwordCallback.clearPassword();
			this.verifyCredentials(username, password);
			return true;
		} catch (IOException e) {
			throw new LoginException("IOException" + e.toString());
		} catch (UnsupportedCallbackException e) {
			throw new LoginException("ERROR: " + e.getCallback().toString()
					+ " incapaz de obtener información sobre el usuario.");
		}
	}

	@Override
	public boolean commit() throws LoginException {
		if (this.success) {
			if (!this.subject.getPrincipals().contains(this.accountPrincipal)) {
				this.subject.getPrincipals().add(this.accountPrincipal);
				System.out.println("account principal inyectado!");
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean abort() throws LoginException {
		if (!this.success) {
			return false;
		} else {
			this.logout();
		}
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		this.accountPrincipal.clear();
		this.subject.getPrincipals().clear();
		this.accountPrincipal = null;
		return true;
	}

	protected abstract void verifyCredentials(String username, String password)
			throws LoginException;
}
