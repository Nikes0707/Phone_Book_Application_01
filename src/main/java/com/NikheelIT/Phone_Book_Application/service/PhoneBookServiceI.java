package com.NikheelIT.Phone_Book_Application.service;

 
import java.util.List;

import com.NikheelIT.Phone_Book_Application.model.Contact;

public interface PhoneBookServiceI {
	
	public boolean saveContact(Contact contact);
	
	List<Contact> getallResult();
	
	Contact getById (Integer id);
	
	public boolean UpdateId (Contact contact );
}
