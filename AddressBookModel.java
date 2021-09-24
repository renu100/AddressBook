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

}
