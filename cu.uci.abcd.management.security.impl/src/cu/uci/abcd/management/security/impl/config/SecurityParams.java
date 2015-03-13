package cu.uci.abcd.management.security.impl.config;

public class SecurityParams {

	private boolean securityEnabled;
	private int sessionTimeout;
	private AuthenticationType authenticationType;
	private String ldapDomain;
	private String ldapHost;
	private int ldapPort;
	
	public SecurityParams(String authenticationType, String ldapPort) {
		if(authenticationType == null || authenticationType.isEmpty() || authenticationType.equals("${security.authentication.type}")) {
			this.authenticationType = AuthenticationType.DATABASE;
		}
		else {
			this.authenticationType = AuthenticationType.valueOf(authenticationType.toUpperCase());
		}		
		if(ldapPort == null || ldapPort.isEmpty() || ldapPort.equals("${security.authentication.ldap.port}")) {
			this.ldapPort = -1;
		}
		else {
			this.ldapPort = Integer.parseInt(ldapPort);
		}
	}
	
	public boolean isSecurityEnabled() {
		return securityEnabled;
	}
	public void setSecurityEnabled(boolean securityEnabled) {
		this.securityEnabled = securityEnabled;
	}
	public int getSessionTimeout() {
		return sessionTimeout;
	}
	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}
	public AuthenticationType getAuthenticationType() {		
		return this.authenticationType;
	}
	public String getLdapDomain() {
		return ldapDomain;
	}
	public void setLdapDomain(String ldapDomain) {
		this.ldapDomain = ldapDomain;
	}
	public int getLdapPort() {
		return ldapPort;
	}
	public String getLdapHost() {
		return ldapHost;
	}
	public void setLdapHost(String ldapHost) {
		this.ldapHost = ldapHost;
	}
}
