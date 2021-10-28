package com.DayAddressBook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookService {
	private static final Logger log = LogManager.getLogger(AddressBookService.class);

	private static final Map<String, Addresses> dictionary = new HashMap<>();

	public boolean createAddressBook(String name) {
		if (dictionary.containsKey(name)) {
			System.out.println("Addressbook already exist");
			return true;
		}
		dictionary.put(name, new Addresses());
		this.printAddressBooksNames();
		return true;
	}

	public void printAddressBooksNames() {
		dictionary.keySet().forEach(System.out::println);
	}

	public Addresses getAddressBook(String name) {
		return dictionary.get(name);
	}

	public boolean deleteAddressBook(String name) {
		if (dictionary.containsKey(name)) {
			dictionary.remove(name);
			return true;
		}
		return false;
	}

	public class Addresses {

		ArrayList<AddressBookModel> addressBookModels = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		// creating a method
		public void addPerson() {

			log.info("enter First name");
			String firstname = sc.next();

			uniquePerson(firstname);

			log.info("enter Last name");
			String lastname = sc.next();

			log.info("enter Address");
			String address = sc.next();

			log.info("enter city name");
			String cityname = sc.next();

			log.info("enter state name");
			String stateName = sc.next();

			log.info("enter email id");
			String emailid = sc.next();

			log.info("enter zip code");
			int zipcode = sc.nextInt();

			log.info("enter Phone number");
			int phonenumber = sc.nextInt();

			AddressBookModel addressBookModel = new AddressBookModel(firstname, lastname, phonenumber, emailid, address,
					stateName, cityname, zipcode);
			addressBookModels.add(addressBookModel);
			log.info(addressBookModel);
		}

		/**
		 * create a method for edit person details
		 */
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

		/**
		 * method creation for printing data
		 */
		public void printAddressBook() {
			for (AddressBookModel aBookModel : addressBookModels) {
				log.info(aBookModel);
			}

		}

		/**
		 * method creation for delete person
		 */
		public void deletePerson() {
			log.info("enter person first name you want to delete");
			String firstName = sc.nextLine();
			boolean flag = false;
			for (AddressBookModel cont : addressBookModels) {
				if (cont.getFirstName().equals(firstName)) {
					addressBookModels.remove(cont);
					flag = true;
					break;
				}
			}
			if (flag == true) {
				System.out.println("deleted succesfully");
			} else {
				System.out.println("Please enter a valid name");
			}
		}

		/**
		 * method creation for unique person
		 */
		public String uniquePerson(String name) {
			for (AddressBookModel addressBookModel : addressBookModels) {
				if (addressBookModel.getFirstName().equals(name)) {
					log.info("Person already exist");
					addPerson();
				}
			}
			return null;
		}

		// Call this to do this
		public void driver() {
			while (true) {
				log.info("Welcome to Address Book");
				log.info(
						"1 Add\n2 Edit \n3 Delete\n4 Print\n5 Serach Person By City/State\n6 View person by City/State\n7 Person count by City/State");
				log.info("Enter option");
				int option = sc.nextInt();
				sc.nextLine();

				if (option == 8)
					break;
				switch (option) {
				case 1:
					this.addPerson();
					break;
				case 2:
					this.editPerson();
					break;
				case 3:
					this.deletePerson();
					break;
				case 4:
					this.printAddressBook();
					break;
				case 5:
					this.searchPersonByCity();
					break;

				case 6:
					this.viewByCityOrState();
					break;
				case 7:
					this.countByCityOrState();
					break;
				default:
					log.info("Invalid Choice");
				}
			}

		}

		public void searchPersonByCity() {
			int option = 0;
			int EXIT_VALUE = 3;
			while (option != EXIT_VALUE) {
				log.info(
						"Enter your choice \n1. person details by city \n2. person details by state \nEXIT_VALUE. Exit");
				option = sc.nextInt();
				switch (option) {
				case 1:
					log.info("Enter city name ");
					String city = sc.next();
					List<AddressBookModel> personCity = addressBookModels.stream()
							.filter(person1 -> (person1.getCity().equals(city))).collect(Collectors.toList());
					log.info("Persons in city: " + personCity);
					break;

				case 2:
					log.info("Enter state name ");
					String state = sc.next();
					List<AddressBookModel> personState = addressBookModels.stream()
							.filter(person1 -> (person1.getState().equals(state))).collect(Collectors.toList());
					log.info("Persons in city: " + personState);
					break;
				default:
					break;
				}
			}

		}

		/*
		 * method to search a particular contact based on city or state
		 */
		public void viewByCityOrState() {
			int option = 0;
			int EXIT_VALUE = 3;
			while (option != EXIT_VALUE) {
				log.info("Enter your choice \n1. person details by city \n2. person details by state \n3.Exit");
				option = sc.nextInt();
				switch (option) {
				case 1:
					String city;
					Dictionary infoCity = new Hashtable();
					log.info("Enter city name:");
					city = sc.next();
					List<AddressBookModel> streamList = addressBookModels.stream()
							.filter(person1 -> city.equals(person1.getCity())).collect(Collectors.toList());
					log.info("Persons in city: " + streamList);
					for (AddressBookModel a : addressBookModels) {
						if (a.city.equals(city)) {
							infoCity.put(a.firstName, city);
						}
					}
					log.info("The Dictionary Contains:" + infoCity);
					break;

				case 2:
					log.info("Enter state name ");
					String state;
					Dictionary infoState = new Hashtable();
					state = sc.next();
					List<AddressBookModel> streamList1 = addressBookModels.stream()
							.filter(person1 -> state.equals(person1.getState())).collect(Collectors.toList());
					log.info("Persons in state: " + streamList1);
					for (AddressBookModel a : addressBookModels) {
						if (a.state.equals(state)) {
							infoState.put(a.firstName, state);
						}
					}
					log.info("The Dictionary Contains:" + infoState);
					break;
				default:
					break;
				}
			}

		}

		/**
		 * Method to count person by city or state
		 */
		public void countByCityOrState() {
			int option = 0;
			int EXIT_VALUE = 3;
			while (option != EXIT_VALUE) {
				log.info("Enter your choice \n1. count person by city \n2. count person by state \n3.Exit");
				option = sc.nextInt();
				switch (option) {
				case 1:
					String city;
					log.info("Enter city name:");
					city = sc.next();
					int countCity = (int) addressBookModels.stream().filter(person1 -> city.equals(person1.getCity()))
							.count();
					System.out.println("Total Person Count in " + city + " city is:" + countCity);
					break;

				case 2:
					String state;
					log.info("Enter state name ");
					state = sc.next();
					int countState = (int) addressBookModels.stream()
							.filter(person1 -> state.equals(person1.getState())).count();
					System.out.println("Total Person Count in " + state + " state is:" + countState);
					break;
				default:
					break;
				}
			}

		}
	}

}
