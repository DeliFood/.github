package ac.id.del.delifood.ui.mainRecipe

import androidx.lifecycle.*

class MainRecipeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Main Recipe Fragment"
    }

    val text: LiveData<String> = _text

}