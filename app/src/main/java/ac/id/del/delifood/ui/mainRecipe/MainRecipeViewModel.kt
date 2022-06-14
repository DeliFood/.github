package ac.id.del.delifood.ui.mainRecipe

import ac.id.del.delifood.data.MainRecipe
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*

class MainRecipeViewModel : ViewModel() {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val dbRef: DatabaseReference = databaseReference.child("main_recipe")

    private val mainRecipeList: ArrayList<MainRecipe> = arrayListOf()

    private val _mainRecipe = MutableLiveData<ArrayList<MainRecipe>>().apply {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (mainRecipeSnapshot in dataSnapshot.children) {
                    val mainRecipe =  mainRecipeSnapshot.getValue(MainRecipe::class.java)
                    mainRecipeList.add(mainRecipe!!)
                    value = mainRecipeList
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(ContentValues.TAG, "loadMainRecipe:onCancelled", databaseError.toException())
            }
        }
        )
    }
    val mainRecipe: LiveData<ArrayList<MainRecipe>> = _mainRecipe
}