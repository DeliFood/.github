package ac.id.del.delifood.ui.addRecipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddRecipeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Add Recipe Fragment"
    }
    val text: LiveData<String> = _text

}