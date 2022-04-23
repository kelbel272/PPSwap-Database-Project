public class TweetComments {
	protected int id;
	protected int TweetID;
	protected String userID;
	protected String comment;
	protected String created_at;
	
	public TweetComments() {
		
	}
	
	public TweetComments(int id) {
		this.id = id;
	}
	
	public TweetComments(int id, int TweetID, String userID, String comment, String created_at) {
		this(TweetID, userID, comment, created_at);
		this.id = id;
	}
	
	public TweetComments(int TweetID, String userID, String comment, String created_at) {
		this.TweetID = TweetID;
		this.userID = userID;
		this.comment = comment;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTweetID() {
		return TweetID;
	}

	public void setTweetID(int TweetID) {
		this.TweetID = TweetID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(String created_at) {
		this.created_at = created_at;
	}

	
}