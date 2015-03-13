package cu.uci.abcd.management.security.impl.login.modules;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import cu.uci.abcd.dao.common.AccountDAO;
import cu.uci.abcd.dao.management.library.LibraryDAO;
import cu.uci.abcd.dao.management.security.PermissionDAO;
import cu.uci.abcd.domain.common.Account;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.security.Permission;
import cu.uci.abcd.management.security.impl.principals.AccountPrincipal;
import cu.uci.abcd.management.security.impl.services.AccountDaoServiceTracker;
import cu.uci.abcd.management.security.impl.services.IAccountDaoServiceListener;
import cu.uci.abcd.management.security.impl.services.IPermissionDaoServiceListener;
import cu.uci.abcd.management.security.impl.services.IServiceListener;
import cu.uci.abcd.management.security.impl.services.LibraryDaoServiceTracker;
import cu.uci.abcd.management.security.impl.services.PermissionDaoServiceTracker;

public class DatabaseLoginModule extends GenericLoginModule implements
		LoginModule, IAccountDaoServiceListener, IPermissionDaoServiceListener,
		IServiceListener<LibraryDAO> {

	private AccountDAO accountDao;
	private PermissionDAO permissionDAO;
	private LibraryDAO libraryDAO;

	public DatabaseLoginModule() {
		AccountDaoServiceTracker tracker = new AccountDaoServiceTracker();
		tracker.setListener(this);
		tracker.open();
		PermissionDaoServiceTracker permissionDaoServiceTracker = new PermissionDaoServiceTracker();
		permissionDaoServiceTracker.setListener(this);
		permissionDaoServiceTracker.open();
		LibraryDaoServiceTracker libraryDaoServiceTracker = new LibraryDaoServiceTracker();
		libraryDaoServiceTracker.setListener(this);
		libraryDaoServiceTracker.open();
	}

	@Override
	protected void verifyCredentials(String username, String password)
			throws LoginException {
		this.success = false;
		if (this.accountDao == null) {
			throw new NullPointerException();
		}
		Account account = accountDao.findByUserNameAndPassword(username,
				password);

		if (account == null) {
			throw new FailedLoginException();
		}

		List<Permission> permissions = ((permissionDAO != null) ? permissionDAO
				.findAssignedPermissionsByAccountID(account.getAccountID())
				: new ArrayList<Permission>());
		Library library = libraryDAO.findLibraryByAcountIDMember(account
				.getAccountID());
		this.accountPrincipal = new AccountPrincipal(account.getUserName());
		this.accountPrincipal.getDataStore().putSecurityDataObject(
				"permissions", permissions);
		this.accountPrincipal.getDataStore().putSecurityDataObject("account",
				account);
		this.accountPrincipal.getDataStore().putSecurityDataObject("library",
				library);
		this.success = true;
	}

	@Override
	public void addAccountDaoService(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void addPermissionDaoService(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}

	@Override
	public void addServiceListener(LibraryDAO service) {
		this.libraryDAO = service;
	}
}
