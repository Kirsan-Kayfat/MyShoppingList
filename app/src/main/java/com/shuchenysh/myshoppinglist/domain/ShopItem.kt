package com.shuchenysh.myshoppinglist.domain

data class ShopItem(
    val id: Int,
    val name: String,
    val count: Int,
    val isEnabled: Boolean
) {

    companion object {
        const val UNDEFINED_ID = -1
    }
}
