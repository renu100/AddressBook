package com.DayAddressBook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookService {

	private static final Logger log = LogManager.getLogger(AddressBookService.class);

	ArrayList<AddressBookModel> addressBookModels = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
   //creating a method
	public void addPerson() {

		log.info("enter First name");
		String firstname = sc.next();

		log.info("enter Last name");
		String lastname = sc.next();

		log.info("enter Address");
		String address = sc.next();

		log.info("enter city name");
		String cityname = sc.next();

		log.info("enter email id");
		String emailid = sc.next();

		log.info("enter zip code");
		int zipcode = sc.nextInt();

		log.info("enter Phone number");
		int phonenumber = sc.nextInt();

		AddressBookModel addressBookModel = new AddressBookModel(firstname, lastname, phonenumber, emailid, address,
				emailid, cityname, zipcode);
		addressBookModels.add(addressBookModel);
		log.info(addressBookModel);
	}

	public void editPerson() {
		int choice = 1;
		final int exit = 7;
		boolean flag = false;
		log.info("enter person first name you want to edit");
		String firstName = sc.next();
		while (choice != exit) {
			for (AddressBookModel addressBookModel : addressBookModels) {
				if (addressBookModel.getFirstName().equals(firstName)) {
					flag = true;
					log.info("Hi  " + addressBookModel.getFirstName());
					log.info("which field you want to edit\n1. Address\n2. City\n3. State\n4. Zipcode\n"
							+ "5. Phone Number\n6. Email\n7. Exit");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						log.info("Please edit your address");
						String address = sc.nextLine();
						sc.next();
						addressBookModel.setAddress(address);
						break;
					case 2:
						log.info("Please edit your city");
						String city = sc.next();
						addressBookModel.setCity(city);
						break;
					case 3:
						log.info("Please edit your state");
						String state = sc.next();
						addressBookModel.setState(state);
						break;
					case 4:
						log.info("Please edit your zip");
						int zip = sc.nextInt();
						addressBookModel.setZip(zip);
						break;
					case 5:
						log.info("Please edit your phone number");
						int phone = sc.nextInt();
						addressBookModel.setPhoneNo(phone);
						break;
					case 6:
						log.info("Please edit your email address");
						String email = sc.next();
						addressBookModel.setEmail(email);
						break;
					}
				}
			}
			if (flag == false) {
				log.info("person didn't found");
				break;
			} else {
				log.info("your contact details have been successfully updated");
			}
		}

	}
	
	public void printAddressBook() {
		for (AddressBookModel aBookModel : addressBookModels) {
			System.out.println(aBookModel);
		}

	}

}
