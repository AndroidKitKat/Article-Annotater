package eu.lowentropy.articleannotater.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Article {

	@Id
	private String url;

	private String title;

	private String leadImageUrl;

	private String text;

	private List<Comment> comments;

	private Date saveDate;

	protected Article() {
		this.comments = new ArrayList<>();
	}

	private Article(Builder builder) {
		this.url = builder.url;
		this.title = builder.title;
		this.leadImageUrl = builder.leadImageUrl;
		this.text = builder.text;
		this.comments = builder.comments;
		this.saveDate = builder.saveDate;
	}

	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	public String getLeadImageUrl() {
		return leadImageUrl;
	}

	public String getText() {
		return text;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String url;
		private String title;
		private String leadImageUrl;
		private String text;
		private List<Comment> comments;
		private Date saveDate;

		public Builder url(String url) {
			this.url = url;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder leadImageUrl(String leadImageUrl) {
			this.leadImageUrl = leadImageUrl;
			return this;
		}

		public Builder text(String text) {
			this.text = text;
			return this;
		}


		public Builder comments(List<Comment> comments) {
			this.comments = comments;
			return this;
		}

		public Builder saveDate(Date saveDate) {
			this.saveDate = saveDate;
			return this;
		}

		public Article build() {
			return new Article(this);
		}
	}
}
