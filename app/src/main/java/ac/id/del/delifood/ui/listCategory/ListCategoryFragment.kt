package ac.id.del.delifood.ui.listCategory

import ac.id.del.delifood.R
import ac.id.del.delifood.databinding.FragmentListCategoryBinding
import ac.id.del.delifood.databinding.ItemListCategoryBinding
import ac.id.del.delifood.ui.home.HomeFragment
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListCategoryFragment : Fragment() {
    private var _binding: FragmentListCategoryBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var _binding1: ItemListCategoryBinding? = null

    private val binding1 get() = _binding1!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listCategoryViewModel =
            ViewModelProvider(this)[ListCategoryViewModel::class.java]

        _binding = FragmentListCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        val categoryView: RecyclerView = binding.listCategory
        categoryView.layoutManager = layoutManager
        categoryView.setHasFixedSize(true)

        listCategoryViewModel.listCategory.observe(viewLifecycleOwner) {
            categoryView.adapter = it
        }

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding1.cardViewItemListCategory.setOnClickListener {
            findNavController().navigate(R.id.action_ListCategoryFragment_to_MainRecipeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    companion object {
//        @JvmStatic
//        fun newInstance(origin: String) =
//            ListCategoryFragment().apply {
//                arguments = Bundle().apply {
//                }
//            }
//    }
}