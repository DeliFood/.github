package ac.id.del.delifood.ui.home

import ac.id.del.delifood.data.MainRecipe
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class HomeViewModel : ViewModel() {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val dbRef: DatabaseReference = databaseReference.child("main_recipe")

    val mainRecipeList: ArrayList<MainRecipe> = arrayListOf()

    private val _text = MutableLiveData<String>().apply {
        value = "This is Home Fragment"
    }
    val text: LiveData<String> = _text

    private val _categoryHome = MutableLiveData<RecyclerView.Adapter<MainRecipeAdapter.MainRecipeViewHolder>>().apply {
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
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        )
    }

    val categoryHome: LiveData<RecyclerView.Adapter<MainRecipeAdapter.MainRecipeViewHolder>> = _categoryHome

}