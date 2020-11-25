package com.example.contacts.ui.main.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.PhoneNumber
import org.w3c.dom.Text

class PhoneNumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var textPhone: TextView
    lateinit var textType: TextView

    init {
        textPhone = itemView.findViewById(R.id.text_phone_number)
        textType = itemView.findViewById(R.id.text_phone_type)
    }

    fun bind(phone: PhoneNumber) {
        textPhone.text = phone.number
        textType.text = phone.type.toString()
    }
}