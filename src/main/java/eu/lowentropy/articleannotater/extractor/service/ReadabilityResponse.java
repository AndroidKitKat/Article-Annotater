package eu.lowentropy.articleannotater.extractor.service;

public class ReadabilityResponse {

	private String url;
	private String content;
	private String domain;
	private String author;
	private String title;
	private String lead_image_url;

	public String getContent() {
		return content;
	}
	public String getDomain() {
		return domain;
	}
	public String getAuthor() {
		return author;
	}
	public String getUrl() {
		return url;
	}
	public String getTitle() {
		return title;
	}
	public String getLead_image_url() {
		return lead_image_url;
	}
}
