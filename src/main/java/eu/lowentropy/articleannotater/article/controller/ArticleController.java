package eu.lowentropy.articleannotater.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.lowentropy.articleannotater.extractor.service.ArticleExtractor;
import eu.lowentropy.articleannotater.extractor.service.ReadabilityResponse;
import eu.lowentropy.articleannotater.model.Article;
import eu.lowentropy.articleannotater.repository.ArticleRepository;

@RestController
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	@Qualifier(ArticleExtractor.READABILITY)
	private ArticleExtractor articleExtractor;

	@RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json")
    public Article extract(@RequestParam("url") String url) {
		Article article = articleRepository.findOne(url);

		if (null == article) {
			ReadabilityResponse response = articleExtractor.getArticle(url);
			article = toArticle(response);
			articleRepository.save(article);
		}

		return article;
    }

	private Article toArticle(ReadabilityResponse response) {
		return Article.builder().url(response.getUrl())
				.title(response.getTitle())
				.leadImageUrl(response.getLead_image_url())
				.text(response.getContent())
				.build();
	}
}
