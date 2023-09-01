package cl.awakelabs.examen.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HeroDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(heroList: List<HeroEntity>)

    @Query("SELECT * FROM tbl_superheros ORDER BY id ASC")
    fun getHerosList(): LiveData<List<HeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(heroDetailEntity: HeroDetailEntity)

    @Query("SELECT * FROM tbl_details WHERE id LIKE :id")
    fun getHeroDetails(id: Int): LiveData<List<HeroDetailEntity>>


}