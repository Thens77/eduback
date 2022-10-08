package ma.emsi.edu.auth;

public class AuthenticationResponse {
	private String accessToken;
	private String userName;
	private String role;
	
	

	public AuthenticationResponse(String accessToken, String userName, String role) {
		super();
		this.accessToken = accessToken;
		this.userName = userName;
		this.role = role;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [accessToken=" + accessToken + ", userName=" + userName + ", role=" + role + "]";
	}

	
}