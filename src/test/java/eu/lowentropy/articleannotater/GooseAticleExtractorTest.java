package eu.lowentropy.articleannotater;

import org.junit.Test;

import eu.lowentropy.articleannotater.extractor.service.AArticleExtractor;
import eu.lowentropy.articleannotater.extractor.service.GooseArticleExtractor;

public class GooseAticleExtractorTest {

	private AArticleExtractor articleExtractor = new GooseArticleExtractor();

	@Test
	public void testExtract() throws Exception {
		// Given
		final String url = "http://www.cnn.com/2010/POLITICS/08/13/democrats.social.security/index.html";

		// When
		String text = articleExtractor.getText(url);

		// Then
	    System.out.println(text);
	}
}
