package com.example.contacts.ui.main.contactslist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contacts.data.ContactInfo
import com.example.contacts.service.ContactsManager
import com.example.contacts.ui.main.base.BaseViewModel
import kotlinx.coroutines.launch

class ContactsListViewModel @ViewModelInject constructor(private val contactsManager: ContactsManager) : BaseViewModel() {
   val contactsList: MutableLiveData<List<ContactInfo>> = MutableLiveData()

    fun fetchContacts() {
        uiScope.launch {
            contactsList.value = contactsManager.getAllContacts()
        }
    }

    fun getContact(position: Int): ContactInfo? {
        return contactsList.value?.get(position)
    }
}