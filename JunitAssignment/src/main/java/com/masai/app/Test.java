package com.masai.app;

public class Test {

	public static void main(String[] args) {
		ContactManager manager=new ContactManager();
		manager.addContact("Vaibhav", "Karthikeyan", "0875415955");
		System.out.println(manager.getAllContacts());
	}
}
