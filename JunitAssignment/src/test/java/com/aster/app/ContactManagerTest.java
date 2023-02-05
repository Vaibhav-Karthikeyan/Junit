package com.aster.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.masai.app.ContactManager;

@TestInstance(Lifecycle.PER_CLASS)
class ContactManagerTest {
	private ContactManager manager = null;
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		manager=new ContactManager();
	}
	
	@Test
	@DisplayName("Should Create Contact")
	public void createContactTest() {
		manager.addContact("vaibhav","karthikeyan","0875415955");
		assertEquals("[Contact [firstName=vaibhav, lastName=karthikeyan, phoneNumber=0875415955]]",manager.getAllContacts().toString());
	}
	
	@Test
	@DisplayName("Should Not Create Contact When First Name is Null")
	public void createContactFirstNameExceptionTest() {
		Throwable exception=assertThrows(RuntimeException.class,()->{
			manager.addContact("", "k","0987654321");
		});
		assertEquals("First Name Cannot be null or empty",exception.getMessage());
	}

	@Test
	@DisplayName("Phone Number should start with 0")
	public void createContactPhoneNumberExceptionTest() {
		Throwable exception=assertThrows(RuntimeException.class,()->{
			manager.addContact("vaibhav", "k","9876543210");
		});
		assertEquals("Phone Number Should Start with 0",exception.getMessage());
	}

	@Test
	@Disabled
	@DisplayName("Diasabled Test")
	void disabledTest() {
		
	}
	
	@AfterAll
	void setUpAfterClass() throws Exception {
		manager=null;
	}

}
