package eu.lowentropy.articleannotater.facebook.me;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lowentropy.articleannotater.facebook.auth.FacebookMeCaller;

@RestController
public class FacebookMeController {

	@Autowired
	private FacebookMeCaller meCaller;

	@RequestMapping(value = "/user", method = RequestMethod.GET,
			produces = "application/json")
    public FacebookMe authToFacebook(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return (FacebookMe) meCaller.call(getURI(token.split(" ")[1]));
    }

	private URI getURI(String accessToken) {
		try {
			return new URIBuilder()
					.setScheme("https")
			        .setHost("graph.facebook.com")
			        .setPath("/v2.5/me")
			        .setParameter("fields", "id,email,name,picture")
			        .setParameter("access_token", accessToken)
			        .setParameter("token_type", "bearer")
			        .setParameter("expires_in", "5178000.0")
			        .build();
		} catch (URISyntaxException e1) {
			throw new IllegalArgumentException(e1);
		}
	}
}
