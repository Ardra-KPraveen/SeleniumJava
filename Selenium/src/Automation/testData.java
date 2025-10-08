package Automation;

public class testData {
	//setting private fields
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	private String city;
	private String state;
	private String postalcode;
	private String userName;
	private String password;
	//private String confirmPassword;
	
	//creating constructors to set data internally
	public testData() {
		this.firstName="John";
		this.lastName="Abraham";
		this.phone="6282467812";
		this.email="johnAb@gmail.com";
		this.address="India,Kerala";
		this.city="Thiruvananthapuram";
		this.state="Kerala";
		this.postalcode="680951";
		this.userName="QATester";
		this.password="Qa@123";
		//this.confirmPassword="Qa@123";
	}

	// Getters only for read-only access
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	/*public String getConfirmPassword() {
		return confirmPassword;
	}*/
	
	
	

}
