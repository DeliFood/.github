package ac.id.del.delifood.ui.mainRecipe

import ac.id.del.delifood.databinding.FragmentMainRecipeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainRecipeFragment : Fragment() {

    private var _binding: FragmentMainRecipeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var databaseReference: DatabaseReference
    private lateinit var dbRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mainRecipeViewModel =
            ViewModelProvider(this)[MainRecipeViewModel::class.java]

        _binding = FragmentMainRecipeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        databaseReference = FirebaseDatabase.getInstance().reference
        dbRef = databaseReference.child("main_recipe")

        val textView: TextView = binding.textMainRecipe
        mainRecipeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val textTitle: TextView = binding.titleMainRecipe
        mainRecipeViewModel.textTitle.observe(viewLifecycleOwner) {
            textTitle.text = it
        }
        val textOrigin: TextView = binding.originMainRecipe
        mainRecipeViewModel.textOrigin.observe(viewLifecycleOwner) {
            textOrigin.text = it
        }
//        val textIngredients: TextView = binding.ingredientsMainRecipe
//        mainRecipeViewModel.textIngredients.observe(viewLifecycleOwner) {
//            textIngredients.text = it
//        }
//        val textProcedure: TextView = binding.procedureMainRecipe
//        mainRecipeViewModel.textProcedure.observe(viewLifecycleOwner) {
//            textProcedure.text = it
//        }
            return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}