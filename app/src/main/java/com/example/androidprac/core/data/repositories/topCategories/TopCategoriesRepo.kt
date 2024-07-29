package com.example.androidprac.core.data.repositories.topCategories

import com.example.androidprac.core.models.CategoryModel

interface TopCategoriesRepo {
    fun getAllTopCategories(): List<CategoryModel>
}