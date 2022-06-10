package ac.id.del.delifood.firestore

import ac.id.del.delifood.data.User
import ac.id.del.delifood.ui.loginRegister.LoginFragment
import ac.id.del.delifood.ui.loginRegister.RegisterFragment
import ac.id.del.delifood.utils.Constants
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {
    private val mFirestore = FirebaseFirestore.getInstance()

    fun registerUser(fragment: RegisterFragment, userInfo: User) {
        mFirestore.collection(Constants.USERS)
            .document(userInfo.id)
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                fragment.userRegistrationSuccess()
            }
            .addOnFailureListener { e ->
                fragment.hideProgresssDialog()
                Log.e(
                    fragment.javaClass.simpleName,
                    "Error ketika mendaftarkan user",
                    e
                )
            }
    }
    
    private fun getCurrentUserID(): String {
        val currentUser = FirebaseAuth.getInstance().currentUser
        
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return  currentUserID
    }

    fun getUserDetails(activity: Activity) {
        mFirestore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .get()
            .addOnSuccessListener { document ->
                Log.i(activity.javaClass.simpleName, document.toString())

                val user = document.toObject(User::class.java)!!

                val sharedPreferences =
                    activity.getSharedPreferences(
                        Constants.DELIFOOD_PREFERENCES,
                        Context.MODE_PRIVATE
                    )

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString(
                    Constants.LOGGED_IN_USERNAME,
                    "${user.firstName} ${user.lastName}"
                )

                editor.apply()

                when (activity) {
                    is LoginFragment -> {
                        activity.userLoggedSuccess(user)
                    }
                }
            }
            .addOnFailureListener {
                when (activity) {
                    is LoginFragment -> {
                        activity.hideProgresssDialog()
                    }
                }
            }
    }
}