package ac.id.del.delifood.ui.listCategory

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import ac.id.del.delifood.databinding.FragmentListCategoryBinding
import ac.id.del.delifood.databinding.ItemListCategoryBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListCategoryFragment : Fragment() {
    private var _binding: FragmentListCategoryBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var _bindingItem: ItemListCategoryBinding? = null
    private val bindingItem get() = _bindingItem!!

    private lateinit var adapter: MainCategoryAdapter
    private lateinit var categoryView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var mainCategoryList: ArrayList<MainCategory> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listCategoryViewModel =
            ViewModelProvider(this)[ListCategoryViewModel::class.java]

        _binding = FragmentListCategoryBinding.inflate(inflater, container, false)
        _bindingItem = ItemListCategoryBinding.inflate(inflater, container, false)
//        val rootItem: View = bindingItem.root

        layoutManager = LinearLayoutManager(context)
        categoryView = binding.listCategory
        categoryView.layoutManager = layoutManager
        categoryView.setHasFixedSize(true)

        listCategoryViewModel.listCategory.observe(viewLifecycleOwner) {
            mainCategoryList = it
        }

        adapter = MainCategoryAdapter(mainCategoryList)
        categoryView.adapter = adapter

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingItem.cardViewItemListCategory.setOnClickListener {
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