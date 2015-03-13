package cu.uci.abcd.management.security.impl.login.context;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.eclipse.equinox.security.auth.ILoginContext;
import org.eclipse.equinox.security.auth.ILoginContextListener;

public class SecurityLoginContext implements ILoginContext {

	private CallbackHandler callbackHandler;
	private Subject subject;
	private LoginModule loginModule;
	
	public SecurityLoginContext(LoginModule loginModule, CallbackHandler callbackHandler) throws LoginException {
		this.loginModule = loginModule;
		this.callbackHandler = callbackHandler;
		this.subject = new Subject();
		this.loginModule.initialize(this.subject, this.callbackHandler, null, null);
	}
	
	@Override
	public LoginContext getLoginContext() throws LoginException {
		return null;
	}

	@Override
	public Subject getSubject() {
		return this.subject;
	}

	@Override
	public void login() throws LoginException {
		this.loginModule.login();
		this.loginModule.commit();
	}

	@Override
	public void logout() throws LoginException {
		this.loginModule.logout();
	}

	@Override
	public void registerListener(ILoginContextListener ctxListener) {
	}

	@Override
	public void unregisterListener(ILoginContextListener ctxListener) {
	}

}
