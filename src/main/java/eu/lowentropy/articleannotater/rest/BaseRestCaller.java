package eu.lowentropy.articleannotater.rest;

import java.io.IOException;
import java.net.URI;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class BaseRestCaller<T> implements RestCaller<T> {

	private ResponseHandler<T> responseHandler;

	public BaseRestCaller(ResponseHandler<T> responseHandler) {
		this.responseHandler = responseHandler;
	}

	@Override
	public T call(URI uri) {
		HttpGet httpget = new HttpGet(uri);

		try(CloseableHttpClient client = HttpClients.createDefault()) {
			return client.execute(httpget, responseHandler);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
