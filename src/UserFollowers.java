public class UserFollowers {
	protected int id;
	protected String userID;
	protected String followerID;
	protected String created_at;
	
	public UserFollowers() {
		
	}
	
	public UserFollowers(int id) {
		this.id = id;
	}
	
	public UserFollowers(int id, String userID, String followerID, String created_at) {
		this(userID, followerID, created_at);
		this.id = id;
	}
	
	public UserFollowers(String userID, String followerID, String created_at) {
		this.userID = userID;
		this.followerID = followerID;
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

	public String getFollowerID() {
		return followerID;
	}

	public void setPostID(String followerID) {
		this.followerID = followerID;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}