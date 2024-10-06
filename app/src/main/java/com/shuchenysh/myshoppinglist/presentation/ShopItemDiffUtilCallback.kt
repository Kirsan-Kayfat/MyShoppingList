package com.shuchenysh.myshoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.shuchenysh.myshoppinglist.domain.ShopItem

class ShopItemDiffUtilCallback : DiffUtil.ItemCallback<ShopItem>() {

    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem) = oldItem == newItem
}