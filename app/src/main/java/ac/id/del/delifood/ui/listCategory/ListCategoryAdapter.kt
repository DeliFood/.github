package ac.id.del.delifood.ui.listCategory

import ac.id.del.delifood.R
import ac.id.del.delifood.databinding.ItemListCategoryBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class ListCategoryAdapter (
    private val recipeMainCategory: List<String>
    ) : RecyclerView.Adapter<ListCategoryAdapter.ListCategoryViewHolder>(){

    var listener: ListCategoryRecyclerViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    = ListCategoryViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list_category, parent, false
        )
    )

    override fun onBindViewHolder(holder: ListCategoryViewHolder, position: Int) {
        holder.itemListCategoryBinding.textListCategory.text = recipeMainCategory[position]
        holder.itemListCategoryBinding.cardViewItemListCategory.setOnClickListener {
            listener?.onItemClicked(it, recipeMainCategory[position])
        }
    }

    override fun getItemCount(): Int {
        return recipeMainCategory.size
    }

    class ListCategoryViewHolder (val itemListCategoryBinding: ItemListCategoryBinding)
        : RecyclerView.ViewHolder(itemListCategoryBinding.root)
}