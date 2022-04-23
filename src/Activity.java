public class Activity {
	protected int id;
	protected String activityType;
	protected String createdAt;
	protected String userFROM;
	protected String userTO;
	protected int ppSent; 
	protected double dollarAmt;

	public Activity() {
		
	}
	
	public Activity(int id) {
		this.id = id;
	}
	
	public Activity(int id, String activityType, String createdAt, String userFROM, String userTO, int ppSent, double dollarAmt) {
		this(activityType, createdAt, userFROM, userTO, ppSent, dollarAmt);
		this.id = id;
	}
	
	public Activity(String activityType, String createdAt, String userFROM, String userTO, int ppSent, double dollarAmt) {
		this.activityType = activityType;
		this.createdAt = createdAt;
		this.userFROM = userFROM;
		this.userTO = userTO;
		this.ppSent = ppSent;
		this.dollarAmt = dollarAmt;
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
		return createdAt;
	}

	public void setCreated_at(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUser_FROM() {
		return userFROM;
	}

	public void setUser_FROM(String userFROM) {
		this.userFROM = userFROM;
	}

	public String getUser_TO() {
		return userTO;
	}

	public void setUser_TO(String userTO) {
		this.userTO = userTO;
	}

	public int getPpSent() {
		return ppSent;
	}

	public void setPpSent(int ppSent) {
		this.ppSent = ppSent;
	}
	
	public double getDollatAmt() {
		return dollarAmt;
	}
	
	public void setDollarAmt(double dollarAmt) {
		this.dollarAmt = dollarAmt;
	}

	
}
	