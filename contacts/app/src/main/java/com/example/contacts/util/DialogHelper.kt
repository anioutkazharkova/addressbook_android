package com.example.contacts.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AlertDialog

import android.provider.Settings
import com.example.contacts.R


class DialogHelper {
    companion object {
        val instance = DialogHelper()
    }

    fun showSettings(context: Context) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", context.packageName, null)
        intent.data = uri

        AlertDialog.Builder(context)
            .setMessage(
                String.format(
                    context.getString(R.string.contact_allow_string)
                )
            )
            .setPositiveButton(
                context.getString(R.string.settings_button)
            ) { dialog, which ->
                context.startActivity(intent)
                dialog.dismiss()
            }
            .show()
    }
}