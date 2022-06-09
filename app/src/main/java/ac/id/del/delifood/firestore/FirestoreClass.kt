package ac.id.del.delifood.firestore

import ac.id.del.delifood.activities.RegisterActivity
import ac.id.del.delifood.models.User
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirestoreClass {
    private val mFirestore = Firebase.firestore

    fun registerUser(activity: RegisterActivity, userInfo: User) {
        mFirestore.collection("users")
            .document(userInfo.id)
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegistrationSuccess()
            }
            .addOnFailureListener { e ->
                activity.hideProgresssDialog()
                Log.e(
                    activity.javaClass.simpleName,
                    "Error ketika mendaftarkan user",
                    e
                )
            }
    }
    
    fun getCurrentUserID(): String {
        val currentUser = FirebaseAuth.getInstance().currentUser
        
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return  currentUserID
    }

}