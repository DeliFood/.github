package ac.id.del.delifood.ui.home

import ac.id.del.delifood.R
import ac.id.del.delifood.data.MainCategory
import ac.id.del.delifood.databinding.FragmentHomeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private lateinit var adapter: HomeAdapter
    private lateinit var categoryView: RecyclerView
    var mainCategoryList: ArrayList<MainCategory> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.holder.cardViewItemHome.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_ListCategoryFragment)
        }

        adapter = HomeAdapter(mainCategoryList,
            object : HomeAdapter.ClickListener {
                override fun onItemClick(mainCategory: MainCategory) {
                    findNavController().navigate(R.id.action_HomeFragment_to_ListCategoryFragment)
                }
            })

        categoryView.adapter = adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 3)
        categoryView = binding.categoryHome
        categoryView.layoutManager = layoutManager
        categoryView.setHasFixedSize(true)

        homeViewModel.categoryHome.observe(viewLifecycleOwner) {
            mainCategoryList = it
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}