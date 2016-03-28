package eu.lowentropy.articleannotater.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eu.lowentropy.articleannotater.model.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {
	List<Article> findTop3ByOrderBySaveDateAsc();
}
