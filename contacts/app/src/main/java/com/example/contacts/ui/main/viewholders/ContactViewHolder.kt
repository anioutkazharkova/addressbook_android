package com.example.contacts.ui.main.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.ContactInfo
import com.example.contacts.data.PhoneNumber
import com.example.contacts.databinding.ItemContactLayoutBinding
import com.example.contacts.service.PhoneType
import com.example.contacts.util.loadImage

class ContactViewHolder (private val itemBinding: ItemContactLayoutBinding,private val onItemClick: (Int) -> Unit) : RecyclerView.ViewHolder(itemBinding.root) {
    var tag: Int = 0

    init {
        itemBinding.root.setOnClickListener {
            onItemClick(tag)
        }
    }

    fun bind(contact: ContactInfo) {
        itemBinding.textContactName.text = contact.name
       itemBinding.textPhoneNumber.text = "Phone: ${contact.defaultPhone?.number ?: "--"}"
       if (!contact.imageUri.isNullOrEmpty()) {
           itemBinding.imageContact.loadImage(contact.imageUri!!)
        }else {
           itemBinding.imageContact.setImageResource(R.mipmap.placeholder)
       }
    }
}