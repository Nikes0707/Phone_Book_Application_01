package com.NikheelIT.Phone_Book_Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikheelIT.Phone_Book_Application.Repositry.PhoneBookRepositry;
import com.NikheelIT.Phone_Book_Application.model.Contact;
@Service
public class PhoneBookServiceIMPL implements PhoneBookServiceI{
	@Autowired
	private PhoneBookRepositry phoneBookRepositry ;

	@Override
	public boolean saveContact(Contact contact) {
		 Contact save = phoneBookRepositry.save(contact);
		 if (save!= null) {
			 return true ;
		 }
		return false;
	}


}
