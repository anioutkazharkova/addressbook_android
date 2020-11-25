package com.example.contacts.ui.main.viewholders


import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.ContactInfo
import com.example.contacts.databinding.ItemContactLayoutBinding
import com.example.contacts.util.loadImage

class ContactViewHolder (val itemBinding: ItemContactLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    var tag: Int = 0

    init {}

    fun bind(contact: ContactInfo,tag: Int = 0) {
        this.tag = tag
        itemBinding.textContactName.text = contact.name
       itemBinding.textPhoneNumber.text = "Phone: ${contact.defaultPhone?.number ?: "--"}"
       if (!contact.imageUri.isNullOrEmpty()) {
           itemBinding.imageContact.loadImage(contact.imageUri!!)
        }else {
           itemBinding.imageContact.setImageResource(R.mipmap.placeholder)
       }
    }
}