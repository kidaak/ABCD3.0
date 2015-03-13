package cu.uci.abcd.management.security.impl.principals;

import java.security.Principal;

import cu.uci.abcd.management.security.ISecurityDataStore;
import cu.uci.abcd.management.security.SecurityDataStoreImpl;

public class AccountPrincipal implements Principal, java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String accountName;
	private ISecurityDataStore dataStore;

	public AccountPrincipal(String accountName) {
		this.accountName = accountName;
		this.dataStore = new SecurityDataStoreImpl();
	}

	public String getName() {
		return this.accountName;
	}

	public String toString() {
		return ("AccountPrincipal: " + this.accountName);
	}

	public ISecurityDataStore getDataStore() {
		return dataStore;
	}

	public void setDataStore(ISecurityDataStore dataStore) {
		this.dataStore = dataStore;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (this == o)
			return true;

		if (!(o instanceof AccountPrincipal))
			return false;
		AccountPrincipal that = (AccountPrincipal) o;

		if (this.getName().equals(that.getName()))
			return true;
		return false;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountName == null) ? 0 : accountName.hashCode());
		return result;
	}

	public void clear() {
		dataStore.clearSecurityDataStore();
		dataStore = null;
	}

}