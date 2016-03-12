package eu.lowentropy.articleannotater.commentator;

import eu.lowentropy.articleannotater.model.Comment;

public class CommentDto {
	private String articleId;
    private Comment comment;

	public String getArticleId() {
		return articleId;
	}

	public Comment getComment() {
		return comment;
	}
}
