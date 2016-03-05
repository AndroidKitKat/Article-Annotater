package eu.lowentropy.articleannotater.extractor.service;

import org.springframework.stereotype.Service;

import com.gravity.goose.Article;
import com.gravity.goose.Configuration;
import com.gravity.goose.Goose;

@Service(AArticleExtractor.GOOSE)
public class GooseArticleExtractor implements AArticleExtractor {

	@Override
	public String getText(String url) {
		Configuration configuration = new Configuration();
		Goose goose = new Goose(configuration);
		Article article = goose.extractContent(url);

		return article.cleanedArticleText();
	}

}
