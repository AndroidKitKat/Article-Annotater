package eu.lowentropy.articleannotater.commentator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lowentropy.articleannotater.model.Article;
import eu.lowentropy.articleannotater.repository.ArticleRepository;

@RestController
public class CommentatorController {

	@Autowired
	private ArticleRepository articleRepository;

	@RequestMapping(value = "/comment", method = RequestMethod.POST, consumes = "application/json")
	public void addComment(@RequestBody CommentDto commentDto) {
		Article article = articleRepository.findOne(commentDto.getArticleId());
		article.addComment(commentDto.getComment());

		articleRepository.save(article);
	}
}
