package cu.uci.abcd.management.security;

import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import cu.uci.abcd.management.security.ILoginService;

public class LoginServiceTracker extends ServiceTracker<ILoginService, ILoginService> {

	private ILoginServiceListener listener;
	
	public LoginServiceTracker() {
		super(FrameworkUtil.getBundle(LoginServiceTracker.class).getBundleContext(),
				ILoginService.class, null);
	}
	
	public void setListener(ILoginServiceListener listener) {
		this.listener = listener;
	}
	
	@Override
	public ILoginService addingService(ServiceReference<ILoginService> reference) {
		ILoginService loginService = super.addingService(reference);
		if(this.listener != null) {
			listener.setLoginService(loginService);
		}
		return loginService;
	}
}
