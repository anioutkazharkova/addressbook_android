package com.example.contacts.data

import android.os.Parcel
import android.os.Parcelable
import com.example.contacts.service.PhoneType

data class PhoneNumber(val type: PhoneType,val number: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        PhoneType.valueOf(parcel.readString() ?: ""),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type.toString())
        parcel.writeString(number)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhoneNumber> {
        override fun createFromParcel(parcel: Parcel): PhoneNumber {
            return PhoneNumber(parcel)
        }

        override fun newArray(size: Int): Array<PhoneNumber?> {
            return arrayOfNulls(size)
        }
    }
}