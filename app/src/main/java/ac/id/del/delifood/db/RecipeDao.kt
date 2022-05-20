package ac.id.del.delifood.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): List<Recipe>

    @Insert
    fun insert(vararg recipes: Recipe)

    @Delete
    fun delete(recipe: Recipe)

    @Query("DELETE FROM recipe")
    fun deleteAll()
}