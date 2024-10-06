package com.shuchenysh.myshoppinglist.data

import com.shuchenysh.myshoppinglist.domain.ShopItem
import com.shuchenysh.myshoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = sortedSetOf<ShopItem>({o1, o2 -> o1.id.compareTo(o2.id)})

    override fun addShopItem(shopItem: ShopItem) {
        shopList.add(shopItem)
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        removeShopItem(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }
}