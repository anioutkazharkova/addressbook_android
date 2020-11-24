package com.example.contacts.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.ContactInfo
import com.example.contacts.data.PhoneNumber
import com.example.contacts.databinding.ItemPhoneNumberLayoutBinding
import com.example.contacts.ui.main.viewholders.ContactViewHolder
import com.example.contacts.ui.main.viewholders.PhoneNumberViewHolder

class PhoneNumbersAdapter: RecyclerView.Adapter<PhoneNumberViewHolder>(){

    private var items = arrayListOf<PhoneNumber>()

    fun setupItems(list: List<PhoneNumber>) {
        this.items = arrayListOf()
        this.items.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneNumberViewHolder {
        val itemBinding = ItemPhoneNumberLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhoneNumberViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PhoneNumberViewHolder, position: Int) {
        val item = this.items[position]
        holder.bind(item)
    }
    override fun getItemCount(): Int = items.size
}