package com.shuchenysh.myshoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.shuchenysh.myshoppinglist.domain.ShopItem
import com.shuchenysh.myshoppinglist.domain.ShopListRepository

class ShopListRepositoryImpl(
    application: Application
) : ShopListRepository {

    private val shopListDao = AppDatabase.getInstance(application).shopListDao()
    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopListDao.removeShopItem(shopItem.id)
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun getShopList(): LiveData<List<ShopItem>> = shopListDao.getShopList().map {
        mapper.mapListDbModelToListEntity(it)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
         val shopItemDbModel = shopListDao.getShopItem(shopItemId)
        return mapper.mapDbModelToEntity(shopItemDbModel)
    }
}