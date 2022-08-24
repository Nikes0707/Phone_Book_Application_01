package com.NikheelIT.Phone_Book_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NikheelIT.Phone_Book_Application.model.Contact;
import com.NikheelIT.Phone_Book_Application.service.PhoneBookServiceIMPL;

@RestController
public class ContactController {
	@Autowired
	private PhoneBookServiceIMPL phoneBookServiceIMPL ;
	@PostMapping(value = "/save",produces ="application/json")
	public ResponseEntity<String> saveContact (@RequestBody Contact contact) {
		boolean saveContact = phoneBookServiceIMPL.saveContact(contact);
		if (saveContact) {
		String msg= "Contact are save "	;
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		}
		String msg= "Thise contacr are not save ";
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST) ;
	}
	
	
	@GetMapping (value ="/getcontact", produces ="application/json")
	public ResponseEntity<List<Contact>> getallresult (){
	List<Contact> getallResult = phoneBookServiceIMPL.getallResult();
	if (getallResult != null) {
		return new ResponseEntity<List<Contact>>(getallResult,HttpStatus.OK);
	}else {
		return new ResponseEntity<>(getallResult,HttpStatus.BAD_REQUEST);
	}
	}
	
	
	@GetMapping (value = "/findbyid/{cid}",produces = "application/json")
	public ResponseEntity<Contact> getFindById (@PathVariable Integer cid ){
		Contact byId = phoneBookServiceIMPL.getById(cid);
		if (byId != null ){
			return new ResponseEntity<Contact>(byId,HttpStatus.OK);
		}
		return new ResponseEntity<Contact>(byId,HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping(value = "/update" , consumes = "application/json")
	public ResponseEntity<String> UpdateContact (@RequestBody  Contact contact){
		boolean updateId = phoneBookServiceIMPL.UpdateId(contact);
		if (updateId == true) {
			String msg= "This contact are updated";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			
		String msg="Contact are not updated ";
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping (value = "/delete/{id}")
	public ResponseEntity<String> deletebyid (@PathVariable Integer id){
		boolean hardcodeddeletedById = phoneBookServiceIMPL.HardcodeddeletedById(id);
		if (hardcodeddeletedById) {
		String msg= "Id deleted successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}else {
		String msg ="Id not delete ";
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		
	}
}
}
