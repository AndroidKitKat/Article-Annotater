package eu.lowentropy.articleannotater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleExtractorController {

	@Autowired
	@Qualifier(AArticleExtractor.READABILITY)
	private AArticleExtractor articleExtractor;

	@RequestMapping(value = "/article", method = RequestMethod.GET, produces = "application/json")
    public Article extract(@RequestParam("url") String url) {
		return new Article(articleExtractor.getText(url));
    }
}
