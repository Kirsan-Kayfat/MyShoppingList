package com.shuchenysh.myshoppinglist.domain

data class ShopItem(
    var id: Int = UNDEFINED_ID,
    val name: String,
    val count: Int,
    val isEnabled: Boolean
) {

    companion object {
        const val UNDEFINED_ID = 0
    }
}
