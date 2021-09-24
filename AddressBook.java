package com.DayAddressBook;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressBook {
	private static final Logger log = LogManager.getLogger(AddressBook.class);

	public static void main(String[] args) {
		AddressBookService addressBookService = new AddressBookService();
		final int EXIT_VALUE = 4;
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		while (choice != EXIT_VALUE) {
			System.out.println("1.Add Person\n2.Edit Person\n3.Print Person\n" + EXIT_VALUE + ".Exit");
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
			default:
				break;
			}
		}
	}
}
