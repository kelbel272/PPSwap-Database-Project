public class TweetComments {
	protected int id;
	protected int postID;
	protected String userID;
	protected String comment;
	protected String created_at;
	
	public TweetComments() {
		
	}
	
	public TweetComments(int id) {
		this.id = id;
	}
	
	public TweetComments(int id, int postID, String userID, String comment, String created_at) {
		this(postID, userID, comment, created_at);
		this.id = id;
	}
	
	public TweetComments(int postID, String userID, String comment, String created_at) {
		this.postID = postID;
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

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
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