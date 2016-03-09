package eu.lowentropy.articleannotater.facebook.me;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.lowentropy.articleannotater.facebook.auth.AccessToken;
import eu.lowentropy.articleannotater.facebook.auth.FacebookMeCaller;
import eu.lowentropy.articleannotater.facebook.auth.Payload;
import eu.lowentropy.articleannotater.facebook.auth.Token;

public class FacebookMeController {

	@Autowired
	private FacebookMeCaller meCaller;

	@RequestMapping(value = "/user", method = RequestMethod.POST,
			produces = "application/json", consumes = "application/json")
    public Token authToFacebook(@RequestBody Payload payload) {
		AccessToken accessToken = new AccessToken();
		meCaller.call(getURI(accessToken));
		return new Token(accessToken.getAccessToken());
    }

	private URI getURI(AccessToken accessToken) {
		try {
			return new URIBuilder()
					.setScheme("https")
			        .setHost("graph.facebook.com")
			        .setPath("/v2.5/me")
			        .setParameter("fields", "id,email")
			        .setParameter("access_token", accessToken.getAccessToken())
			        .setParameter("token_type", accessToken.getTokenType())
			        .setParameter("expires_in", accessToken.getExpiresIn().toString())
			        .build();
		} catch (URISyntaxException e1) {
			throw new IllegalArgumentException(e1);
		}
	}
}
