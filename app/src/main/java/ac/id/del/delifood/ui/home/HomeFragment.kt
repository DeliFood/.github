package ac.id.del.delifood.ui.home

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import ac.id.del.delifood.databinding.FragmentHomeBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager

class HomeFragment : Fragment(), HomeRecyclerViewClickListener {

    private var mainCategoryList: ArrayList<MainCategory> = arrayListOf()

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(view: View, mainCategory: MainCategory) {
        val bundle = bundleOf("title_recipe" to mainCategory.title_recipe,
                                    "origin" to mainCategory.origin)
        view.findNavController().navigate(R.id.action_HomeFragment_to_ListCategoryFragment, bundle)
        Log.d("HomeFragment","Success")
    }
}