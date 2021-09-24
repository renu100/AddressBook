package com.DayAddressBook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AddressBookService {

	private static final Logger log = LogManager.getLogger(AddressBookService.class);

	public void addPerson() {
		Scanner sc = new Scanner(System.in);
		log.info("enter First name");
		String firstname = sc.nextLine();

		log.info("enter Last name");
		String lastname = sc.nextLine();

		log.info("enter Address");
		String address = sc.nextLine();

		log.info("enter city name");
		String cityname = sc.nextLine();

		log.info("enter email id");
		String emailid = sc.nextLine();

		log.info("enter zip code");
		int zipcode = sc.nextInt();

		log.info("enter Phone number");
		int phonenumber = sc.nextInt();

		AddressBookModel addressBookModel = new AddressBookModel(firstname, lastname, phonenumber, emailid, address,
				emailid, cityname, zipcode);
		log.info(addressBookModel);
	}

}
