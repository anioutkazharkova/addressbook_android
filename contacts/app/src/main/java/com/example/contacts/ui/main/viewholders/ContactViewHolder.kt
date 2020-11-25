package com.example.contacts.ui.main.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.ContactInfo
import com.example.contacts.data.PhoneNumber
import com.example.contacts.service.PhoneType
import com.example.contacts.util.loadImage

class ContactViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tag: Int = 0
    lateinit var textPhone: TextView
    lateinit var textName: TextView
    lateinit var imageContact: ImageView

    init {
        textPhone = itemView.findViewById(R.id.text_phone_number)
        textName = itemView.findViewById(R.id.text_contact_name)
        imageContact = itemView.findViewById(R.id.image_contact)
    }

    fun bind(contact: ContactInfo) {
        textName.text = contact.name
        textPhone.text = "Phone: ${contact.defaultPhone?.number ?: "--"}"
       if (!contact.imageUri.isNullOrEmpty()) {
            imageContact.loadImage(contact.imageUri!!)
        }else {
            imageContact.setImageDrawable(null)
       }
    }
}