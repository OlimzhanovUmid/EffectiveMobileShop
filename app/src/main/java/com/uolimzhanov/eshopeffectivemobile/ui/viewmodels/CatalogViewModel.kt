package com.uolimzhanov.eshopeffectivemobile.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uolimzhanov.eshopeffectivemobile.model.mappers.toItem
import com.uolimzhanov.eshopeffectivemobile.model.mappers.toUiItem
import com.uolimzhanov.eshopeffectivemobile.model.repository.CatalogRepository
import com.uolimzhanov.eshopeffectivemobile.model.repository.ItemsRepository
import com.uolimzhanov.eshopeffectivemobile.model.repository.UsersRepository
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
    private val catalogRepo: CatalogRepository,
    private val itemsRepo: ItemsRepository,
    private val usersRepo: UsersRepository
): ViewModel() {
    private val _catalogState = MutableStateFlow(CatalogState())
    val catalogState = _catalogState.asStateFlow()
    
    init {
        viewModelScope.launch {
            _catalogState.value = _catalogState.value.copy(
                currentUser = usersRepo.getUserById()
            )
        }
        refreshItems()
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

            is CatalogUiEvent.SaveItem -> {
                refreshItems()
                viewModelScope.launch {
                    if(event.item.isLiked)
                        itemsRepo.deleteItem(event.item.toItem())
                    else
                        itemsRepo.insertItem(event.item.toItem())
                }
            }
        }
    }

    private fun refreshItems(){
        viewModelScope.launch {
            _catalogState.value = _catalogState.value.copy(
                items = catalogRepo.getCatalog().items
                    .map { it.toUiItem(
                        itemsRepo.getItemById(it.id) != null
                    ) }
            )
        }
    }
}