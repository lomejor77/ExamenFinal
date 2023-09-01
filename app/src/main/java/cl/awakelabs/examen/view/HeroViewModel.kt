package cl.awakelabs.examen.view

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.awakelabs.examen.R
import cl.awakelabs.examen.data.Repository
import cl.awakelabs.examen.data.local.HeroDataBase
import cl.awakelabs.examen.data.local.HeroDetailEntity
import cl.awakelabs.examen.data.remote.HeroRetroFit
import kotlinx.coroutines.launch

class HeroViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val api = HeroRetroFit.getRetroFitClient()
        val heroDataBase = HeroDataBase.getDataBase(application).getHeroDao()
        repository = Repository(api, heroDataBase)
    }
    //funcion al primer fragmento
    fun getAllHeros()  = viewModelScope.launch { repository.getHeros() }
    fun heroLiveData() = repository.obtainHerosEntity()
    fun getDetails(id: Int) = viewModelScope.launch { repository.obtainDetail(id) }
    fun idHeroLiveData(id: Int) = repository.idDetail(id)

    fun detailLiveData(id: Int): LiveData<HeroDetailEntity> = repository.idDetail(id)

    fun sendEmail(context: Context, name: String, selectedId: Int) {

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            //putExtra(Intent.EXTRA_EMAIL, arrayOf("info@novaera.cl"))
            putExtra(Intent.EXTRA_EMAIL, arrayOf(R.string.send_to))
            putExtra(Intent.EXTRA_SUBJECT, "Consulta $name id $selectedId")
            putExtra(
                Intent.EXTRA_TEXT,
                "Hola\n quiero el siguiente super heroe" + name + " " +
                        "aparezca en la nueva coleccion\n"+
                        "número de contacto ___. " +
                        "\n Gracias.")
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }

    }

}