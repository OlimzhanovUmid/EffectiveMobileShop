package com.uolimzhanov.eshopeffectivemobile.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.uolimzhanov.eshopeffectivemobile.model.database.EMDatabase
import com.uolimzhanov.eshopeffectivemobile.model.network.CatalogApiService
import com.uolimzhanov.eshopeffectivemobile.utils.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * created by uolimzhanov on 05.02.2024
 */

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "data_store")
const val BASE_URL = "https://run.mocky.io/"
@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): DataStoreManager = DataStoreManager(context)


    @Singleton
    @Provides
    fun providesUsersDatabase(
        @ApplicationContext context: Context
    ): EMDatabase =
        Room
            .databaseBuilder(context, EMDatabase::class.java, "effectiveMobile.db")
            .build()

    @Singleton
    @Provides
    fun providesOkhttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
    }

    @Singleton
    @Provides
    fun providesCatalogApiService(retrofit: Retrofit.Builder): CatalogApiService =
        retrofit
            .build()
            .create(CatalogApiService::class.java)
}