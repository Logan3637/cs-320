package Contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




public class ContactServiceTest 
{
	//build it
	private Contact build(String id)
	{
		return new Contact(id, "Logan", "McCullough", "3302659174", "3637 Mcdowell st");
	}
	
	//add or reject
	@Test
	void testAddRejectDupe()
	{
		ContactService svc = new ContactService();
		svc.addContact(build("1"));
		assertThrows(IllegalArgumentException.class, () -> svc.addContact(build("1")));
	}
	
	//delete ID
	@Test
	void testDeleteId() 
	{
		ContactService svc = new ContactService();
		svc.addContact(build("1"));
		svc.deleteContact("1");
		assertThrows(IllegalArgumentException.class, () -> svc.deleteContact("1"));
	}
	
	//update phone
	@Test
	void testUdpatePhone()
	{
		ContactService svc = new ContactService();
		Contact c = build("1");
		svc.addContact(c);
		svc.updatePhone("1", "3363336666");
		assertEquals("3363336666", c.getPhone());
		assertThrows(IllegalArgumentException.class, () -> svc.updatePhone("1","123"));
	}
	
	//test first last and address
	@Test
	void testUpdateFirstLastAddress()
	{
		ContactService svc = new ContactService();
		Contact c = build("2");
		svc.addContact(c);
		
		svc.updateFirstName("2", "Camren");
		svc.updateLastName("2", "Christian");
		svc.updateAddress("2", "129 Woodlawn ave");
		
		assertEquals("Camren", c.getFirstName());
		assertEquals("Christian", c.getLastName());
		assertEquals("129 Woodlawn ave", c.getAddress());
	}
	
	//failed throws
	@Test
	void testUpdateThrow()
	{
		ContactService svc = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> svc.updateFirstName("no", "a"));
		assertThrows(IllegalArgumentException.class, () -> svc.updateLastName("no", "b"));
		assertThrows(IllegalArgumentException.class, () -> svc.updatePhone("no", "1234567890"));
		assertThrows(IllegalArgumentException.class, () -> svc.updateAddress("no", "address"));
	}
}
