package eu.lowentropy.articleannotater.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Article {

	@Id
	private String url;

	private String text;

	public Article(String url, String text) {
		this.url = url;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String getUrl() {
		return url;
	}
}
