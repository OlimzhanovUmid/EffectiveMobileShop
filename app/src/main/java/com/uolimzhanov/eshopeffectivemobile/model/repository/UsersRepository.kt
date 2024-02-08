package com.uolimzhanov.eshopeffectivemobile.model.repository

import com.uolimzhanov.eshopeffectivemobile.model.database.EMDatabase
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.UserDb
import com.uolimzhanov.eshopeffectivemobile.utils.DataStoreManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * created by uolimzhanov on 06.02.2024
 */
@Singleton
class UsersRepository @Inject constructor(
    private val db: EMDatabase,
    private val dataStoreManager: DataStoreManager
){
    suspend fun insertUser(userDb: UserDb){
        dataStoreManager.saveUserJson(userDb)
        db.usersDao.insertUser(userDb)
    }

    suspend fun deleteUser(userDb: UserDb) {
        dataStoreManager.deleteUserId()
        db.usersDao.deleteUser(userDb)
    }

    fun getUsers(): Flow<List<UserDb>> {
        return db.usersDao.getUsers()
    }

    suspend fun getUserById(): UserDb {
        return db.usersDao.getUsersById(dataStoreManager.getUserId()) ?: UserDb(-1,"error", "error", "error")
    }

    suspend fun getCurrentUser(): UserDb {
        return dataStoreManager.getUserJson()
    }
    suspend fun getIdByRowId(rowId: Long): Int {
        return db.usersDao.getIdByRowId(rowId)
    }
}