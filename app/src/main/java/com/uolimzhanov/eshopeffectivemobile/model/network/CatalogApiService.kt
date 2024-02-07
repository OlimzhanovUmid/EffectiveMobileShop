package com.uolimzhanov.eshopeffectivemobile.model.network

import com.uolimzhanov.eshopeffectivemobile.model.entity.Catalog
import retrofit2.http.GET

/**
 * created by uolimzhanov on 05.02.2024
 */
interface CatalogApiService {
    @GET("v3/97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getCatalog() : Catalog

}