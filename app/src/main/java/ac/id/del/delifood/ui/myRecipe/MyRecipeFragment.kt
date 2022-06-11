package ac.id.del.delifood.ui.myRecipe

import ac.id.del.delifood.R
import ac.id.del.delifood.databinding.FragmentMyRecipeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyRecipeFragment : Fragment() {

    private var _binding: FragmentMyRecipeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myRecipeViewModel =
            ViewModelProvider(this)[MyRecipeViewModel::class.java]

        _binding = FragmentMyRecipeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        val myRecipeView: RecyclerView = binding.myRecipeList

        myRecipeView.layoutManager = layoutManager
        myRecipeView.setHasFixedSize(true)

        myRecipeViewModel.myRecipe.observe(viewLifecycleOwner) {
            myRecipeView.adapter = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_MyRecipeFragment_to_AddRecipeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}