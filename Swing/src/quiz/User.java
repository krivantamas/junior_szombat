package quiz;

public class User {

	private final String userName;
	private int score;

	public User(String userName, int score) {
		this.userName = userName;
		this.score = score;
	}
	
	public User(String userName) {
		this(userName,0);
	}

	public String getUserName() {
		return userName;
	}

	public int getScore() {
		return score;
	}
	

	@Override
	public String toString() {
		return "User [userName=" + userName + ", score=" + score + "]";
	}

}
