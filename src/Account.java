public class Account {
	protected int id;
	protected String userID;
	protected int balance;
	protected int ppswapTotal;
	//account info (id, userID, money in account, amount of ppswap owned)
	public Account() {
		
	}
	
	public Account(int id) {
		this.id = id;
	}
	
	public Account(int id, String userID, int balance, int ppswapTotal) {
		this(userID, balance, ppswapTotal);
		this.id = id;
	}
	
	public Account(String userID, int balance, int ppswapTotal) {
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPpswapTotal() {
		return ppswapTotal;
	}

	public void setPpswapTotal(int ppswapTotal) {
		this.ppswapTotal = ppswapTotal;
	}

	
	
	
}