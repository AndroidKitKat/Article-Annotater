package eu.lowentropy.articleannotater.model;

import java.util.Date;

public class Comment {

	 private String face;
	    private String who;
	    private Date when;
	    private String notes;

		public String getFace() {
			return face;
		}

		public String getWho() {
			return who;
		}

		public Date getWhen() {
			return when;
		}

		public String getNotes() {
			return notes;
		}
}
