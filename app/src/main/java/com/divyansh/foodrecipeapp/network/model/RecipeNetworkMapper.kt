package com.divyansh.foodrecipeapp.network.model

import com.divyansh.foodrecipeapp.network.Results
import com.divyansh.foodrecipeapp.presentation.RecipeCard
import com.divyansh.foodrecipeapp.util.EntityMapper

class RecipeNetworkMapper : EntityMapper<Results, RecipeCard> {
    override fun mapFromEntity(entity: Results): RecipeCard =
        RecipeCard(
            title = entity.title,
            image = entity.image,
            id = entity.id,
            imageType = entity.imageType
        )


    override fun mapToEntity(domainModel: RecipeCard): Results = Results(
        title = domainModel.title,
        image = domainModel.image,
        imageType = domainModel.imageType,
        id = domainModel.id
    )

    fun fromEntityList(initial: List<Results>?): List<RecipeCard>? =
        initial?.map { mapFromEntity(it) }

    fun toEntityList(initial: List<RecipeCard>?) : List<Results>? =
        initial?.map { mapToEntity(it) }
}