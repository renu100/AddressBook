package com.DayAddressBook;

public class AddressBookModel {
	String firstName;
	String lastName;
	int phoneNo;
	String email;
	String address;
	String state;
	String city;
	int zip;

	// Constructor
	public AddressBookModel(String firstName, String lastName, int phoneNo, String email, String address, String state,
			String city, int zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "AddressBookModel [firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", address=" + address + ", state=" + state + ", city=" + city + ", zip=" + zip
				+ "]";
	}

	// using Setter getter method
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

}
