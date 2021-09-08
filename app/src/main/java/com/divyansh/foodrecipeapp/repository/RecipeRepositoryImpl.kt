package com.divyansh.foodrecipeapp.repository

import com.divyansh.foodrecipeapp.network.model.RecipeNetworkMapper
import com.divyansh.foodrecipeapp.network.response.RecipeServices
import com.divyansh.foodrecipeapp.presentation.RecipeCard
import com.divyansh.foodrecipeapp.util.AppConstants.TOTAL_RESULTS_PER_PAGE


class RecipeRepositoryImpl(
    private val recipeServices: RecipeServices,
    private val mapper: RecipeNetworkMapper
) : RecipeRepository {
    override suspend fun searchRecipe(
        authToken: String,
        page: Int,
        query: String
    ): List<RecipeCard>? {
        val searchResult = recipeServices.searchRecipe(authToken, query)
        return mapper.fromEntityList(searchResult.results)
    }

    override suspend fun getRandomRecipe(authToken: String): List<RecipeCard>? {
        val randomRecipeResult = recipeServices.randomRecipe(TOTAL_RESULTS_PER_PAGE, token = authToken)
        return mapper.fromEntityList(randomRecipeResult.results)
    }

}