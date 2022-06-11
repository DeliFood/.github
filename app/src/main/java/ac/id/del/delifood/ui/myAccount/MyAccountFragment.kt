package ac.id.del.delifood.ui.myAccount

import ac.id.del.delifood.R
import ac.id.del.delifood.activities.LoginActivity
import ac.id.del.delifood.databinding.FragmentMyAccountAfterLoginBinding
import ac.id.del.delifood.databinding.FragmentMyAccountBeforeLoginBinding
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MyAccountFragment : Fragment() {

    private var _bindingBefore: FragmentMyAccountBeforeLoginBinding? = null
    private var _bindingAfter: FragmentMyAccountAfterLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val bindingBefore get() = _bindingBefore!!
    private val bindingAfter get() = _bindingAfter!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myAccountViewModel =
            ViewModelProvider(this)[MyAccountViewModel::class.java]

        _bindingBefore = FragmentMyAccountBeforeLoginBinding.inflate(inflater, container, false)
        _bindingAfter = FragmentMyAccountAfterLoginBinding.inflate(inflater, container, false)

        val myAccountView: TextView = bindingAfter.nameProfile

        myAccountViewModel.myAccount.observe(viewLifecycleOwner) {
            myAccountView.text = it
        }

        val rootBefore: View = bindingBefore.root
        val rootAfter: View = bindingAfter.root

        return if (Firebase.auth.currentUser != null) {
            rootAfter
        } else {
            rootBefore
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingAfter.buttonSignOut.setOnClickListener {
           Firebase.auth.signOut()
            findNavController().navigate(R.id.action_MyAccountFragmentAfterLogin_to_MyAccount_BeforeLogin)
        }

        bindingBefore.signIn.setOnClickListener {
            activity?.let{
                val intent = Intent (it, LoginActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingAfter = null
        _bindingBefore = null
    }
}