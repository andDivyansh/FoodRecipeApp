package com.divyansh.foodrecipeapp.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeCard(
    val id : Int? =  null,
    val title : String? = null,
    val image : String? = null,
    val imageType : String?= null
) : Parcelable