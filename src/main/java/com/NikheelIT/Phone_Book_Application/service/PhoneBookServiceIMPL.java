package com.NikheelIT.Phone_Book_Application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	@Override
	public List<Contact> getallResult() {
		 List<Contact> findAll = phoneBookRepositry.findAll();
		 Stream<Contact> stream = findAll.stream();
		 Stream<Contact> filter = stream.filter(Contact -> Contact.getActiveSwitch()=='y');
		 List<Contact> collect = filter.collect(Collectors.toList());
		return collect;
	}

	@Override
	public Contact getById( Integer cid) {
	      Contact findById = phoneBookRepositry.findById(cid).get();
	       return findById ;
	      }

	@Override
	public boolean UpdateId(Contact contact ) {
		Contact save = phoneBookRepositry.save(contact);
		if (save != null ) {
			return true ;
		}
		return false;
	}
	
	
}
