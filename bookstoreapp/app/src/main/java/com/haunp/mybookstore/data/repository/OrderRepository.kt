package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.model.entity.Order

interface OrderRepository {
    suspend fun insertOrder(order: Order)
    suspend fun getOrdersByUserId(userId: Int): List<Order>
    suspend fun getAllOrders(): List<Order>
    suspend fun updateOrder(order: Order)

}