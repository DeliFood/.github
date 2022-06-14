package ac.id.del.delifood.ui.mainRecipe

import ac.id.del.delifood.databinding.FragmentMainRecipeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class MainRecipeFragment : Fragment() {

    private var _binding: FragmentMainRecipeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mainRecipeViewModel =
            ViewModelProvider(this)[MainRecipeViewModel::class.java]

        _binding = FragmentMainRecipeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val titleRecipe = arguments?.getString("title_recipe")!!
        val position = arguments?.getInt("position")!!

        val textTitle = binding.titleMainRecipe
        textTitle.text = titleRecipe

        val textOrigin = binding.originMainRecipe

        mainRecipeViewModel.mainRecipe.observe(viewLifecycleOwner) {
            textOrigin.text = it[position].origin

            val mainRecipeIngredientsAdapter = MainRecipeIngredientsAdapter(it[position].ingredients!!)
            val textIngredients = binding.ingredientsListMainRecipe
            textIngredients.apply {
                this.adapter = mainRecipeIngredientsAdapter
                this.layoutManager =  LinearLayoutManager(context)
            }

            val mainRecipeProcedureAdapter = MainRecipeProcedureAdapter(it[position].procedure!!)
            val textProcedure = binding.procedureListMainRecipe
            textProcedure.apply {
                this.adapter = mainRecipeProcedureAdapter
                this.layoutManager =  LinearLayoutManager(context)
            }

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}