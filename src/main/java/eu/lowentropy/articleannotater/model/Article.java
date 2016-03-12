package eu.lowentropy.articleannotater.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Article {

	@Id
	private String url;

	private String text;

	private List<Comment> comments;

	public Article(String url, String text) {
		this.url = url;
		this.text = text;
		this.comments = new ArrayList<>();
	}

	public String getText() {
		return text;
	}

	public String getUrl() {
		return url;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}
}
