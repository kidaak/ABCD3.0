package cu.uci.abcd.management.security.impl.login.modules;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPResponse;
import com.novell.ldap.LDAPResponseQueue;

import cu.uci.abcd.domain.common.Account;
import cu.uci.abcd.management.security.impl.principals.AccountPrincipal;

public class LDAPLoginModule extends GenericLoginModule implements LoginModule {

	private String domain;
	private String host;
	private int port;

	public LDAPLoginModule(String domain, String host, int port) {
		super();
		this.domain = domain;
		this.host = host;
		this.port = port;
	}

	@Override
	protected void verifyCredentials(String username, String password)
			throws LoginException {
		this.success = false;
		LDAPConnection connection = new LDAPConnection();
		LDAPResponseQueue responseQueue = null;
		byte[] passwordBytes;
		try {
			passwordBytes = password.getBytes("UTF8");
			String loginDN = String.format("%s@%s", username, this.domain);
			connection.connect(this.host, this.port);
			responseQueue = connection.bind(LDAPConnection.LDAP_V3, loginDN,
					passwordBytes, (LDAPResponseQueue) null);
			LDAPResponse response = (LDAPResponse) responseQueue.getResponse();
			int bindResult = response.getResultCode();
			if (bindResult != LDAPException.SUCCESS) {
				throw new FailedLoginException(response.getErrorMessage());
			} else {
				// TODO: buscar en la base de datos el perfil y asociarselo a la
				// cuenta.
				Account account = new Account();
				account.setUserName(username);
				this.accountPrincipal = new AccountPrincipal(username);
				this.success = true;
			}
			connection.disconnect();
		} catch (Exception e) {
			throw new FailedLoginException(e.getMessage());
		}
	}
}
