package com.example.contactapp.repository

import androidx.lifecycle.LiveData
import com.example.contactapp.model.Contact
import com.example.contactapp.model.ContactDao

class ContactRepository(private val dao : ContactDao) {
    val allContacts : LiveData<List<Contact>> = dao.getAllContacts()

    suspend fun insertContact(contact: Contact){
         dao.insertContact(contact)
    }
    suspend fun deleteContact(contact: Contact){
        dao.deleteContact(contact)
    }
    suspend fun updateContact(contact: Contact){
        dao.updateContact(contact)
    }

}