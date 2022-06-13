package ac.id.del.delifood.ui.home

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import ac.id.del.delifood.databinding.ItemHomeBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val mainCategoryList: List<MainCategory>,
                  private val categoryClickHandler: CategoryClickHandler
                   ): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = mainCategoryList[position]
        holder.categoryHome.text = currentItem.origin
    }

    override fun getItemCount(): Int {
        return mainCategoryList.size
    }

    inner class HomeViewHolder (binding: ItemHomeBinding)
        : RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        val categoryHome: TextView = itemView.findViewById(R.id.text_category_home)
//        val cardViewItemHome: CardView = itemView.findViewById(R.id.card_view_item_home)

        init {
            binding.root.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val currentCategory = mainCategoryList[bindingAdapterPosition]
            categoryClickHandler.clickedCategoryItem(currentCategory)
        }
    }
}