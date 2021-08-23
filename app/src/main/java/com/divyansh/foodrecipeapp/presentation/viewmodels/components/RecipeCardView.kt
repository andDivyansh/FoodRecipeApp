package com.divyansh.foodrecipeapp.presentation.viewmodels.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.divyansh.foodrecipeapp.R
import com.divyansh.foodrecipeapp.presentation.RecipeCard
import com.divyansh.foodrecipeapp.util.loadImagesForList


@Composable
fun RecipeCardView(
    recipe: RecipeCard,
    onItemClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(bottom = 10.dp, top = 10.dp)
            .fillMaxWidth()
            .clickable(onClick = onItemClick),
        elevation = 10.dp
    ) {
        Column {
            recipe.image?.let {
                loadImagesForList(url = it)?.let { urlImage ->
                    urlImage.value?.asImageBitmap()?.let { img ->
                        Image(bitmap = img, contentDescription = "",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop)
                    }
                }
            }
            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, top = 10.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = title,
                        // Occupy 85% of width
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
    }
}