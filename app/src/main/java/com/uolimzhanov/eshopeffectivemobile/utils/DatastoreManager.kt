package com.uolimzhanov.eshopeffectivemobile.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.uolimzhanov.eshopeffectivemobile.di.dataStore
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
    }

    fun getUserId(): Int? = runBlocking {
        context.dataStore.data.first()[USER_ID_KEY]?.toInt()
    }

    suspend fun saveUserId(userId: Int) {
        context.dataStore.edit { prefs ->
            prefs[USER_ID_KEY] = userId.toString()
        }
    }

    suspend fun deleteUserId() {
        context.dataStore.edit { prefs ->
            prefs.remove(USER_ID_KEY)
        }
    }
}