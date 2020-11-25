package com.example.contacts.data

import android.os.Parcel
import android.os.Parcelable
import android.provider.ContactsContract
import com.example.contacts.service.PhoneType

data class ContactInfo(val name: String?,  val imageUri: String?, val phoneNumbers: List<PhoneNumber>?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(PhoneNumber)
    ) {
    }

    var defaultPhone: PhoneNumber? = null
    get() {
        return phoneNumbers?.filter { it.type == PhoneType.MOBILE }?.firstOrNull() ?: phoneNumbers?.firstOrNull()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageUri)
        parcel.writeTypedList(phoneNumbers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactInfo> {
        override fun createFromParcel(parcel: Parcel): ContactInfo {
            return ContactInfo(parcel)
        }

        override fun newArray(size: Int): Array<ContactInfo?> {
            return arrayOfNulls(size)
        }
    }
}