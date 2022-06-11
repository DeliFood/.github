package ac.id.del.delifood.ui.home

import ac.id.del.delifood.data.MainCategory
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class HomeViewModel : ViewModel() {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val dbRef: DatabaseReference = databaseReference.child("main_category")

    private val mainCategoryList: ArrayList<MainCategory> = arrayListOf()

    private var count = 0

    private val _categoryHome = MutableLiveData<RecyclerView.Adapter<HomeAdapter.HomeViewHolder>>().apply {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (mainCategorySnapshot in dataSnapshot.children) {
                    val mainCategory =  mainCategorySnapshot.getValue(MainCategory::class.java)
                    mainCategoryList.add(mainCategory!!)

                    value = HomeAdapter(mainCategoryList)
                }


            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        )
    }

    val categoryHome: LiveData<RecyclerView.Adapter<HomeAdapter.HomeViewHolder>> = _categoryHome

}