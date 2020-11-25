package com.example.contacts.service

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract
import com.example.contacts.ContactsApp
import com.example.contacts.data.ContactInfo
import com.example.contacts.data.PhoneNumber

class ContactsManager {
    private var context: Context = ContactsApp.appContext

    fun getContacts(): List<ContactInfo> {
        var contactList: ArrayList<ContactInfo> = arrayListOf()
        val contentResolver = context.contentResolver
        val cursor: Cursor? =
            contentResolver?.query(PhoneFields.CONTENT_URI, null, null, null, null)

        cursor?.let {
            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val numbersOfContact = arrayListOf<PhoneNumber>()
                    val contact_id: String = cursor.getString(cursor.getColumnIndex(PhoneFields.ID))
                    val name: String? =
                        cursor.getString(cursor.getColumnIndex(PhoneFields.DISPLAY_NAME))
                    val hasPhoneNumber: Int = cursor.getString(
                        cursor.getColumnIndex(
                            PhoneFields.HAS_PHONE_NUMBER
                        )
                    ).toInt()
                    val imageUri = cursor.getString(cursor.getColumnIndex(PhoneFields.PHOTO_URI))

                    if (hasPhoneNumber > 0) {

                        val phoneCursor: Cursor? = contentResolver.query(
                            PhoneFields.PHONE_CONTENT_URI, null,
                            "${PhoneFields.PHONE_CONTACT_ID} = ?", arrayOf(contact_id), null
                        )

                      
                        phoneCursor?.let {
                            while (phoneCursor.moveToNext()) {
                                val phoneNumber = phoneCursor.getString(
                                    phoneCursor.getColumnIndex(
                                        PhoneFields.NUMBER
                                    )
                                )
                                if (!phoneNumber.isNullOrEmpty()) {
                                    val phoneType =
                                        phoneCursor.getInt(phoneCursor.getColumnIndex(PhoneFields.PHONE_TYPE))
                                    numbersOfContact.add(
                                        PhoneNumber(
                                            PhoneType.getValue(phoneType),
                                            phoneNumber
                                        )
                                    )
                                }
                            }
                        }
                        contactList.add(ContactInfo(name, imageUri, numbersOfContact))
                    }
                }
            }
        }
        return contactList
    }
}

