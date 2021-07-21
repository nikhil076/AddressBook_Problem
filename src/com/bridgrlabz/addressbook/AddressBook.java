package com.bridgrlabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sun.jdi.Value;

public class AddressBook {
	public static String ADDRESSBOOK_FILENAME = "./somefile.txt";
	static int count = 0;
	static Contacts addressBook;
	static List<Contacts> contact = new ArrayList<>();
	static Map<String, Contacts> dictionary = new HashMap<String, Contacts>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		int userValue = 0;
		do 
		{
			System.out.println(
					"Enter choice from the below list :\n1.Add \n2.Exit \n3.Print all contacts \n4.Edit contacts \n5.Delete contact\n6.To get all persons in same city or state\n7.To get all contacts details of user in same city or state\n8.To get number of contacts with same city or state\n9.To sort contact by first name");
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
			case 7:
			{
				searchByCityOrState_ShouldReturnContacts();
				break;
			}
			case 8 :
			{
				searchByCityOrState_ShouldReturnNoOfContacts();
				break;
			}
			case 9:
			{
				sortEntryInAddressBookAlphabeticallyByFirstName();
				break;
			}
			case 10:
			{
				sortAccordingToCityStateOrZip();
				break;
			}
			case 11:
			{
				writeDataIntoFile();
				break;
			}
			case 12:
			{
				readDataFromFile();
				break;
			}
			case 13:
			{
				printData();
				break;
			}
			case 14:
			{
				display();
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
		System.out.println(dictionary.values().stream().filter(dictionary -> dictionary.getCity().equals(searchingValue) || dictionary.getState().equals(searchingValue)).map(temp -> temp.first).collect(Collectors.toList()));
	}
	private static void searchByCityOrState_ShouldReturnContacts() 
	{
		System.out.println("Enter the City or State to view all contact details ");
		String searchingValue = scanner.next();
		System.out.println(dictionary.values().stream().filter(dictionary -> dictionary.getCity().equals(searchingValue) || dictionary.getState().equals(searchingValue)).collect(Collectors.toList()));
	}
	private static void searchByCityOrState_ShouldReturnNoOfContacts() 
	{
		System.out.println("Enter the City or State to view number of contacts with that detail ");
		String searchingValue = scanner.next();
		System.out.println("Number of person with same city or state is :"+dictionary.values().stream().filter(temp -> temp.getCity().equals(searchingValue) || temp.getState().equals(searchingValue)).count());
	}
	private static void sortEntryInAddressBookAlphabeticallyByFirstName() 
	{
		System.out.println(dictionary.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()));
	}
	private static void sortAccordingToCityStateOrZip()
	{
		List<Contacts> contactDetailList = dictionary.stream().filter(person1 -> person1.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        contactDetailList.stream().forEach(System.out::println);
        Map<String, Contacts> map = contactDetailList.stream().collect(Collectors.toMap(Contacts::getFirst, contactDetail -> contactDetail));
        System.out.println();	
    }
	//To write contact details in file 
	public static void writeDataIntoFile()
	{
		List<Contacts> contactsList = new ArrayList<>();
		StringBuffer addressBuffer = new StringBuffer();
		contactsList.forEach(address -> {
			String addressDataString = address.toString().concat("\n");
			addressBuffer.append(addressDataString);
		});
		try 
		{
			Files.write(Paths.get(ADDRESSBOOK_FILENAME), addressBuffer.toString().getBytes());
		} catch (Exception e) 
		{
		}
	}
	
	//to read Contact details from file 
	public static List<Contacts> readDataFromFile()
	{	
		List<Contacts> contactDetailList = new ArrayList<>();
		try 
		{
			Files.lines(new File(ADDRESSBOOK_FILENAME).toPath()).map(line -> line.trim()).forEach(line -> System.out.println(line));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contactDetailList;
	}
	//to print data in the file
	public static void printData()
	{
		try 
		{
			Files.lines(new File(ADDRESSBOOK_FILENAME).toPath()).forEach(System.out::println);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void display()
	{
		for (Contacts contactDetails : contact) {
			System.out.println(contactDetails);
		}
	}
}
