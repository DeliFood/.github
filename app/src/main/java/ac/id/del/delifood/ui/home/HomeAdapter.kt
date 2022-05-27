package ac.id.del.delifood.ui.home

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter (private  val mainCategoryList: List<MainCategory>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home,
            parent, false)
        return  HomeViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = mainCategoryList[position]
        holder.categoryHome.text = currentItem.origin
    }

    override fun getItemCount(): Int {
        return mainCategoryList.size
    }

    class HomeViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val categoryHome: TextView = itemView.findViewById(R.id.text_category_home)
    }

}