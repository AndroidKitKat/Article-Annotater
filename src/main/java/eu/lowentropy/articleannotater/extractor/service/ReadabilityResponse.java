package eu.lowentropy.articleannotater.extractor.service;

public class ReadabilityResponse {

	private String content;
	private String domain;
	private String author;

	public String getContent() {
		return content;
	}
	public String getDomain() {
		return domain;
	}
	public String getAuthor() {
		return author;
	}
}
