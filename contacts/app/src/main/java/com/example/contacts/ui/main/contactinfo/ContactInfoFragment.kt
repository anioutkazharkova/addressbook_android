package com.example.contacts.ui.main.contactinfo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.R
import com.example.contacts.data.ContactInfo
import com.example.contacts.databinding.ContactInfoFragmentBinding
import com.example.contacts.ui.main.adapters.PhoneNumbersAdapter
import com.example.contacts.util.autoCleared
import com.example.contacts.util.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactInfoFragment : Fragment() {

    private var binding: ContactInfoFragmentBinding by autoCleared()
    private val viewModel: ContactInfoViewModel by viewModels()

    private lateinit var adapter: PhoneNumbersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ContactInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<ContactInfo>("item")?.let { viewModel.setupItem(it) }

        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.contact.observe(viewLifecycleOwner, Observer {
            this.setup(it)
        })
    }

    private fun setup(contact: ContactInfo) {
        binding.textContactName.text = contact.name
        contact.imageUri?.let {
            binding.imageContact.loadImage(it)
        }
        adapter.setupItems(contact.phoneNumbers ?: arrayListOf())
        adapter.notifyDataSetChanged()
    }

    private fun setupRecyclerView() {
        adapter = PhoneNumbersAdapter()
        binding.listPhones.layoutManager = LinearLayoutManager(requireContext())
        binding.listPhones.adapter = adapter
    }
}