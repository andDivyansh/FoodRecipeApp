package com.divyansh.foodrecipeapp.util

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.divyansh.foodrecipeapp.util.AppConstants.DEFAULT_IMAGE_PLACEHOLDER

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadImagesForList(
    url: String,
): MutableState<Bitmap?>? {
    val bitmapState: MutableState<Bitmap?>? = mutableStateOf(null)
    // first load the list with placeholder images
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(DEFAULT_IMAGE_PLACEHOLDER)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState?.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}

        })

    // get the image from URL
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState?.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}

        })

    return bitmapState
}