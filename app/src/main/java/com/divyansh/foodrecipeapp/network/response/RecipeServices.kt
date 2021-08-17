package com.divyansh.foodrecipeapp.network.response

import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeServices {

    @GET("complexSearch")
    suspend fun searchRecipe(
        @Query(value = "apiKey") token : String,
        @Query(value = "query") searchString: String
    ) : RecipeSearchResponse

}