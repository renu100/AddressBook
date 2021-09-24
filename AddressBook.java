package com.DayAddressBook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressBook {
	private static final Logger log = LogManager.getLogger(AddressBook.class);

	public static void main(String[] args) {
		AddressBookService addressBookService =  new AddressBookService();
		addressBookService.addPerson();	
	}
}
