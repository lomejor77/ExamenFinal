package cl.awakelabs.examen.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_details")
data class HeroDetailEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val origin: String,
    val image: String,
    val power: String,
    val since: Int,
    val color: String,
    val translate: Boolean
)
