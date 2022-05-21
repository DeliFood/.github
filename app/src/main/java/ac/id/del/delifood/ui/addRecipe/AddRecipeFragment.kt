package ac.id.del.delifood.ui.addRecipe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ac.id.del.delifood.databinding.FragmentAddRecipeBinding
import android.widget.TextView

class AddRecipeFragment : Fragment() {

    private var _binding: FragmentAddRecipeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val addRecipeViewModel =
            ViewModelProvider(this)[AddRecipeViewModel::class.java]

        _binding = FragmentAddRecipeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAddRecipe
        addRecipeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}