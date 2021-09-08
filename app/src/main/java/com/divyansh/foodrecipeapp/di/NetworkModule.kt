package com.divyansh.foodrecipeapp.di

import com.divyansh.foodrecipeapp.network.model.RecipeNetworkMapper
import com.divyansh.foodrecipeapp.network.response.RecipeServices
import com.divyansh.foodrecipeapp.util.AppConstants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeService(): RecipeServices {
        val logInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logInterceptor)
        return Retrofit.Builder()
            .client(httpClient.build())
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeServices::class.java)
    }

    @Singleton
    @Provides
    fun provideRecipeNetworkMapper(): RecipeNetworkMapper = RecipeNetworkMapper()

    @Singleton
    @Provides
    @Named(value = "authToken")
    fun provideAuthToken(): String = AppConstants.AUTH_TOKEN
}