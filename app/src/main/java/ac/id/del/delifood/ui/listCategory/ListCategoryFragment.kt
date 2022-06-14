package ac.id.del.delifood.ui.listCategory

import ac.id.del.delifood.R
import ac.id.del.delifood.databinding.FragmentListCategoryBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

class ListCategoryFragment
    : Fragment(), ListCategoryRecyclerViewClickListener {

    private var _binding: FragmentListCategoryBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListCategoryBinding.inflate(inflater, container, false)

        val recipeMainCategoryList = arguments?.getStringArrayList("title_recipe")!!
        val originMainCategory = arguments?.getString("origin")!!

        binding.titleListCategory.text = originMainCategory

        val listCategoryAdapter = ListCategoryAdapter(recipeMainCategoryList)
        listCategoryAdapter.listener = this

        val listCategoryView = binding.listCategory
        listCategoryView.apply {
            this.adapter = listCategoryAdapter
            this.layoutManager =  LinearLayoutManager(context)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(view: View, recipeMainCategory: String) {
        val bundle = bundleOf("title_recipe" to recipeMainCategory)
        view.findNavController().navigate(R.id.action_ListCategoryFragment_to_MainRecipeFragment, bundle)
        Log.d("ListCategoryFragment","Success")
    }
}