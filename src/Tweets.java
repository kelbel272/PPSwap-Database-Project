public class Tweets {
	protected int id;
	protected String userID;
	protected String tweet;
	protected String created_at;
	protected String total_likes;
	protected String total_comments;
	
	public Tweets() {
		
	}
	
	public Tweets(int id) {
		this.id = id;
	}
	
	public Tweets(int id, String userID, String tweet, String created_at, String total_likes, String total_comments) {
		this(userID, tweet, created_at, total_likes, total_comments);
		this.id = id;
	}
	
	public Tweets(String userID, String tweet, String created_at, String total_likes, String total_comments) {
		this.userID = userID;
		this.tweet = tweet;
		this.created_at = created_at;
		this.total_likes = total_likes;
		this.total_comments = total_comments;
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

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getCreatedAt() {
		return created_at;
	}

	public void setCreatedAtt(String created_at) {
		this.created_at = created_at;
	}

	public String getTotalLikes() {
		return total_likes;
	}

	public void setTotalLikes(String total_likes) {
		this.total_likes = total_likes;
	}

	public String getTotalComments() {
		return total_comments;
	}

	public void setTotalComments(String total_comments) {
		this.total_comments = total_comments;
	}
	
	
}