package eu.lowentropy.articleannotater;

public interface AArticleExtractor {
	public static final String BOILERPIPE = "boilerpipe";
	public static final String GOOSE = "goose";
	public static final String READABILITY = "readability";

	String getText(String url);
}
