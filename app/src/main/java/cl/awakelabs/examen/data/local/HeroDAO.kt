package cl.awakelabs.examen.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface HeroDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(heroEntity: List<HeroEntity>)

    @Query("SELECT * FROM tbl_superheros ORDER BY id ASC")
    fun getHerosList(): LiveData<List<HeroEntity>>

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(heroEntity: List<HeroEntity>)

    @Query("SELECT * FROM tbl_ ORDER BY id ASC")
    fun getHerosList(): LiveData<List<HeroEntity>>*/


}