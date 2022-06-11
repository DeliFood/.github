package ac.id.del.delifood.ui.myAccount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyAccountViewModel : ViewModel() {

    private val _myAccount = MutableLiveData<String>().apply {
        value = ""
    }
    val myAccount: LiveData<String> = _myAccount
}