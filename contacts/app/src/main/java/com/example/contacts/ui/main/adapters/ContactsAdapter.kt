package com.example.contacts.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.ContactInfo
import com.example.contacts.databinding.ItemContactLayoutBinding
import com.example.contacts.ui.main.viewholders.ContactViewHolder

class ContactsAdapter (private val onItemClick: (Int) -> Unit): RecyclerView.Adapter<ContactViewHolder>(){

    private var items = arrayListOf<ContactInfo>()

    fun setupItems(list: List<ContactInfo>) {
        this.items = arrayListOf()
        this.items.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemBinding = ItemContactLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(itemBinding,onItemClick)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = this.items[position]
        holder.bind(item)
        holder.tag = position
    }
    override fun getItemCount(): Int = items.size
}