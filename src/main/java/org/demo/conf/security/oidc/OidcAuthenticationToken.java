package org.demo.conf.security.oidc;

import org.cxbox.api.service.session.CxboxUserDetailsInterface;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Set;

public class OidcAuthenticationToken extends JwtAuthenticationToken {

	public OidcAuthenticationToken(Jwt jwt, Set<GrantedAuthority> authorities, String name, CxboxUserDetailsInterface cxboxOidcAccount) {
		super(jwt, authorities, name);
		this.setDetails(cxboxOidcAccount);
	}

}
