package ru.myhome.test;

public class TestUser {
	
	private String userName;
	private String password;
	
	public TestUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public TestUser() {
		this.userName = "admin";
		this.password = "root";
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("set name: " + getUserName());
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public boolean equals(Object o) {
        System.out.println(o);
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestUser user = (TestUser) o;
        return userName.equals(user.getUserName()) &&
        		password.equals(user.getPassword());
    }

	@Override
	public String toString() {
		return "TestUser [userName=" + userName + ", password=" + password + "]";
	}
	
}
