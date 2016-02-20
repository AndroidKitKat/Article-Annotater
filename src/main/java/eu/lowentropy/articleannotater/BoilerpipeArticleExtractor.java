package eu.lowentropy.articleannotater;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.sax.HTMLHighlighter;

@Service(AArticleExtractor.BOILERPIPE)
public class BoilerpipeArticleExtractor implements AArticleExtractor {

	@Override
	public String getText(String url) {
		final HTMLHighlighter hh = HTMLHighlighter.newExtractingInstance();
		try {
			return hh.process(getURL(url), ArticleExtractor.INSTANCE);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	private URL getURL(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
