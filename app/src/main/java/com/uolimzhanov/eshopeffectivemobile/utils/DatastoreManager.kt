package com.uolimzhanov.eshopeffectivemobile.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.GsonBuilder
import com.uolimzhanov.eshopeffectivemobile.di.dataStore
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton
/**
 * created by uolimzhanov on 08.02.2024
 */
@Singleton
class DataStoreManager @Inject constructor(
    private val context: Context
) {
    companion object {
        private val USER_ID_KEY = stringPreferencesKey("userId")
        private val USER_JSON_KEY = stringPreferencesKey("userJson")
    }

    fun getUserId(): Int? = runBlocking {
        context.dataStore.data.first()[USER_ID_KEY]?.toInt()
    }
    fun getUserJson(): UserDb = runBlocking {
            val gson = GsonBuilder().create()
            val json = "{\"firstName\":\"firstName\",\"id\":0,\"lastName\":\"secondName\",\"phoneNumber\":\"1231231231\"}"
            return@runBlocking gson.fromJson(context.dataStore.data.first()[USER_JSON_KEY] ?: json, UserDb::class.java)
        }

    suspend fun saveUserId(userId: Int) {
        context.dataStore.edit { prefs ->
            prefs[USER_ID_KEY] = userId.toString()
        }
    }

    suspend fun saveUserJson(user: UserDb) {
        val gson = GsonBuilder().create()
        context.dataStore.edit { prefs ->
            prefs[USER_JSON_KEY] = gson.toJson(user)
        }
    }

    suspend fun deleteUserId() {
        context.dataStore.edit { prefs ->
            prefs.remove(USER_ID_KEY)
        }
    }
}