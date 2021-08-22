package com.divyansh.foodrecipeapp.network.response

import android.os.Parcelable
import com.divyansh.foodrecipeapp.network.Results
import kotlinx.parcelize.Parcelize


@Parcelize
data class RecipeSearchResponse (
    val results : List<Results>?,
    val offset : Int?,
    val number : Int?,
    val totalResults : Int?
) : Parcelable
