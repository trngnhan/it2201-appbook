package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.model.entity.Book

interface BookRepository {
    suspend fun getAllBooks(): List<Book>
    suspend fun getBookById(bookId: Int): Book?
    suspend fun searchBooks(query: String): List<Book>
    suspend fun getBooksByCategory(categoryId: Int): List<Book>
    suspend fun insertBook(book: Book)
    suspend fun deleteBook(book: Book)
    suspend fun updateBook(book: Book)
}