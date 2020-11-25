package com.example.contacts.ui.main.contactinfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contacts.R

class ContactInfoFragment : Fragment() {

    companion object {
        fun newInstance() = ContactInfoFragment()
    }

    private lateinit var viewModel: ContactInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContactInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}