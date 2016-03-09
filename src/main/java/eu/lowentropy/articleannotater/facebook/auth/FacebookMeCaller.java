package eu.lowentropy.articleannotater.facebook.auth;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.apache.http.client.ResponseHandler;
import org.springframework.stereotype.Service;

import eu.lowentropy.articleannotater.facebook.me.FacebookMe;
import eu.lowentropy.articleannotater.rest.BaseRestCaller;
import eu.lowentropy.articleannotater.rest.ResponseHandlerBase;
import eu.lowentropy.articleannotater.rest.RestCaller;

@Service(RestCaller.FACEBOOK_ME)
public class FacebookMeCaller implements RestCaller<FacebookMe> {

	private BaseRestCaller<FacebookMe> caller;

	@PostConstruct
	public void init() {
		ResponseHandler<FacebookMe> rh =
				new ResponseHandlerBase<FacebookMe>(FacebookMe.class);
		caller = new BaseRestCaller<>(rh);
	}

	@Override
	public FacebookMe call(URI uri) {
		return caller.call(uri);
	}
}
