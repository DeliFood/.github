package ac.id.del.delifood.ui.myRecipe

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MyRecipe
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecipeAdapter (private  val myRecipeList: List<MyRecipe>) : RecyclerView.Adapter<MyRecipeAdapter.MyRecipeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_my_recipe,
            parent, false)
        return  MyRecipeViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: MyRecipeViewHolder, position: Int) {
        val currentItem = myRecipeList[position]
        holder.myRecipeItem.text = currentItem.origin
    }

    override fun getItemCount(): Int {
        return myRecipeList.size
    }

    class MyRecipeViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val myRecipeItem: TextView = itemView.findViewById(R.id.text_my_recipe_item)
    }

}