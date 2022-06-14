package ac.id.del.delifood.ui.home

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import ac.id.del.delifood.databinding.FragmentHomeBinding
import ac.id.del.delifood.databinding.ItemHomeBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager

class HomeFragment : Fragment(), HomeRecyclerViewClickListener {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private var _bindingItem: ItemHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.

    private var mainCategoryList: ArrayList<MainCategory> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        _bindingItem = ItemHomeBinding.inflate(inflater, container, false)

        homeViewModel.categoryHome.observe(viewLifecycleOwner) {
            mainCategoryList = it
        }
        val homeAdapter = HomeAdapter(mainCategoryList)
        homeAdapter.listener = this

        val categoryView = binding.categoryHome

        categoryView.apply {
            this.adapter = homeAdapter
            this.layoutManager =  GridLayoutManager(context, 3)
        }

        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val item: CardView = bindingItem.cardViewItemHome
//        item.setOnClickListener {
//            findNavController().navigate(R.id.action_HomeFragment_to_ListCategoryFragment)
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(view: View, mainCategory: MainCategory) {
        view.findNavController().navigate(R.id.action_HomeFragment_to_ListCategoryFragment)
        Log.d("HomeFragment","Success")
    }
}