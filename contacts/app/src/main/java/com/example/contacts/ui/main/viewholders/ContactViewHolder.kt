package com.example.contacts.ui.main.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.ContactInfo
import com.example.contacts.data.PhoneNumber

class ContactViewHolder (itemView: View) :
RecyclerView.ViewHolder(itemView) {
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
        
    }
}