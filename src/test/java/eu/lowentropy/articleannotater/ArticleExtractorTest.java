package eu.lowentropy.articleannotater;

import java.net.URL;

import org.junit.Test;

import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.sax.HTMLHighlighter;

public class ArticleExtractorTest {

	@Test
	public void testExtract() throws Exception {
		// Given
		final URL url = new URL("http://www.lemonde.fr/international/article/2016/02/14/la-france-et-les-etats-unis-condamnent-les-bombardements-turcs-en-syrie_4865143_3210.html");

		// When
		// Then
	    // final HTMLHighlighter hh = HTMLHighlighter.newHighlightingInstance();
	    final HTMLHighlighter hh = HTMLHighlighter.newExtractingInstance();

	    System.out.println(hh.process(url, ArticleExtractor.INSTANCE));
	}
}
