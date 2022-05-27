package ac.id.del.delifood.ui.mainRecipe

import ac.id.del.delifood.data.MainRecipe
import android.util.Log
import androidx.lifecycle.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainRecipeViewModel : ViewModel() {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val dbRef: DatabaseReference = databaseReference.child("main_recipe").child("1")

    private val _text = MutableLiveData<String>().apply {
        value = "This is Main Recipe Fragment"
    }

    val text: LiveData<String> = _text


    private val _textTitle = MutableLiveData<String>().apply {
        dbRef.child("title_recipe").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                value = it.value as String?
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
            }
    }

    val textTitle: LiveData<String> = _textTitle


    private val _textOrigin = MutableLiveData<String>().apply {
        dbRef.child("origin").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                value = it.value as String?
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
            }
    }

    val textOrigin: LiveData<String> = _textOrigin


//    private val _textIngredients = MutableLiveData<String>().apply {
//        dbRef.child("ingredients").get()
//            .addOnSuccessListener {
//                Log.i("firebase", "Got value ${it.value}")
//                value = it.value as String?
//            }.addOnFailureListener{
//                Log.e("firebase", "Error getting data", it)
//            }
//    }
//
//    val textIngredients: LiveData<String> = _textIngredients
//
//
//    private val _textProcedure = MutableLiveData<String>().apply {
//        dbRef.child("procedure").get()
//            .addOnSuccessListener {
//                Log.i("firebase", "Got value ${it.value}")
//                value = it.value as String?
//            }.addOnFailureListener{
//                Log.e("firebase", "Error getting data", it)
//            }
//    }
//
//    val textProcedure: LiveData<String> = _textProcedure

}