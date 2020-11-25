package com.example.contacts.util

import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.io.File

fun ImageView.loadImage(image: String) {
    if (!image.isNullOrEmpty()) {
        Picasso.get()
            .load(image)
            .into(this)
    } else {
        this.setImageDrawable(null)
    }
}

fun ImageView.loadImage(file: File, invalidate: Boolean = false) {
    if (invalidate) {
        Picasso.get().invalidate(file)
    }
    Picasso.get().load(file).into(this)
}