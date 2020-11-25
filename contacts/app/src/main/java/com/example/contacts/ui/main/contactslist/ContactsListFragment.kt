package com.example.contacts.ui.main.contactslist

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.distinctUntilChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.R
import com.example.contacts.databinding.ContactsListFragmentBinding
import com.example.contacts.ui.main.adapters.ContactsAdapter
import com.example.contacts.util.DialogHelper
import com.example.contacts.util.autoCleared
import com.example.contacts.util.observeOnce
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsListFragment : Fragment() {
    companion object {
        private val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    }

    private var binding: ContactsListFragmentBinding by autoCleared()
    private val viewModel: ContactsListViewModel by viewModels()

    private lateinit var adapter: ContactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ContactsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()

        if (checkPermission()) {
            viewModel.fetchContacts()
        }
    }

    private fun setupRecyclerView() {
        adapter = ContactsAdapter {
            onContactClick(it)
        }
        binding.listContacts.layoutManager = LinearLayoutManager(requireContext())
        binding.listContacts.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.contactsList.distinctUntilChanged().observe(viewLifecycleOwner, Observer {
            adapter.setupItems(it)
            adapter.notifyDataSetChanged()
        })
    }

    fun onContactClick(position: Int) {
        val item = viewModel.getContact(position)
        if (item != null) {
            findNavController().navigate(
                R.id.action_contactsListFragment_to_contactInfoFragment,
                bundleOf("item" to item!!)
            )
        }
    }

    override fun onResume() {
        super.onResume()
    }

    private var isGranted: Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity?.checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED

    private fun checkPermission(): Boolean {
        if (isGranted) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSIONS_REQUEST_READ_CONTACTS
            )
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSIONS_REQUEST_READ_CONTACTS -> {
                if (!grantResults.isEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    viewModel.fetchContacts()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}