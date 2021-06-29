package com.bridgrlabz.addressbook;

import java.util.Scanner;

public class AddressBook 
{
	static Contacts addressBook;
	static Contacts arrayOfContacts[];
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) 
	{
		int numberOfContacts;
		System.out.println("Enter number of required contacts :");
		numberOfContacts = scanner.nextInt();
			
		arrayOfContacts = new Contacts[numberOfContacts];
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
			System.out.println("Enter email :");
			addressBook.setEmail(scanner.next());
			 
			arrayOfContacts[index] = addressBook;				
		}
		printAllContacts();
		System.out.println("Enter the name to edit details :");
		String checkName = scanner.next();
		Contacts contacts[] = new Contacts[numberOfContacts];
		String name[]= new String[numberOfContacts];
		System.out.println("Enter the name to Delete thaaat contact :");
		String checkValue = scanner.next();
		editContacts(checkName);
		deleteUser(checkValue,name);
		
	}
	
	public static void printAllContacts() 
	{
		for (Contacts addContact : arrayOfContacts) 
		{
			System.out.println(addContact); 
		}
	}
	
	public static void editContacts(String checkValue)
	{
		System.out.println("Enter the name to check for details :");
		for(int i =0 ;i<arrayOfContacts.length;i++)
		{
			if(arrayOfContacts[i].getFirst().equals(checkValue))
			{
				System.out.println("Record Found");
				addressBook = new Contacts();
				addressBook = arrayOfContacts[i];
				System.out.println(arrayOfContacts[i]);
				System.out.println("Enter '1' to change First Name \nEnter '2' to change Last Name \nEnter '3' to change Address \nEnter '4' to change City  \nEnter '5' to change state ");
				int number = scanner.nextInt();
				switch (number) {
				case 1: {
					System.out.println("Enter the new first Name :");
					addressBook.setFirst(scanner.next());
					System.out.println("New Record :"+arrayOfContacts[i]);
					break;
				}
				case 2: {
					System.out.println("Enter the new second Name :");
					addressBook.setLast(scanner.next());
					System.out.println("New Record :"+arrayOfContacts[i]);
					break;
				}
				case 3: {
					System.out.println("Enter the new Address :");
					addressBook.setAddress(scanner.next());
					System.out.println("New Record :"+arrayOfContacts[i]);
					break;
				}
				case 4: {
					System.out.println("Enter the new City :");
					addressBook.setAddress(scanner.next());
					System.out.println("New Record :"+arrayOfContacts[i]);
					break;
				}
				case 5: {
					System.out.println("Enter the new State :");
					addressBook.setState(scanner.next());
					System.out.println("New Record :"+arrayOfContacts[i]);
					break;
				}
				default:
					System.out.println("Invalid Numbers");
				}
			}
		}
	}
	
	public static void deleteUser(String name,String[] user)
	{
		System.out.println("Enter the name to check for details :");
		for(int i =0 ;i<arrayOfContacts.length;i++)
		{
			
			if(arrayOfContacts[i].getFirst().equals(name))
			{
				for(int j=0;j<user.length;j++)
				{
					if(user[j]!=null) {
						continue;
					}
					else {
						user[j]=name;
					}
				}
			}
		}		
		for(int i =0;i<arrayOfContacts.length;i++)
		{
			int refactor=0;
			for(int j =0;j<user.length;j++)
			{
				if(arrayOfContacts[i].getFirst().equals(user[j]))
				{
					refactor=1;
					continue;
				}
			}
			if(refactor==0)
			{
				System.out.println(arrayOfContacts[i]);
			}	
		}
	}
}
