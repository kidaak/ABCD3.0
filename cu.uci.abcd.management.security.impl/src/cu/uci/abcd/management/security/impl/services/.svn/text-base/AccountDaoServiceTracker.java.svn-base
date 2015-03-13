package cu.uci.abcd.management.security.impl.services;

import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import cu.uci.abcd.dao.common.AccountDAO;

public class AccountDaoServiceTracker extends ServiceTracker<AccountDAO, AccountDAO> {

	private IAccountDaoServiceListener listener;
	
	public AccountDaoServiceTracker() {
		super(FrameworkUtil.getBundle(AccountDaoServiceTracker.class).getBundleContext(),
				AccountDAO.class, null);
	}
	
	public void setListener(IAccountDaoServiceListener listener) {
		this.listener = listener;
	}
	
	@Override
	public AccountDAO addingService(ServiceReference<AccountDAO> reference) {
		AccountDAO accountDAO = super.addingService(reference);
		if(this.listener != null) {
			listener.addAccountDaoService(accountDAO);
		}
		return accountDAO;
	}
}
