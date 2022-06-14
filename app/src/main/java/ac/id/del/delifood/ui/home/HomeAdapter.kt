package ac.id.del.delifood.ui.home

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import ac.id.del.delifood.databinding.ItemHomeBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter (private  val mainCategoryList: List<MainCategory>)
    : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    var position: Int = 0
    lateinit var holder: HomeViewHolder
    lateinit var currentItem: MainCategory

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  HomeViewHolder (
        DataBindingUtil.inflate (LayoutInflater.from(parent.context),
            R.layout.item_home, parent, false)
    )

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        this.position = position
        this.holder = holder
        currentItem = mainCategoryList[position]
        holder.itemHomeBinding.textCategoryHome.text = currentItem.origin
    }

    override fun getItemCount(): Int {
        return mainCategoryList.size
    }

    class HomeViewHolder (val itemHomeBinding: ItemHomeBinding)
        : RecyclerView.ViewHolder(itemHomeBinding.root)
}