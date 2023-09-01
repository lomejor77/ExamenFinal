package cl.awakelabs.examen.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelabs.examen.data.local.HeroDAO
import cl.awakelabs.examen.data.local.HeroDetailEntity
import cl.awakelabs.examen.data.local.HeroEntity
import cl.awakelabs.examen.data.remote.Details
import cl.awakelabs.examen.data.remote.Hero
import cl.awakelabs.examen.data.remote.HeroAPI

class Repository(private val heroAPI: HeroAPI, private val heroDAO: HeroDAO) {
    fun obtainHerosEntity(): LiveData<List<HeroEntity>> = heroDAO.getHerosList()
    fun idDetail(id: Int): LiveData<HeroDetailEntity> = heroDAO.getHeroDetails(id)

    suspend fun getHeros() {
        try {
            val response = heroAPI.getHeroData()
            if (response.isSuccessful) {
                val resp = response.body()
                resp?.let { hero ->
                    val heros = hero.map { it.transform() }
                    heroDAO.insertHero(heros)
                }
            } else {
                Log.e("repository", response.errorBody().toString())
            }
        } catch (exception: Exception) {
            Log.e("catch", exception.toString())

        }
    }

    suspend fun obtainDetail(id: Int) {
        try {
            val response = heroAPI.getHeroDetails(id)
            if (response.isSuccessful) {
                val respBody = response.body()
                respBody?.let { detailsHero ->
                    val heroDetailsEnt = detailsHero.transformToDetail()
                    heroDAO.insertDetails(heroDetailsEnt)
                }
            } else {
                Log.e("repository", response.errorBody().toString())
            }
        } catch (exception: Exception) {
            Log.e("catch", exception.toString())

        }

    }


}