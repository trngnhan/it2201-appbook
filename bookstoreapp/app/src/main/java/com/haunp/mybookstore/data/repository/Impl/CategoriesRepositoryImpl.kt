package com.haunp.mybookstore.data.repository.Impl

import com.haunp.mybookstore.data.local.dao.CategoryDao
import com.haunp.mybookstore.data.model.entity.Category
import com.haunp.mybookstore.data.repository.CategoryRepository

class CategoryRepositoryImpl(private val categoryDao: CategoryDao): CategoryRepository {
    override suspend fun insertCategory(category: Category) {
        return categoryDao.insertCategory(category)
    }

    override suspend fun updateCategory(category: Category) {
        return categoryDao.updateCategory(category)
    }

    override suspend fun deleteCategory(category: Category) {
        return categoryDao.deleteCategory(category)
    }

    override suspend fun getAllCategories(): List<Category> {
        return categoryDao.getAllCategory()
    }
}