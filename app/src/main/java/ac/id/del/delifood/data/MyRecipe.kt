package ac.id.del.delifood.data

data class MyRecipe (
    var origin: String ?= null,
    var title_recipe: String ?= null,
    var ingredients: ArrayList<String> ?= null,
    var procedure: ArrayList<String> ?= null
)