package eu.lowentropy.articleannotater.facebook.auth;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.apache.http.client.ResponseHandler;
import org.springframework.stereotype.Service;

import eu.lowentropy.articleannotater.rest.BaseRestCaller;
import eu.lowentropy.articleannotater.rest.ResponseHandlerBase;
import eu.lowentropy.articleannotater.rest.RestCaller;

@Service(RestCaller.FACEBOOK_OAUTH)
public class FacebookOauthCaller implements RestCaller<AccessToken> {

	private BaseRestCaller<AccessToken> caller;

	@PostConstruct
	public void init() {
		ResponseHandler<AccessToken> rh =
				new ResponseHandlerBase<AccessToken>(AccessToken.class);
		caller = new BaseRestCaller<>(rh);
	}

	@Override
	public AccessToken call(URI uri) {
		return caller.call(uri);
	}
}
