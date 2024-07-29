package com.example.androidprac.core.data.repositories.topCategories

import com.example.androidprac.R
import com.example.androidprac.core.models.CategoryModel
import com.example.androidprac.presentation.components.DynamicImageSource

class TopCategoriesRepoImpl : TopCategoriesRepo {
    override fun getAllTopCategories(): List<CategoryModel> {

//        throw Error()

        return listOf(
            CategoryModel(
                label = "3D Printing",
                image = DynamicImageSource.Local(R.drawable.image_3d_printer)
            ),
            CategoryModel(
                label = "Development Board Phase 2  some some osdfw",
                image = DynamicImageSource.Local(R.drawable.image_development_boards)
            ),
            CategoryModel(
                label = "Raspberry Pi",
                image = DynamicImageSource.Local(R.drawable.image_raspberry_pi)
            ),
            CategoryModel(
                label = "Arduino",
                image = DynamicImageSource.Local(R.drawable.image_arduino_nano)
            )
        )
    }
}