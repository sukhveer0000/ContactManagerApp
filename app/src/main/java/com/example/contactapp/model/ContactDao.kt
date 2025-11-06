package com.example.contactapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)
    @Update
    suspend fun updateContact(contact: Contact)
    @Delete
    suspend fun deleteContact(contact: Contact)

    fun getAllContacts() : LiveData<List<Contact>>
}