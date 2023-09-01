package cl.awakelabs.examen.data.local

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_superheros")
data class HeroEntity(
    @PrimaryKey val id:Int,
    val name: String,
    val origin: String,
    val image: String,
    val power: String,
    val since: Int
)
