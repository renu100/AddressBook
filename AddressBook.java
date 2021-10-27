package com.DayAddressBook;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.DayAddressBook.AddressBookService.Addresses;

public class AddressBook {
	private static final Logger log = LogManager.getLogger(AddressBook.class);
	public static void main(String[] args) {
			AddressBookService addressBook = new AddressBookService();
			Scanner sc = new Scanner(System.in);
			while (true) {

				System.out.println("1 Print\n2 Create \n3 Select Existing\n4 Delete\n5 Exit");
				int choice = sc.nextInt();
				if (choice == 5)
					break;

				switch (choice) {
				case 1:
					addressBook.printAddressBooksNames();
					break;
				case 2:
					System.out.println("Enter new Bookname");
					sc.nextLine();
					String bookName = sc.nextLine();
					addressBook.createAddressBook(bookName);
					break;
				case 3:
					addressBook.printAddressBooksNames();
					System.out.println("Enter Bookname to select");
					sc.nextLine();
					bookName = sc.next();
					Addresses ad1 = addressBook.getAddressBook(bookName);
					ad1.driver();
					break;
				case 4:
					System.out.println("Enter Bookname to delete");
					sc.nextLine();
					bookName = sc.next();
					addressBook.deleteAddressBook(bookName);
					addressBook.printAddressBooksNames();
					break;

				}
			}
		}
}
