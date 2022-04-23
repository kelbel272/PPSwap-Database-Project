public class UserFollowers {
	protected String userID;
	protected String followerID;
	
	public UserFollowers() {
		
	}
	
	
	public UserFollowers(String userID, String followerID) {
		this.userID = userID;
		this.followerID = followerID;
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
}