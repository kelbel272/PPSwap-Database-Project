public class UserFeeds {
	protected int id;
	protected String userID;
	protected int postID;
	protected String created_at;
	
	public UserFeeds() {
		
	}
	
	public UserFeeds(int id) {
		this.id = id;
	}
	
	public UserFeeds(int id, String userID, int postID, String created_at) {
		this(userID, postID, created_at);
		this.id = id;
	}
	
	public UserFeeds(String userID, int postID, String created_at) {
		this.userID = userID;
		this.postID = postID;
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