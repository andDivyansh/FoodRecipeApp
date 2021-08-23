package com.divyansh.foodrecipeapp.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divyansh.foodrecipeapp.presentation.RecipeCard
import com.divyansh.foodrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    @Named(value = "authToken") private val token: String
) : ViewModel() {

    val recipeList: MutableState<List<RecipeCard>?> = mutableStateOf(emptyList())
    val query  = mutableStateOf("")

    fun getRecipes(searchString: String){
        viewModelScope.launch {
            val response = recipeRepository.searchRecipe(
                authToken = token, query = searchString,
                page = 1
            )
            recipeList.value = response
        }
    }

    fun getSearchQuery(searchInput: String){
        query.value = searchInput
    }
}