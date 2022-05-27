package ac.id.del.delifood.ui.listCategory

import ac.id.del.delifood.data.MainCategory
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ListCategoryViewModel : ViewModel() {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val dbRef: DatabaseReference = databaseReference.child("main_category")

    private val mainCategoryList: ArrayList<MainCategory> = arrayListOf()

    private val _text = MutableLiveData<String>().apply {
        value = "This is List Category Fragment"
    }

    val text: LiveData<String> = _text

    private val _listCategory = MutableLiveData<RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder>>().apply {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (mainCategorySnapshot in dataSnapshot.children) {
                    val mainCategory =  mainCategorySnapshot.getValue(MainCategory::class.java)
                    mainCategoryList.add(mainCategory!!)
                    value = MainCategoryAdapter(mainCategoryList)
                }


            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        )
    }

    val listCategory: LiveData<RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder>> = _listCategory

}