package cl.awakelabs.examen.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelabs.examen.data.Repository
import cl.awakelabs.examen.data.local.HeroDataBase
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

}