package ac.id.del.delifood.ui.mainRecipe

import ac.id.del.delifood.R
import ac.id.del.delifood.databinding.ItemMainRecipeIngredientsBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class MainRecipeIngredientsAdapter (
    private val mainRecipeIngredients: ArrayList<String>
) : RecyclerView.Adapter<MainRecipeIngredientsAdapter.MainRecipeIngredientsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  MainRecipeIngredientsViewHolder (
        DataBindingUtil.inflate (LayoutInflater.from(parent.context),
            R.layout.item_main_recipe_ingredients, parent, false)
    )

    override fun onBindViewHolder(holder: MainRecipeIngredientsViewHolder, position: Int) {
        holder.itemMainRecipeIngredientsBinding.pointIngredients.text = "-"
        holder.itemMainRecipeIngredientsBinding.textItemMainRecipeIngredients.text = mainRecipeIngredients[position]
    }

    override fun getItemCount(): Int {
        return mainRecipeIngredients.size
    }

    class MainRecipeIngredientsViewHolder (val itemMainRecipeIngredientsBinding: ItemMainRecipeIngredientsBinding)
        : RecyclerView.ViewHolder(itemMainRecipeIngredientsBinding.root)
}