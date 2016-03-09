package eu.lowentropy.articleannotater.facebook.me;

public class FacebookMe {
	private Long id;
	private String email;
	private String name;
	private Picture picture;

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public Picture getPicture() {
		return picture;
	}

	public class Picture {
		private Data data;

		public Data getData() {
			return data;
		}

		public class Data {
			private String url;
			public String getUrl() {
				return url;
			}
		}
	}
}
