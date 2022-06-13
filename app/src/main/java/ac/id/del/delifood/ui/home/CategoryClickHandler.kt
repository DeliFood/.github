package ac.id.del.delifood.ui.home

import ac.id.del.delifood.data.MainCategory

interface CategoryClickHandler {
    fun clickedCategoryItem(mainCategory: MainCategory)
}