package com.haunp.mybookstore

import android.app.Application
import com.haunp.mybookstore.data.local.db.BookDatabase
import com.haunp.mybookstore.data.repository.AdminRepository
import com.haunp.mybookstore.data.repository.BookRepository
import com.haunp.mybookstore.data.repository.CategoryRepository
import com.haunp.mybookstore.data.repository.CommentRepository
import com.haunp.mybookstore.data.repository.Impl.AdminRepositoryImpl
import com.haunp.mybookstore.data.repository.Impl.BookRepositoryImpl
import com.haunp.mybookstore.data.repository.Impl.CategoryRepositoryImpl
import com.haunp.mybookstore.data.repository.Impl.CommentRepositoryImpl
import com.haunp.mybookstore.data.repository.Impl.OrderRepositoryImpl
import com.haunp.mybookstore.data.repository.Impl.UserRepositoryImpl
import com.haunp.mybookstore.data.repository.OrderRepository
import com.haunp.mybookstore.data.repository.UserRepository

class BookApp: Application() {
    lateinit var database: BookDatabase
    lateinit var bookRepository: BookRepository
    lateinit var categoryRepository: CategoryRepository
    lateinit var adminRepository: AdminRepository
    lateinit var orderRepository: OrderRepository
    lateinit var commentRepository: CommentRepository
    lateinit var userRepository: UserRepository
    override fun onCreate() {
        super.onCreate()
        database = BookDatabase.getDatabase(this)
        bookRepository = BookRepositoryImpl(database.bookDao(), database.categoriesDao(), database.commentDao())
        categoryRepository = CategoryRepositoryImpl(database.categoriesDao())
        adminRepository = AdminRepositoryImpl(database.userDao())
        orderRepository = OrderRepositoryImpl(database.orderDao())
        commentRepository = CommentRepositoryImpl(database.commentDao())
        userRepository = UserRepositoryImpl(database.userDao())
    }
}