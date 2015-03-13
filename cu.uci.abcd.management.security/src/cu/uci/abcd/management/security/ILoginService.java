package cu.uci.abcd.management.security;

/**
 * 
 * @author Eberto
 * 
 */
public interface ILoginService {
	/**
	 * 
	 * @param user
	 * @param password
	 * @throws LoginException
	 */
	public void login(String user, String password) throws LoginException;

	/**
	 * 
	 * @param listener
	 */
	public void onLoginChanged(ILoginChangedListener listener);

	/**
	 * 
	 * @return
	 */
	public boolean isLoggedIn();

	/**
	 * 
	 * @throws LoginException
	 */
	public void logout() throws LoginException;

	/**
	 * 
	 */
	public void clearEvents();

	/**
	 * 
	 * @return
	 */
	public boolean isEnabled();

	/**
	 * 
	 * @return
	 */
	public int getSessionTimeout();

	/**
	 * Get the 
	 * @return
	 */
	public ISecurityDataStore getSecurityDataStore();
}