public class Account {
	protected int id;
	protected String userID;
	protected double balance;
	protected int ppswapTotal;
	//account info (id, userID, money in account, amount of ppswap owned)
	public Account() {
		
	}
	
	public Account(int id) {
		this.id = id;
	}
	
	public Account(int id, String userID, double balance, int ppswapTotal) {
		this(userID, balance, ppswapTotal);
		this.id = id;
	}
	
	public Account(String userID, double balance, int ppswapTotal) {
		this.userID = userID;
		this.balance = balance;
		this.ppswapTotal = ppswapTotal;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPpswapTotal() {
		return ppswapTotal;
	}

	public void setPpswapTotal(int ppswapTotal) {
		this.ppswapTotal = ppswapTotal;
	}

	
	
	
}