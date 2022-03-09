public class Activity {
	protected int id;
	protected String activityType;
	protected String created_at;
	protected String user_FROM;
	protected String user_TO;
	protected int ppSent; 

	public Activity() {
		
	}
	
	public Activity(int id) {
		this.id = id;
	}
	
	public Activity(int id, String activityType, String created_at, String user_FROM, String user_TO, int ppSent) {
		this(activityType, created_at, user_FROM, user_TO, ppSent);
		this.id = id;
	}
	
	public Activity(String activityType, String created_at, String user_FROM, String user_TO, int ppSent) {
		this.activityType = activityType;
		this.created_at = created_at;
		this.user_FROM = user_FROM;
		this.user_TO = user_TO;
		this.ppSent = ppSent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUser_FROM() {
		return user_FROM;
	}

	public void setUser_FROM(String user_FROM) {
		this.user_FROM = user_FROM;
	}

	public String getUser_TO() {
		return user_TO;
	}

	public void setUser_TO(String user_TO) {
		this.user_TO = user_TO;
	}

	public int getPpSent() {
		return ppSent;
	}

	public void setPpSent(int ppSent) {
		this.ppSent = ppSent;
	}

	
}
	