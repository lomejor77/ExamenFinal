package cl.awakelabs.examen.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroRetroFit {
    companion object{
        private const val URL_BASE = "https://y-mariocanedo.vercel.app/"
        fun getRetroFitClient() : HeroAPI {
            val mRetroFit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return mRetroFit.create(HeroAPI::class.java)

        }
    }
}