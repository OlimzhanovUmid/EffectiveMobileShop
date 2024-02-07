package com.uolimzhanov.eshopeffectivemobile.model.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.ItemDb
import kotlinx.coroutines.flow.Flow

/**
 * created by uolimzhanov on 07.02.2024
 */
@Dao
interface ItemsDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(itemDb: ItemDb)

    @Delete
    suspend fun deleteItem(itemDb: ItemDb)

    @Query("select * from items")
    fun getItems() : Flow<List<ItemDb>>

    @Query("select * from items where id = :id")
    suspend fun getItemById(id: String): ItemDb?
}