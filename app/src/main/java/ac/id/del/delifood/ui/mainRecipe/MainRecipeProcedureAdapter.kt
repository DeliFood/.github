package ac.id.del.delifood.ui.mainRecipe

import ac.id.del.delifood.R
import ac.id.del.delifood.databinding.ItemMainRecipeProcedureBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class MainRecipeProcedureAdapter (
    private val mainRecipeProcedure: ArrayList<String>
        ) : RecyclerView.Adapter<MainRecipeProcedureAdapter.MainRecipeProcedureViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  MainRecipeProcedureViewHolder (
        DataBindingUtil.inflate (LayoutInflater.from(parent.context),
            R.layout.item_main_recipe_procedure, parent, false)
    )

    override fun onBindViewHolder(holder: MainRecipeProcedureViewHolder, position: Int) {
        holder.itemMainRecipeProcedureBinding.pointProcedure .text = "-"
        holder.itemMainRecipeProcedureBinding.textItemMainRecipeProcedure.text = mainRecipeProcedure[position]
    }

    override fun getItemCount(): Int {
        return 1
    }

    class MainRecipeProcedureViewHolder (val itemMainRecipeProcedureBinding: ItemMainRecipeProcedureBinding)
        : RecyclerView.ViewHolder(itemMainRecipeProcedureBinding.root)
}