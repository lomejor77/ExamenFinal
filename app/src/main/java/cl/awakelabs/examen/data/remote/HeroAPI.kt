package cl.awakelabs.examen.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroAPI {
    @GET("superheroes")
    suspend fun getHeroData(): retrofit2.Response<List<Hero>>

    //get para el detalle
    @GET("superheroes/{id}")
   suspend fun getHeroDetails(@Path("id") id: Int): Response<Details>
}