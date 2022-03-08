public class TweetLikes {
	protected int id;
	protected int postID;
	protected String userID;
	protected String created_at;
	
	public TweetLikes() {
		
	}
	
	public TweetLikes(int id) {
		this.id = id;
	}
	
	public TweetLikes(int id, int postID, String userID, String created_at) {
		this(postID, userID, created_at);
		this.id = id;
	}
	
	public TweetLikes(int postID, String userID, String created_at) {
		this.postID = postID;
		this.userID = userID;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}