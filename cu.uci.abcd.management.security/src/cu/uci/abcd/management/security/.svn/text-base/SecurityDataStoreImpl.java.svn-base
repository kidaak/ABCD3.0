package cu.uci.abcd.management.security;

import java.util.HashMap;
import java.util.Map;

public class SecurityDataStoreImpl implements ISecurityDataStore {
	private Map<String, Object> securityDataStore;

	public SecurityDataStoreImpl() {
		super();
		securityDataStore = new HashMap<>();
	}

	@Override
	public Object putSecurityDataObject(String dataObjectKey, Object dataObject) {
		return securityDataStore.put(dataObjectKey, dataObject);
	}

	@Override
	public Object getSecurityDataObject(String dataObjectKey) {
		return securityDataStore.get(dataObjectKey);
	}

	@Override
	public Object removeSecurityDataObject(String dataObjectKey) {
		return securityDataStore.remove(dataObjectKey);
	}

	@Override
	public void clearSecurityDataStore() {
		securityDataStore.clear();
	}

}
