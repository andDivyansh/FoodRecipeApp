package com.divyansh.foodrecipeapp.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeNetworkEntity (
    val results : List<Results>?,
    val offset : Int?,
    val number : Int?,
    val totalResults : Int?
) : Parcelable

@Parcelize
data class Results (
    val id : Int?,
    val title : String?,
    val image : String?,
    val imageType : String?
) : Parcelable