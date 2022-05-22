package ac.id.del.delifood.ui.landingPage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ac.id.del.delifood.databinding.FragmentLandingPageBinding
import android.widget.TextView

class LandingPageFragment : Fragment() {

    private var _binding: FragmentLandingPageBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val landingPageViewModel =
            ViewModelProvider(this)[LandingPageViewModel::class.java]

        _binding = FragmentLandingPageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textLandingPage
        landingPageViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}