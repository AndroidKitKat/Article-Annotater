package eu.lowentropy.articleannotater.extractor.service;

public interface AArticleExtractor {
	public static final String BOILERPIPE = "boilerpipe";
	public static final String GOOSE = "goose";
	public static final String READABILITY = "readability";

	String getText(String url);
}
