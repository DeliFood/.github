package ac.id.del.delifood.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): Flow<List<Recipe>>

    @Insert
    fun insert(vararg recipes: Recipe)

    @Delete
    fun delete(recipe: Recipe)

    @Query("DELETE FROM recipe")
    fun deleteAll()
}