package ac.id.del.delifood.ui.home

import ac.id.del.delifood.data.MainCategory
import android.view.View

interface HomeRecyclerViewClickListener {
    fun onItemClicked(view: View, mainCategory: MainCategory)
}