package com.DayAddressBook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressBook {
	private static final Logger log = LogManager.getLogger(AddressBook.class);

	public static void main(String[] args) {
		AddressBookModel addressBookModel = new AddressBookModel("Renu", "Chandraker", 957648922, "renu@123", "btm",
				"Karnatka", "Bangalore", 560074);
		log.info(addressBookModel);
	}
}
