package eu.lowentropy.articleannotater;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.sax.HTMLHighlighter;

@RestController
public class ArticleExtractorController {

	@RequestMapping(value = "/article", method = RequestMethod.GET, produces = "application/json")
    public Article extract(@RequestParam("url") String url) {
		URL articleURL = getURL(url);
		return new Article(getText(articleURL));
    }

	private URL getURL(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private String getText(URL articleURL) {
		final HTMLHighlighter hh = HTMLHighlighter.newExtractingInstance();
		try {
			return hh.process(articleURL, ArticleExtractor.INSTANCE);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
