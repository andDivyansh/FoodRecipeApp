package com.divyansh.foodrecipeapp.di

import com.divyansh.foodrecipeapp.network.model.RecipeNetworkMapper
import com.divyansh.foodrecipeapp.network.response.RecipeServices
import com.divyansh.foodrecipeapp.repository.RecipeRepository
import com.divyansh.foodrecipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRecipeRepository(
        recipeServices: RecipeServices,
        recipeNetworkMapper: RecipeNetworkMapper
    ): RecipeRepository = RecipeRepositoryImpl(recipeServices, recipeNetworkMapper)

}