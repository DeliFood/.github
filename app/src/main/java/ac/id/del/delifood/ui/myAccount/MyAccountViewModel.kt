package ac.id.del.delifood.ui.myAccount

import ac.id.del.delifood.activities.LoginActivity
import ac.id.del.delifood.data.User
import ac.id.del.delifood.utils.Constants
import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MyAccountViewModel : ViewModel() {

    private val mFirestore = Firebase.firestore

    private val _myAccount = MutableLiveData<String>().apply {
        FirebaseAuth.getInstance().currentUser?.let {
            mFirestore
                .collection(Constants.USERS)
                .document(it.uid)
                .get()
                .addOnSuccessListener { document ->
                    val user = document.toObject(User::class.java)!!
                    value = "${user.firstName} ${user.lastName}"
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                }
        }
    }

    val myAccount: LiveData<String> = _myAccount

}