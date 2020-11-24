package com.example.contacts.service

import android.net.Uri
import android.provider.ContactsContract

object PhoneFields {
    val CONTENT_URI: Uri = ContactsContract.Contacts.CONTENT_URI
    val ID = ContactsContract.Contacts._ID
    val DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME
    val HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER
    val PHONE_CONTENT_URI: Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
    val PHONE_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID
    val PHOTO_URI = ContactsContract.CommonDataKinds.Phone.PHOTO_URI
    val NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER
    val PHONE_TYPE = ContactsContract.CommonDataKinds.Phone.TYPE
}

object PhoneTypes {
    val MOBILE = ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
    val WORK_MOBILE = ContactsContract.CommonDataKinds.Phone.TYPE_WORK_MOBILE
    val WORK = ContactsContract.CommonDataKinds.Phone.TYPE_WORK
    val HOME = ContactsContract.CommonDataKinds.Phone.TYPE_HOME
}