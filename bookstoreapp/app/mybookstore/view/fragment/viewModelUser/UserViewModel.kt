package com.haunp.mybookstore.view.fragment.viewModelUser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.data.model.entity.Book
import com.haunp.mybookstore.data.model.entity.Category
import com.haunp.mybookstore.data.model.entity.Order
import com.haunp.mybookstore.data.model.entity.User
import com.haunp.mybookstore.data.repository.BookRepository
import com.haunp.mybookstore.data.repository.CategoryRepository
import com.haunp.mybookstore.data.repository.OrderRepository
import com.haunp.mybookstore.data.repository.UserRepository
import kotlinx.coroutines.launch


class UserViewModel(
    private val bookRepository: BookRepository,
    private val categoryRepository: CategoryRepository,
    private val userRepository: UserRepository,
    private val orderRepository: OrderRepository
) : ViewModel() {

    // LiveData for book management
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    // LiveData for category management
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() = _categories

    // LiveData for user search results
    private val _searchResults = MutableLiveData<List<Book>>()
    val searchResults: LiveData<List<Book>> get() = _searchResults

    // LiveData for user information
    private val _userInfo = MutableLiveData<User>()
    val userInfo: LiveData<User> get() = _userInfo

    init {
        fetchAllBooks()
        fetchAllCategories()
    }

    // Function to fetch all books
    private fun fetchAllBooks() {
        viewModelScope.launch {
            _books.value = bookRepository.getAllBooks()
        }
    }

    // Function to fetch all categories
    private fun fetchAllCategories() {
        viewModelScope.launch {
            _categories.value = categoryRepository.getAllCategories()
        }
    }

    // Function to search books by keyword
    fun searchBooks(query: String) {
        viewModelScope.launch {
            _searchResults.value = bookRepository.searchBooks(query)
        }
    }

    // Function to fetch user information
    fun registerUser(user: User) = viewModelScope.launch {
        userRepository.register(user)
    }

    fun login(username: String, password: String): LiveData<User?> {
        val result = MutableLiveData<User?>()
        viewModelScope.launch {
            result.value = userRepository.login(username, password)
        }
        return result
    }

    // Function to add a book (used in book management)
    fun addBook(book: Book) {
        viewModelScope.launch {
            bookRepository.insertBook(book)
            fetchAllBooks()
        }
    }

    // Function to update a book
    fun updateBook(book: Book) {
        viewModelScope.launch {
            bookRepository.updateBook(book)
            fetchAllBooks()
        }
    }

    // Function to delete a book
    fun deleteBook(book: Book) {
        viewModelScope.launch {
            bookRepository.deleteBook(book)
            fetchAllBooks()
        }
    }

    // Function to add a category (used in category management)
    fun addCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.insertCategory(category)
            fetchAllCategories()
        }
    }

    // Function to update a category
    fun updateCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.updateCategory(category)
            fetchAllCategories()
        }
    }

    // Function to delete a category
    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.deleteCategory(category)
            fetchAllCategories()
        }
    }
    fun insertOreder(order: Order) = viewModelScope.launch {
        orderRepository.insertOrder(order)
        fetchAllBooks()
    }
    fun updateOrder(order: Order) = viewModelScope.launch {
        orderRepository.updateOrder(order)
        fetchAllBooks()
    }
    fun deleteOrder(order: Order) = viewModelScope.launch {
        orderRepository.updateOrder(order)
        fetchAllBooks()
    }
}
