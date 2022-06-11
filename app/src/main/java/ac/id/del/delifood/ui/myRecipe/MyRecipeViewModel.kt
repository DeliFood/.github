package ac.id.del.delifood.ui.myRecipe

import ac.id.del.delifood.data.MyRecipe
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MyRecipeViewModel : ViewModel() {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val dbRef: DatabaseReference = databaseReference.child("my_recipe")

    private val myRecipeList: ArrayList<MyRecipe> = arrayListOf()

    private val _myRecipe = MutableLiveData<RecyclerView.Adapter<MyRecipeAdapter.MyRecipeViewHolder>>().apply {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (myRecipeSnapshot in dataSnapshot.children) {
                    val myRecipe =  myRecipeSnapshot.getValue(MyRecipe::class.java)
                    myRecipeList.add(myRecipe!!)
                    value = MyRecipeAdapter(myRecipeList)
                }


            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        )
    }

    val myRecipe: LiveData<RecyclerView.Adapter<MyRecipeAdapter.MyRecipeViewHolder>> = _myRecipe


}