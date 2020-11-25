package com.example.contacts.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.ContactInfo
import com.example.contacts.data.PhoneNumber
import com.example.contacts.ui.main.viewholders.ContactViewHolder
import com.example.contacts.ui.main.viewholders.PhoneNumberViewHolder

class PhoneNumbersAdapter: RecyclerView.Adapter<PhoneNumberViewHolder>(){

    private var items = arrayListOf<PhoneNumber>()

    fun setupItems(list: List<PhoneNumber>) {
        this.items = arrayListOf()
        this.items.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneNumberViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_phone_number_layout, parent, false)
        return PhoneNumberViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhoneNumberViewHolder, position: Int) {
        val item = this.items[position]
        holder.bind(item)
    }
    override fun getItemCount(): Int = items.size
}