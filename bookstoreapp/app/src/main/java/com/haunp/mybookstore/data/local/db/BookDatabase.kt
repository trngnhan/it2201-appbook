package com.haunp.mybookstore.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haunp.mybookstore.data.local.dao.BookDao
import com.haunp.mybookstore.data.local.dao.CartDao
import com.haunp.mybookstore.data.local.dao.CategoryDao
import com.haunp.mybookstore.data.local.dao.OrderDao
import com.haunp.mybookstore.data.local.dao.UserDao
import com.haunp.mybookstore.data.local.dao.CommentDao
import com.haunp.mybookstore.data.model.entity.Book
import com.haunp.mybookstore.data.model.entity.Cart
import com.haunp.mybookstore.data.model.entity.Category
import com.haunp.mybookstore.data.model.entity.RateBook
import com.haunp.mybookstore.data.model.entity.Order
import com.haunp.mybookstore.data.model.entity.User

@Database(
    entities = [User::class, Book::class, Category::class,
        Cart::class, Order::class, RateBook::class],
    version = 1
)
abstract class BookDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao
    abstract fun categoriesDao(): CategoryDao
    abstract fun cartDao(): CartDao
    abstract fun orderDao(): OrderDao
    abstract fun commentDao(): CommentDao

    companion object {
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getDatabase(context: Context): BookDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}