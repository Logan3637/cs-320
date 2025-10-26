package Contacts;

//imports
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class ContactTest {

	
	//test contact 
	@Test
	void testValidContactCreated()
	{
		Contact c = new Contact("911994", "Logan", "McCullough", "3302659174","3636 Mcdowell St");
		assertEquals("911994", c.getContactId());
		assertEquals("Logan", c.getFirstName());
		assertEquals("McCullough", c.getLastName());
		assertEquals("3302659174", c.getPhone());
		assertEquals("3637 Mcdowell St", c.getAddress());
	}
	
	//test for contact ID
	@Test
	void testIdTooLong()
	{
		assertThrows(IllegalArgumentException.class, () -> new Contact("09011994031", "Logan", "McCullough", "33026599174", "3637 Mcdowell St"));
	}
	
	//test first
	@Test
	void testFirstTooLong()
	{
		assertThrows(IllegalArgumentException.class, () -> new Contact ("123", "failedtestfirst", "McCullough", "3302659174", "3637 Mcdowell St"));
	}
	
	//test last 
	@Test
	void testLastTooLong()
	{
		assertThrows(IllegalArgumentException.class, () -> new Contact ("123", "Logan", "McCulloughs", "3302659174", "3637 Mcdowell St"));
	}
	
	//validate phone
	@Test
	void testPhone()
	{
		//short
		assertThrows(IllegalArgumentException.class, () -> new Contact ("123", "Logan", "McCullough", "2659174", "3637 Mcdowell St"));
		//long
		assertThrows(IllegalArgumentException.class, () -> new Contact ("123", "Logan", "McCullough", "333302659174", "3637 Mcdowell St"));
		//not nums
		assertThrows(IllegalArgumentException.class, () -> new Contact ("123", "Logan", "McCullough", "1234abcd", "3637 Mcdowell St"));
	
	}
	
	//testAddress
	@Test
	void testAddressLong()
	{
		String badAddress = "Test this address to make sure it hits more than the max amount of characters";
		
		assertThrows(IllegalArgumentException.class, () -> new Contact ("123", "Logan", "McCulloughs", "3302659174", badAddress));
	}
	
	//test valid updates
	@Test
	void testSetterValid()
	{
		Contact c = new Contact("123", "Logan", "McCullough", "3302659174", "3637 Mcdowell St");
		c.setFirstName("Camren");
		c.setLastName("Christian");
		c.setPhone("3306666666");
		c.setAddress("129 woodlawn ave");
		
		assertEquals("Camren", c.getFirstName());
		assertEquals("Christian", c.getLastName());
		assertEquals("3306666666", c.getPhone());
		assertEquals("129 woodlawn ave", c.getAddress());
		
	}
	
	//test invalid update attempts
	@Test
	void testSetterInvalid()
	{
		Contact c = new Contact("123", "Logan", "Mccullough", "3302659174", "3637 Mcdowell st");
		
		assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
		assertThrows(IllegalArgumentException.class, () -> c.setLastName("Mcculloughss"));
		assertThrows(IllegalArgumentException.class, () -> c.setPhone("9999"));
		assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
	}
	
	
	
}
