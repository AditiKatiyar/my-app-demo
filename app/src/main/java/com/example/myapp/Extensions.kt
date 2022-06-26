package com.example.myapp

import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.bumptech.glide.Glide

fun NavController.safeNavigate(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.run { navigate(directions) }
}

fun ImageView.loadImage(imageUrl: String?) {
    val requestBuilder = Glide.with(context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_launcher_foreground)
        .fitCenter()
    requestBuilder.into(this)
}