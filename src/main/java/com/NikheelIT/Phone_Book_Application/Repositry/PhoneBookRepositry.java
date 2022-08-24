package com.NikheelIT.Phone_Book_Application.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NikheelIT.Phone_Book_Application.model.Contact;

public interface PhoneBookRepositry extends JpaRepository<Contact, Integer>{

}
