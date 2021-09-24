package com.DayAddressBook;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressBook {
	private static final Logger log = LogManager.getLogger(AddressBook.class);

	public static void main(String[] args) {
		AddressBookService addressBookService = new AddressBookService();
		final int EXIT_VALUE = 5;
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		while (choice != EXIT_VALUE) {
			log.info("1.Add Person\n2.Edit Person\n3.Print Person\n4.Delete person\n" + EXIT_VALUE + ".Exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addressBookService.addPerson();
				break;
			case 2:
				addressBookService.editPerson();
				break;
			case 3:
				addressBookService.printAddressBook();
				break;
			case 4:
				addressBookService.deletePerson();
				break;	
			default:
				break;
			}
		}
	}
}
