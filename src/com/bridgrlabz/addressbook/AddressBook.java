package com.bridgrlabz.addressbook;

import java.util.*;
import java.util.Map.Entry;
import java.util.Scanner;

public class AddressBook {
	static Contacts addressBook;
	static Map<String, Contacts> dictionary = new HashMap<String, Contacts>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		int userValue = 0;
		do 
		{
			System.out.println(
					"Enter choice from the below list :\n1.Add \n2.Exit \n3.Print all contacts \n4.Edit contacts \n5.Delete contact");
			userValue = scanner.nextInt();
			switch (userValue) 
			{
			case 1: 
			{
				addUser();
				break;
			}
			case 2:
			{
				System.exit(0);
				break;
			}
			case 3: 
			{
				printAllContacts();
				break;
			}
			case 4: 
			{
				EditUser();
				break;
			}
			case 5: 
			{
				deleteUser();
				break;
			}
			case 6:
			{
				searchByCityOrState_ShouldReturnFirstName();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + userValue);
			}
		} while (userValue != 2);
	}
//to delete contact from the hash map
	private static void deleteUser() 
	{
		System.out.println("Enter first name :");
		String firstName = scanner.next();
		if (!checkUserExist(firstName)) {
			dictionary.remove(firstName);
		} else
			System.out.println(firstName + " user does not exist");
	}
//to print all contacts in the hashmap
	private static void printAllContacts() 
	{
		dictionary.forEach((key, value) -> {
			System.out.println(value);
		});

	}
//adding values in the Hashmap
	public static void addUser() {
		addressBook = new Contacts();
		System.out.println("Enter First Name : ");
		addressBook.setFirst(scanner.next());
		//checking for duplicate values
		if (checkUserExist(addressBook.getFirst())) {
			System.out.println("Enter Last Name :");
			addressBook.setLast(scanner.next());
			System.out.println("Enter address :");
			addressBook.setAddress(scanner.next());
			System.out.println("Enter City");
			addressBook.setCity(scanner.next());
			System.out.println("Enter State");
			addressBook.setState(scanner.next());
			System.out.println("Enter Zip :");
			addressBook.setZip(scanner.nextInt());
			System.out.println("Enter Phone Number :");
			addressBook.setPhoneNumber(scanner.nextInt());
			System.out.println("Enter email :");
			addressBook.setEmail(scanner.next());

			dictionary.put(addressBook.getFirst(), addressBook);
		} else
			System.out.println("User already exist with name " + addressBook.getFirst());
	}
// to edit user details using first name 
	public static void EditUser() {
		addressBook = new Contacts();
		System.out.println("Enter First Name : ");
		addressBook.setFirst(scanner.next());
		//to check if the contact exist
		if (!checkUserExist(addressBook.getFirst())) {
			System.out.println("Enter Last Name :");
			addressBook.setLast(scanner.next());
			System.out.println("Enter address :");
			addressBook.setAddress(scanner.next());
			System.out.println("Enter City");
			addressBook.setCity(scanner.next());
			System.out.println("Enter State");
			addressBook.setState(scanner.next());
			System.out.println("Enter Zip :");
			addressBook.setZip(scanner.nextInt());
			System.out.println("Enter Phone Number :");
			addressBook.setPhoneNumber(scanner.nextInt());
			System.out.println("Enter email :");
			addressBook.setEmail(scanner.next());

			dictionary.remove(addressBook.getFirst());

			dictionary.put(addressBook.getFirst(), addressBook);
		} else
			System.out.println("User doesnt exists with username : " + addressBook.getFirst());
	}
//to check user existence in the hashmap 
	private static boolean checkUserExist(String first) {
		if (dictionary.containsKey(first)) {
			return false;
		}
		return true;
	}
	
	private static void searchByCityOrState_ShouldReturnFirstName() 
	{
		System.out.println("Enter the City or State to view all person ");
		String searchingValue = scanner.next();
		dictionary.forEach((key, value) -> 
		{
			if (value.getCity().equals(searchingValue) || value.getState().equals(searchingValue)) 
			{
				System.out.println(key);
			}
		});
	}
}
