package cu.uci.abcd.management.security.impl.services;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import cu.uci.abcd.management.security.ILoginService;
import cu.uci.abcd.management.security.impl.config.SecurityParams;

public class LoginServiceFactory implements ServiceFactory<ILoginService> {

	private SecurityParams securityParams;
	
	public LoginServiceFactory(SecurityParams securityParams) {
		super();
		this.securityParams = securityParams;
	}
	
	
	
	@Override
	public ILoginService getService(Bundle bundle, ServiceRegistration<ILoginService> serviceRegistration) {
		LoginService loginService = new LoginService();
		loginService.setSecurityParams(this.securityParams);
		return loginService;
	}

	@Override
	public void ungetService(Bundle bundle, ServiceRegistration<ILoginService> serviceRegistration, ILoginService loginService) {
		// TODO Auto-generated method stub
		
	}
}
