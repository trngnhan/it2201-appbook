package com.haunp.mybookstore.data.repository.Impl

import com.haunp.mybookstore.data.local.dao.BookDao
import com.haunp.mybookstore.data.local.dao.CategoryDao
import com.haunp.mybookstore.data.local.dao.CommentDao
import com.haunp.mybookstore.data.model.entity.Book
import com.haunp.mybookstore.data.repository.BookRepository

class BookRepositoryImpl(private val bookDao: BookDao,
                         private val categoryDao: CategoryDao,
                         private val commentDao: CommentDao) : BookRepository {
    override suspend fun getAllBooks(): List<Book> {
        return bookDao.getAllBooks()
    }

    override suspend fun getBookById(bookId: Int): Book? {
        return bookDao.getBookById(bookId)
    }

    override suspend fun searchBooks(query: String): List<Book> {
        return bookDao.searchBooks("%$query%")
    }

    override suspend fun getBooksByCategory(categoryId: Int): List<Book> {
        return bookDao.getBooksByCategory(categoryId)
    }

    override suspend fun insertBook(book: Book) {
        return bookDao.insertBook(book)
    }

    override suspend fun deleteBook(book: Book) {
        return bookDao.deleteBook(book)
    }

    override suspend fun updateBook(book: Book) {
        return bookDao.updateBook(book)
    }
}