package eu.lowentropy.articleannotater;

import org.junit.Test;

public class BoilerpipeAticleExtractorTest {

	private AArticleExtractor articleExtractor = new BoilerpipeArticleExtractor();

	@Test
	public void testExtract() throws Exception {
		// Given
		final String url = "http://www.lemonde.fr/international/article/2016/02/14/la-france-et-les-etats-unis-condamnent-les-bombardements-turcs-en-syrie_4865143_3210.html";

		// When
		String text = articleExtractor.getText(url);

		// Then
	    System.out.println(text);
	}
}
