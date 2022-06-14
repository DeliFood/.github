package ac.id.del.delifood.ui.home

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import ac.id.del.delifood.databinding.ItemHomeBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter (
    private  val mainCategoryList: List<MainCategory>
    ) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    var position: Int = 0
    var listener: HomeRecyclerViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  HomeViewHolder (
        DataBindingUtil.inflate (LayoutInflater.from(parent.context),
            R.layout.item_home, parent, false)
    )

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        this.position = position
        holder.itemHomeBinding.textCategoryHome.text = mainCategoryList[position].origin
        holder.itemHomeBinding.cardViewItemHome.setOnClickListener {
            listener?.onItemClicked(it, mainCategoryList[position])
        }
    }

    override fun getItemCount(): Int {
        return mainCategoryList.size
    }

    class HomeViewHolder (val itemHomeBinding: ItemHomeBinding)
        : RecyclerView.ViewHolder(itemHomeBinding.root)
}