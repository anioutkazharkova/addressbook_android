package com.example.contacts.ui.main.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.PhoneNumber
import com.example.contacts.databinding.ItemPhoneNumberLayoutBinding
import org.w3c.dom.Text

class PhoneNumberViewHolder(private val itemBinding: ItemPhoneNumberLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(phone: PhoneNumber) {
        itemBinding.textPhoneNumber.text = phone.number
        itemBinding.textPhoneType.text = phone.type.value
    }
}