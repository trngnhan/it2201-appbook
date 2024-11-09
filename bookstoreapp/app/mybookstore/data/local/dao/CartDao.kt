package com.haunp.mybookstore.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haunp.mybookstore.data.model.entity.Cart

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToCart(cart: CartDao)

    @Query("SELECT * FROM cart WHERE userId = :userId")
    suspend fun getCartByUserId(userId: Int): List<Cart>

    @Delete
    suspend fun removeFromCart(shoppingCart: Cart)

    @Query("UPDATE cart SET quantity = :quantity WHERE userId = :userId AND bookId = :productId")
    suspend fun updateCartQuantity(userId: Int, productId: Int, quantity: Int)
}