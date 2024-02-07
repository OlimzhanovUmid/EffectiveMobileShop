package com.uolimzhanov.eshopeffectivemobile.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uolimzhanov.eshopeffectivemobile.model.repository.CatalogRepository
import com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog.CatalogState
import com.uolimzhanov.eshopeffectivemobile.ui.screens.catalog.CatalogUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 * created by uolimzhanov on 06.02.2024
 */
@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val productsRepo: CatalogRepository,
): ViewModel() {
    private val _catalogState = MutableStateFlow(CatalogState())
    val catalogState = _catalogState.asStateFlow()
    
    init {
        viewModelScope.launch { 
            _catalogState.value = _catalogState.value.copy(
                catalog = productsRepo.getCatalog()
            )
        }
    }

    fun onEvent(event: CatalogUiEvent){
        when(event){
            is CatalogUiEvent.SelectTag -> {
                _catalogState.value = _catalogState.value.copy(
                    selectedTag = event.tag
                )
            }

            is CatalogUiEvent.OpenItem -> {
                _catalogState.value = _catalogState.value.copy(
                    openedItem = event.item
                )
            }
        }
    }
}