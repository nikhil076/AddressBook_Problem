package com.bridgrlabz.addressbook;

import java.util.Scanner;

public class AddressBook 
{
	static Contacts addressBook;

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) 
	{
		int numberOfContacts;
		System.out.println("Enter number of required contacts :");

		try {
			numberOfContacts = scanner.nextInt();
			
			Contacts arrayOfContacts[] = new Contacts[numberOfContacts];
			for (int index = 0; index < numberOfContacts; index++)
			{
				addressBook = new Contacts();
				System.out.println("Enter First Name : ");
				addressBook.setFirst(scanner.next());
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
				System.out.println("Enter email :"); addressBook.setEmail(scanner.next());
				 
				arrayOfContacts[index] = addressBook;				
			}
			
				for (Contacts addContact : arrayOfContacts) 
				{
				System.out.println(addContact); 
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
