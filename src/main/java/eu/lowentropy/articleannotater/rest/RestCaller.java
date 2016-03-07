package eu.lowentropy.articleannotater.rest;

import java.net.URI;

public interface RestCaller<T> {
	public final static String READIBILITY = "readibility";
	public final static String FACEBOOK_OAUTH = "facebook_oauth";
	public final static String FACEBOOK_ME = "facebook_me";

	T call(URI uri);
}
