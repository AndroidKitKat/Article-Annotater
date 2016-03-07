package eu.lowentropy.articleannotater.extractor.service;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.apache.http.client.ResponseHandler;
import org.springframework.stereotype.Service;

import eu.lowentropy.articleannotater.rest.BaseRestCaller;
import eu.lowentropy.articleannotater.rest.ResponseHandlerBase;
import eu.lowentropy.articleannotater.rest.RestCaller;

@Service(RestCaller.READIBILITY)
public class ReadibilityCaller implements RestCaller<ReadabilityResponse> {
	private BaseRestCaller<ReadabilityResponse> restCaller;

	@PostConstruct
	public void init() {
		ResponseHandler<ReadabilityResponse> rh =
				new ResponseHandlerBase<ReadabilityResponse>(ReadabilityResponse.class);
		restCaller = new BaseRestCaller<>(rh);
	}

	@Override
	public ReadabilityResponse call(URI uri) {
		return restCaller.call(uri);
	}
}
