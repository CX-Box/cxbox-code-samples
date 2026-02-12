package core.page.auth;

import java.net.URI;

public interface AuthWithUsernameAndPassword {

	/**
	 * Authentification with username and password ( without secret code )
	 *
	 * @param username username field
	 * @param password password field
	 * @param appUri   uri login page
	 */
	public void authWithUsernameAndPassword(String username, String password, URI appUri);
}
