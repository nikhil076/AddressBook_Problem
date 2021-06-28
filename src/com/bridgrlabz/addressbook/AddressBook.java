package com.bridgrlabz.addressbook;

import java.util.Scanner;


public class AddressBook
{
	private String first;
	private String last;
	private String address;
	private String city;
	private String state;
	private int zip;
	private int phoneNumber;
	private String email;
	static AddressBook addressBook;

	static Scanner scanner = new Scanner(System.in);

	public AddressBook(String first, String last, String address,String city,int zip,int phoneNumber,String state, String email) 
	{
		this.last = last;
		this.first = first;
		this.email = email;
		this.address = address;
		this.city= city;
		this.state= state;
		this.zip=zip;
		this.phoneNumber= phoneNumber;
	}

	public AddressBook()
	{
		super();
	}

	public void readEntry()
	{
		System.out.println("First Name:" + first);
		System.out.println("Last Name:" + last);
		System.out.println("Address:" + address);
		System.out.println("city :"+city);
		System.out.println("State :"+state);
		System.out.println("Zip :"+zip);
		System.out.println("Phone Number :"+phoneNumber);
		System.out.println("Email:" + email);
	}

	public String getFirst()
	{
		return first;
	}

	public void setFirst(String first) 
	{
		this.first = first;
	}

	public String getLast()
	{
		return last;
	}

	public void setLast(String last)
	{
		this.last = last;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void editEntry()
	{

	}
	
	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}
	
	public int getZip()
	{
		return zip;
	}

	public void setZip(int zip) 
	{
		this.zip = zip;
	}
	
	
	public int getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString()
	{
		return "AddressBook [first=" + first + ", last=" + last + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	public static void main(String[] args)
	{
			addressBook = new AddressBook();
			AddressBook arrayOfContacts[] = new AddressBook[1];
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
				arrayOfContacts[1] = addressBook;	
				
			System.out.println();

			for (AddressBook addContact : arrayOfContacts) {
				System.out.println(addContact);
			}
	} 
}
