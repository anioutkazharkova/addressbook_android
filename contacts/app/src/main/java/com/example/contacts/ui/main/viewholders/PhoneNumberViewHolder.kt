package com.example.contacts.ui.main.viewholders


import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.data.PhoneNumber
import com.example.contacts.databinding.ItemPhoneNumberLayoutBinding

class PhoneNumberViewHolder(private val itemBinding: ItemPhoneNumberLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(phone: PhoneNumber) {
        itemBinding.textPhoneNumber.text = phone.number
        itemBinding.textPhoneType.text = phone.type.value
    }
}