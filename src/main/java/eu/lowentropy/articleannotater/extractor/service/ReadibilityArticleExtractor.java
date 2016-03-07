package eu.lowentropy.articleannotater.extractor.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import eu.lowentropy.articleannotater.rest.RestCaller;

@Service(AArticleExtractor.READABILITY)
public class ReadibilityArticleExtractor implements AArticleExtractor {

	@Value("${readibility.token}")
	private String readibilityToken;

	@Autowired
	@Qualifier(RestCaller.READIBILITY)
	private ReadibilityCaller caller;

	@Override
	public String getText(String url) {
		URI uri;
		try {
			uri = new URIBuilder()
					.setScheme("https")
			        .setHost("readability.com")
			        .setPath("/api/content/v1/parser")
			        .setParameter("url", url)
			        .setParameter("token", readibilityToken)
			        .build();
		} catch (URISyntaxException e1) {
			throw new IllegalArgumentException(e1);
		}

		ReadabilityResponse response = caller.call(uri);
		return response.getContent();
	}

}
