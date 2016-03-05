package eu.lowentropy.articleannotater.extractor.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service(AArticleExtractor.READABILITY)
public class ReadibilityArticleExtractor implements AArticleExtractor {

	@Override
	public String getText(String url) {
		URI uri;
		try {
			uri = new URIBuilder()
					.setScheme("https")
			        .setHost("readability.com")
			        .setPath("/api/content/v1/parser")
			        .setParameter("url", url)
			        .setParameter("token", "3de13c875c4b062e32f111d07dbaf67168ef8a09")
			        .build();
		} catch (URISyntaxException e1) {
			throw new IllegalArgumentException(e1);
		}
		HttpGet httpget = new HttpGet(uri);

		ResponseHandler<ReadabilityResponse> rh = new ResponseHandler<ReadabilityResponse>() {

		    @Override
		    public ReadabilityResponse handleResponse(
		            final HttpResponse response) throws IOException {
		        StatusLine statusLine = response.getStatusLine();
		        HttpEntity entity = response.getEntity();
		        if (statusLine.getStatusCode() >= 300) {
		            throw new HttpResponseException(
		                    statusLine.getStatusCode(),
		                    statusLine.getReasonPhrase());
		        }
		        if (entity == null) {
		            throw new ClientProtocolException("Response contains no content");
		        }
		        Gson gson = new GsonBuilder().create();
		        ContentType contentType = ContentType.getOrDefault(entity);
		        Charset charset = contentType.getCharset();
		        Reader reader = new InputStreamReader(entity.getContent(), charset);

		        return gson.fromJson(reader, ReadabilityResponse.class);
		    }
		};

		try {
			CloseableHttpClient client = HttpClients.createDefault();
			ReadabilityResponse response = client.execute(httpget, rh);
			return response.getContent();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
