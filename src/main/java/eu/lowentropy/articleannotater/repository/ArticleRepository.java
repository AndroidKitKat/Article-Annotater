package eu.lowentropy.articleannotater.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eu.lowentropy.articleannotater.model.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {

}
