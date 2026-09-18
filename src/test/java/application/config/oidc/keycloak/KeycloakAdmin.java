package application.config.oidc.keycloak;

import application.config.props.Env;
import core.config.OidcProvider;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.time.Duration;
import java.util.List;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RoleScopeResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

/**
 * Keycloak administration, the part the authorization tests use, on the official {@code keycloak-admin-client}.
 * Built on the {@link OidcProvider} of the application, so it talks to the same realm and client as the application;
 * only the Keycloak-specific server root and realm name are derived here. Admin credentials: {@link Env#keycloakAdminUser()},
 * {@link Env#keycloakAdminPassword()}.
 * <p>
 * The Keycloak may be shared with other runs and with people: the tests only create users of their own and read the settings,
 * nothing shared (the realm, the client, existing users) is changed.
 * <p>
 * Used by {@code application.Samples.Feature.signInAgain} only: a project that does not test its provider removes the tests
 * together with this class and the dependency.
 */
@Slf4j
public class KeycloakAdmin {

	private final RealmResource realm;

	private final String clientId;

	/**
	 * The internal id of the application client, resolved once
	 */
	private String clientUuid;

	public KeycloakAdmin(@NonNull OidcProvider oidc) {
		// a Keycloak authority is {serverRoot}/realms/{realm}
		var authority = oidc.getAuthority();
		int realms = authority.indexOf("/realms/");
		if (realms < 0) {
			throw new IllegalArgumentException("Not a Keycloak realm url: " + authority);
		}
		Keycloak keycloak = KeycloakBuilder.builder()
				.serverUrl(authority.substring(0, realms))
				.realm("master")
				.clientId("admin-cli")
				.grantType(OAuth2Constants.PASSWORD)
				.username(Env.keycloakAdminUser())
				.password(Env.keycloakAdminPassword())
				.build();
		this.realm = keycloak.realm(authority.substring(realms + "/realms/".length()).replaceAll("/+$", ""));
		this.clientId = oidc.getClientId();
	}

	public static KeycloakAdmin forApp(@NonNull URI appUri) {
		return new KeycloakAdmin(OidcProvider.ofApp(appUri));
	}

	/**
	 * Creates the user with the given client roles; the name must be free
	 */
	public void createUser(String username, String password, List<String> roleNames) {
		var credential = new CredentialRepresentation();
		credential.setType(CredentialRepresentation.PASSWORD);
		credential.setValue(password);
		credential.setTemporary(false);
		var user = new UserRepresentation();
		user.setUsername(username);
		user.setEnabled(true);
		user.setEmail(username + "@example.com");
		user.setEmailVerified(true);
		user.setFirstName(username);
		user.setLastName("Test");
		user.setCredentials(List.of(credential));
		try (Response response = realm.users().create(user)) {
			if (response.getStatus() != Response.Status.CREATED.getStatusCode()) {
				throw new IllegalStateException("Keycloak user " + username + " not created: " + response.getStatus() + " " + response.readEntity(String.class));
			}
		}
		grantClientRoles(username, roleNames);
		log.info("keycloak user {} created with client roles {}", username, roleNames);
	}

	public void deleteUser(String username) {
		realm.users().searchByUsername(username, true).forEach(user -> {
			realm.users().delete(user.getId()).close();
			log.info("keycloak user {} deleted", username);
		});
	}

	/**
	 * Names of the client roles of the user
	 */
	public List<String> getClientRoles(String username) {
		return clientRoles(username).listAll().stream().map(RoleRepresentation::getName).toList();
	}

	/**
	 * Gives the user the client roles it does not have yet
	 */
	public void grantClientRoles(String username, List<String> roleNames) {
		var roles = clientRoles(username).listAvailable().stream().filter(role -> roleNames.contains(role.getName())).toList();
		if (!roles.isEmpty()) {
			clientRoles(username).add(roles);
			log.info("client roles {} given to {}", roles.stream().map(RoleRepresentation::getName).toList(), username);
		}
	}

	/**
	 * Takes every client role away from the user
	 */
	public void revokeAllClientRoles(String username) {
		var roles = clientRoles(username).listAll();
		if (!roles.isEmpty()) {
			clientRoles(username).remove(roles);
			log.info("client roles {} revoked from {}", roles.stream().map(RoleRepresentation::getName).toList(), username);
		}
	}

	/**
	 * How long an access token of the realm lives: the tests that need an expired token wait it out instead of changing the setting
	 */
	public Duration getAccessTokenLifespan() {
		return Duration.ofSeconds(realm.toRepresentation().getAccessTokenLifespan());
	}

	/**
	 * Open SSO sessions of the user
	 */
	public int countSessions(String username) {
		return realm.users().get(userId(username)).getUserSessions().size();
	}

	private RoleScopeResource clientRoles(String username) {
		return realm.users().get(userId(username)).roles().clientLevel(clientUuid());
	}

	private String userId(String username) {
		return realm.users().searchByUsername(username, true).stream()
				.map(UserRepresentation::getId)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Keycloak user not found: " + username));
	}

	private String clientUuid() {
		if (clientUuid == null) {
			clientUuid = realm.clients().findByClientId(clientId).stream()
					.findFirst()
					.orElseThrow(() -> new IllegalStateException("Keycloak client not found: " + clientId))
					.getId();
		}
		return clientUuid;
	}

}
