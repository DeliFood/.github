package ac.id.del.delifood.ui.listCategory

import android.view.View

interface ListCategoryRecyclerViewClickListener {
    fun onItemClicked(view: View, recipeMainCategory: String)
}