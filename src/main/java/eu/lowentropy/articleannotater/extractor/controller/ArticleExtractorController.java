package eu.lowentropy.articleannotater.extractor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.lowentropy.articleannotater.extractor.service.AArticleExtractor;
import eu.lowentropy.articleannotater.model.Article;
import eu.lowentropy.articleannotater.repository.ArticleRepository;

@RestController
public class ArticleExtractorController {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	@Qualifier(AArticleExtractor.READABILITY)
	private AArticleExtractor articleExtractor;

	@RequestMapping(value = "/article", method = RequestMethod.GET, produces = "application/json")
    public Article extract(@RequestParam("url") String url) {
		Article article = articleRepository.findOne(url);

		if (null == article) {
			article = new Article(url, articleExtractor.getText(url));
			articleRepository.save(article);
		}

		return article;
    }
}
