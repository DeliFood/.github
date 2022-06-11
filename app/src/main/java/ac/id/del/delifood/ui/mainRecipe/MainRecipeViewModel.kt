package ac.id.del.delifood.ui.mainRecipe

import ac.id.del.delifood.data.MainRecipe
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainRecipeViewModel : ViewModel() {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val dbRef: DatabaseReference = databaseReference.child("main_recipe")

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

//    private val _ingredientsListMainRecipe = MutableLiveData<RecyclerView.Adapter<MainRecipeAdapter.MainRecipeViewHolder>>().apply {
//        dbRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                for (mainRecipeSnapshot in dataSnapshot.children) {
//                    val mainRecipe = mainRecipeSnapshot.getValue(MainRecipe::class.java)
//                    mainRecipeList.add(mainRecipe!!)
//                    value = MainRecipeAdapter(mainRecipeList)
//                }
//
//
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                // Getting Post failed, log a message
//                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
//            }
//        }
//        )
//    }

//    val ingredientsListMainRecipe: LiveData<RecyclerView.Adapter<MainRecipeAdapter.MainRecipeViewHolder>> = _ingredientsListMainRecipe

    private val mainRecipeList: ArrayList<MainRecipe> = arrayListOf()

    private val _listText = MutableLiveData<RecyclerView.Adapter<MainRecipeAdapter.MainRecipeViewHolder>>().apply {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (mainRecipeSnapshot in dataSnapshot.children) {
                    val mainRecipe =  mainRecipeSnapshot.getValue(MainRecipe::class.java)
                    mainRecipeList.add(mainRecipe!!)
                    value = MainRecipeAdapter(mainRecipeList)
                }


            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        )
    }

    val listText: LiveData<RecyclerView.Adapter<MainRecipeAdapter.MainRecipeViewHolder>> = _listText

}