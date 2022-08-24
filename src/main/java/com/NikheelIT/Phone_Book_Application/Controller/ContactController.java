package com.NikheelIT.Phone_Book_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NikheelIT.Phone_Book_Application.model.Contact;
import com.NikheelIT.Phone_Book_Application.service.PhoneBookServiceIMPL;

@RestController
public class ContactController {
	@Autowired
	private PhoneBookServiceIMPL phoneBookServiceIMPL ;
	@PostMapping(value = "/save",produces = "application/json")
	public ResponseEntity<String> saveContact (@RequestBody Contact contact) {
		boolean saveContact = phoneBookServiceIMPL.saveContact(contact);
		if (saveContact) {
		String msg= "Contact are save "	;
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		}
		String msg= "Thise contacr are not save ";
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST) ;
	}

}
