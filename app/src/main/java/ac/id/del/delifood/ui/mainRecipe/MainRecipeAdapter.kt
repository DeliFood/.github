package ac.id.del.delifood.ui.mainRecipe

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainRecipe
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainRecipeAdapter (private  val mainRecipeList: List<MainRecipe>) : RecyclerView.Adapter<MainRecipeAdapter.MainRecipeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home,
            parent, false)
        return  MainRecipeViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: MainRecipeViewHolder, position: Int) {
//        val currentItem = mainRecipeList[position]
    }

    override fun getItemCount(): Int {
        return mainRecipeList.size
    }


    class MainRecipeViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    }

}