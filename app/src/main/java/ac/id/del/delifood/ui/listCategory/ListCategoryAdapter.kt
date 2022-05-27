package ac.id.del.delifood.ui.listCategory

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainCategoryAdapter (private  val mainCategoryList: List<MainCategory>) : RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder>(){

    private lateinit var listTitleRecipe: ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_category,
            parent, false)
        return  MainCategoryViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: MainCategoryViewHolder, position: Int) {
//        val currentItem = mainCategoryList[position]
//        listTitleRecipe = currentItem.title_recipe

//        holder.textlistCategory.text = currentItem.title_recipe

    }

    override fun getItemCount(): Int {
        return mainCategoryList.size
    }


    class MainCategoryViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val categoryHome: TextView = itemView.findViewById(R.id.text_category_home)
        val textlistCategory: TextView = itemView.findViewById(R.id.text_cardview_list_category)
    }

}