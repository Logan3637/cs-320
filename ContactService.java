package Contacts;

//imports

import java.util.ArrayList;


public class ContactService 
{
	//build array
	private ArrayList<Contact> contacts = new ArrayList<>();
	
	//add to it
	public void addContact(Contact contact)
	{
		if (contact == null)
		{
			throw new IllegalArgumentException("Cant be Null");
		}
		for (Contact c : contacts)
		{
			if (c.getContactId().equals(contact.getContactId()))
			{
				throw new IllegalArgumentException("Id Already exists");
			}
		}
		contacts.add(contact);	
	}
	
	//delete contact
	public void deleteContact(String contactId)
	{
		for (int i=0; i < contacts.size(); i++)
		{
			if (contacts.get(i).getContactId().equals(contactId))
			{
				contacts.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("No Id Found");
	}
	
	
	//update first
	public void updateFirstName(String contactId, String firstName)
	{
		for (Contact c : contacts)
		{
			if (c.getContactId().equals(contactId))
			{
				c.setFirstName(firstName);
				return;
			}
		}
		throw new IllegalArgumentException("No Id Found");
	}
	
	//update last
	public void updateLastName(String contactId, String lastName)
	{
		for (Contact c : contacts)
		{
			if (c.getContactId().equals(contactId))
			{
				c.setLastName(lastName);
				return;
			}
		}
		throw new IllegalArgumentException("No Id Found");
	}
	
	//update phone
	public void updatePhone(String contactId, String phone)
	{
		for (Contact c : contacts)
		{
			if (c.getContactId().equals(contactId))
			{
				c.setPhone(phone);
				return;
			}
		}
		throw new IllegalArgumentException("No Id Found");
	}
	
	
	//update address
	public void updateAddress(String contactId, String address)
	{
		for (Contact c : contacts)
		{
			if (c.getContactId().equals(contactId))
			{
				c.setAddress(address);
				return;
			}
		}
		throw new IllegalArgumentException("No Id Found");
	}
	
}


	