package com.shuchenysh.myshoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.shuchenysh.myshoppinglist.data.ShopListRepositoryImpl
import com.shuchenysh.myshoppinglist.domain.RemoveShopItemUseCase
import com.shuchenysh.myshoppinglist.domain.EditShopItemUseCase
import com.shuchenysh.myshoppinglist.domain.GetShopListUseCase
import com.shuchenysh.myshoppinglist.domain.ShopItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun removeShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.removeShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isEnabled = !shopItem.isEnabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}