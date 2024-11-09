package com.haunp.mybookstore.data.repository.Impl

import com.haunp.mybookstore.data.local.dao.OrderDao
import com.haunp.mybookstore.data.model.entity.Order
import com.haunp.mybookstore.data.repository.OrderRepository

class OrderRepositoryImpl(private val orderDao: OrderDao) : OrderRepository {
    override suspend fun insertOrder(order: Order) {
        return orderDao.insertOrder(order)
    }

    override suspend fun getOrdersByUserId(userId: Int): List<Order> {
        return orderDao.getOrdersByUserId(userId)
    }

    override suspend fun getAllOrders(): List<Order> {
        return orderDao.getAllOrders()
    }

    override suspend fun updateOrder(order: Order) {
        return orderDao.updateOrder(order)
    }
}