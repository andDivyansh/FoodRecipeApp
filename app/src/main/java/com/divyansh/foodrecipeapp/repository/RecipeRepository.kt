package com.divyansh.foodrecipeapp.repository

import com.divyansh.foodrecipeapp.presentation.RecipeCard

interface RecipeRepository {

    suspend fun searchRecipe(authToken: String, page: Int, query: String): List<RecipeCard>?
    suspend fun getRandomRecipe(authToken: String): List<RecipeCard>?
}