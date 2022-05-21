package ac.id.del.delifood.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "history") val history: String,
    @ColumnInfo(name = "recipe_desc") val recipeDesc: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
