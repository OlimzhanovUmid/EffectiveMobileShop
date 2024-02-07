package com.uolimzhanov.eshopeffectivemobile.model.repository

import com.uolimzhanov.eshopeffectivemobile.model.database.EMDatabase
import com.uolimzhanov.eshopeffectivemobile.model.database.entity.ItemDb
import com.uolimzhanov.eshopeffectivemobile.model.entity.Item
import javax.inject.Inject
import javax.inject.Singleton
/**
 * created by uolimzhanov on 07.02.2024
 */
@Singleton
class ItemsRepository @Inject constructor(
    private val db: EMDatabase
){
    suspend fun insertItem(item: Item){
        db.itemsDao.insertItem(ItemDb(item.id, item.title))
    }

    suspend fun deleteItem(item: Item){
        db.itemsDao.deleteItem(ItemDb(item.id, item.title))
    }

    fun getDbItems() = db.itemsDao.getItems()

    suspend fun getItemById(id: String) = db.itemsDao.getItemById(id)
}