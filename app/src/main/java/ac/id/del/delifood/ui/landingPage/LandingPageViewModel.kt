package ac.id.del.delifood.ui.landingPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LandingPageViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Landing Page Fragment"
    }

    val text: LiveData<String> = _text
}