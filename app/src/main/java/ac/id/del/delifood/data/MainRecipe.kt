package ac.id.del.delifood.data

data class MainRecipe(
    var title_recipe: String ?= null,
    var origin: String ?= null,
    var ingredients: ArrayList<String> ?= null ,
    val procedure: ArrayList<String> ?= null
)