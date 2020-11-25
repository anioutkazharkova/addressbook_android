package com.example.contacts.ui.main.contactinfo

import androidx.lifecycle.MutableLiveData
import com.example.contacts.data.ContactInfo
import com.example.contacts.ui.main.base.BaseViewModel

class ContactInfoViewModel : BaseViewModel() {
    var contact: MutableLiveData<ContactInfo> = MutableLiveData()

    fun setupItem(item: ContactInfo){
        this.contact.value = item
    }

}