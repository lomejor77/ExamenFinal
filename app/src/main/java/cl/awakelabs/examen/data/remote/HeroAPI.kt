package cl.awakelabs.examen.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface HeroAPI {
    @GET("superheroes")
    suspend fun getHeroData(): retrofit2.Response<List<Hero>>

    //get para el detalle
   // @GET()
    //suspend fun getHeroDetails(): Response<>
}