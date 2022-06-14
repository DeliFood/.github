package ac.id.del.delifood.ui.listCategory

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MainCategoryAdapter (private  val mainCategoryList: List<MainCategory>) : RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder>(){

    var position: Int = 0
    lateinit var holder: MainCategoryViewHolder
    lateinit var currentItem: MainCategory

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_category,
            parent, false)
        return  MainCategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainCategoryViewHolder, position: Int) {
        this.position = position
        this.holder = holder
        currentItem = mainCategoryList[position]
        holder.textListCategory.text = currentItem.title_recipe

//        var i = 0
//        while (i<listTitleRecipe.size) {
//            holder.textListCategory.text = listTitleRecipe[i]
//            i++
//        }
    }

    override fun getItemCount(): Int {
        return mainCategoryList.size
    }


    class MainCategoryViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textListCategory: TextView = itemView.findViewById(R.id.text_list_category)
        val cardViewItemListCategory: CardView = itemView.findViewById(R.id.card_view_item_list_category)
    }

}