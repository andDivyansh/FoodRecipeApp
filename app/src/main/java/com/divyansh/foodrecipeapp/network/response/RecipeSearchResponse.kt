package com.divyansh.foodrecipeapp.network.response

import android.os.Parcelable
import com.divyansh.foodrecipeapp.network.Results
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class RecipeSearchResponse (
    val results : List<Results>?,
    val offset : Int?,
    val number : Int?,
    val totalResults : Int?
) : Parcelable

@Parcelize
data class RecipeRandomResponse (
    @SerializedName(value = "recipes")
    val results : List<Results>?
) : Parcelable
