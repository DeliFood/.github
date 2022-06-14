package ac.id.del.delifood.ui.home

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import ac.id.del.delifood.databinding.FragmentHomeBinding
import ac.id.del.delifood.databinding.ItemHomeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private var _bindingItem: ItemHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val bindingitem get() = _bindingItem!!

    private lateinit var adapter: HomeAdapter
    private lateinit var categoryView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
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
//        val rootItem: View = bindingitem.root

        layoutManager = GridLayoutManager(context, 3)
        categoryView = binding.categoryHome
        categoryView.layoutManager = layoutManager
        categoryView.setHasFixedSize(true)

        homeViewModel.categoryHome.observe(viewLifecycleOwner) {
            mainCategoryList = it
        }
        adapter = HomeAdapter(mainCategoryList)
        categoryView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item: CardView = bindingitem.cardViewItemHome
        item.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_ListCategoryFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}