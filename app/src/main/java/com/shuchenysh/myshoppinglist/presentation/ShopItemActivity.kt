package com.shuchenysh.myshoppinglist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shuchenysh.myshoppinglist.databinding.ActivityShopItemBinding

class ShopItemActivity : AppCompatActivity() {

    private val binding: ActivityShopItemBinding by lazy {
        ActivityShopItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}