package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.model.entity.Category

interface CategoryRepository {
    suspend fun insertCategory(category: Category)
    suspend fun updateCategory(category: Category)
    suspend fun deleteCategory(category: Category)
    suspend fun getAllCategories(): List<Category>
}