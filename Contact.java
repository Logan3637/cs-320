package Contacts;

public class Contact {
	
	//variables
	
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	//construct and validate
	public Contact(String contactId, String firstName, String lastName, String phone, String address)
	{
		if (contactId == null || contactId.length() > 10)
		{
			throw new IllegalArgumentException("ContactId invalid");
		}
		if (firstName == null || firstName.length() > 10)
		{
			throw new IllegalArgumentException("firstName invalid");
		}
		if (lastName == null || lastName.length() > 10)
		{
			throw new IllegalArgumentException("lastName invalid");
		}
		if (phone == null || phone.length() != 10 || !allDigits(phone))
		{
			throw new IllegalArgumentException("phone invalid");
		}
		if (address == null || address.length() > 30)
		{
			throw new IllegalArgumentException("address invalid");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	//get
	public String getContactId()
	{
		return contactId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getAddress()
	{
		return address;
	}
		
	//set
	public void setFirstName(String firstName)
	{
		if (firstName == null || firstName.length() > 10)
		{
			throw new IllegalArgumentException("firstName invalid");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		if (lastName == null || lastName.length() > 10)
		{
			throw new IllegalArgumentException("lastName invalid");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone)
	{
		if (phone == null || phone.length() != 10 || !allDigits(phone))
		{
			throw new IllegalArgumentException("phone invalid");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address)
	{
		if (address == null || address.length() > 30)
		{
			throw new IllegalArgumentException("address invalid");
		}
		this.address = address;
	}
	
	private static boolean allDigits(String s)
	{
		for(int i=0; i<s.length(); i++)
		{
			if (!Character.isDigit(s.charAt(i)))
			{
				return false;
			}
			
		}
		return true;
	}
}
