package com.example.contacts.data

import android.os.Parcel
import android.os.Parcelable

data class ContactInfo(val name: String?,  val imageUri: String?, val phoneNumbers: List<PhoneNumber>?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(PhoneNumber)
    ) {
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