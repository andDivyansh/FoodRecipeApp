package com.divyansh.foodrecipeapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.divyansh.foodrecipeapp.presentation.viewmodels.RecipeListViewModel
import com.divyansh.foodrecipeapp.presentation.viewmodels.components.RecipeCardView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    private val recipeListViewModel: RecipeListViewModel by viewModels()

    @ExperimentalComposeUiApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = recipeListViewModel.recipeList.value?.toMutableList() ?: emptyList()
                Column {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = 10.dp
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            SetupSearchBar()
                        }
                    }
                    LazyColumn {
                        itemsIndexed(items = recipes) { _, item ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(12.dp)
                            ) {
                                RecipeCardView(recipe = item, onItemClick = {})
                            }
                        }
                    }
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    @Composable
    fun SetupSearchBar() {
        val searchQuery = recipeListViewModel.query.value
        val keyboardController = LocalSoftwareKeyboardController.current
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = searchQuery,
            onValueChange = { search ->
                recipeListViewModel.getSearchQuery(search)
            },
            label = {
                Text(text = "Search")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )
            },
            keyboardActions = KeyboardActions(onSearch = {
                recipeListViewModel.getRecipes(searchQuery)
                keyboardController?.hide()
            }),
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = MaterialTheme.colors.primary
            )
        )
    }
}