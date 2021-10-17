package com.divyansh.foodrecipeapp.presentation.viewmodels.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.divyansh.foodrecipeapp.presentation.RecipeCard
import com.divyansh.foodrecipeapp.util.loadImagesForList


@Composable
fun RecipeDetailsView(
    recipe: RecipeCard
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        recipe.image?.let {
            val image = loadImagesForList(url = it).value
            image?.let {
                Image(
                    bitmap = it.asImageBitmap(), contentDescription = "", modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp),
                    contentScale = ContentScale.Crop
                )

            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            recipe.title?.let {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h3
                    )
                }
                val servings = recipe.servings.toString()
                Text(
                    text = servings,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.End),
                    style = MaterialTheme.typography.h5
                )
                recipe.instructions?.let {
                    Text(text = it, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }

        }
    }

}