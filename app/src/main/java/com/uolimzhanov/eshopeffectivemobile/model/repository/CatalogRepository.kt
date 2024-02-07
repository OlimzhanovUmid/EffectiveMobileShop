package com.uolimzhanov.eshopeffectivemobile.model.repository

import com.uolimzhanov.eshopeffectivemobile.model.entity.Catalog
import com.uolimzhanov.eshopeffectivemobile.model.network.CatalogApiService
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * created by uolimzhanov on 05.02.2024
 */
@Singleton
class CatalogRepository @Inject constructor(
    private val api: CatalogApiService
) {
    suspend fun getCatalog(): Catalog {
        return try {
            api.getCatalog()
        } catch (e: HttpException) {
            Catalog()
        } catch (e: Exception) {
            Catalog()
        }
    }
}