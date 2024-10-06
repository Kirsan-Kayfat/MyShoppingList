package com.shuchenysh.myshoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shuchenysh.myshoppinglist.data.ShopListRepositoryImpl
import com.shuchenysh.myshoppinglist.domain.EditShopItemUseCase
import com.shuchenysh.myshoppinglist.domain.GetShopListUseCase
import com.shuchenysh.myshoppinglist.domain.RemoveShopItemUseCase
import com.shuchenysh.myshoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl // исправить с применением DI

    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)

    private val _shopList = MutableLiveData<List<ShopItem>>()
    val shopList: LiveData<List<ShopItem>>
        get() = _shopList

    fun getShopList() {
        _shopList.value = getShopListUseCase.getShopList()
    }

    fun removeShopItem(shopItem: ShopItem) {
        removeShopItemUseCase.removeShopItem(shopItem)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isEnabled = !shopItem.isEnabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }

}