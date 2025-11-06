package com.example.contactapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactapp.model.Contact
import com.example.contactapp.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application ) {

    private val repository : ContactRepository
    val allContacts : LiveData<List<Contact>>
    init{
        val dao = ContactDatabase.gatDatabase(application).contactDao()
        repository = ContactRepository(dao)
        allContacts = repository.allContacts
    }
    fun insertContact(contact: Contact) = viewModelScope.launch {
        repository.insertContact(contact)
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch {
        repository.deleteContact(contact)
    }

    fun updateContact(contact: Contact) = viewModelScope.launch {
        repository.updateContact(contact)
    }


}