package eu.lowentropy.articleannotater.extractor.service;

public interface ArticleExtractor {
	public static final String READABILITY = "readability";

	ReadabilityResponse getArticle(String url);
}
