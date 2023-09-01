package cl.awakelabs.examen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelabs.examen.R
import cl.awakelabs.examen.databinding.FragmentDetailBinding
import coil.load

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val heroViewModel: HeroViewModel by activityViewModels()
    private var selectedId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedId = it.getInt(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        heroViewModel.getDetails(selectedId)
        loadDetails()
        //sendMail()
        return binding.root

    }


    private fun loadDetails() {
        heroViewModel.idHeroLiveData(selectedId).observe(viewLifecycleOwner) {
            if (it != null) {
                binding.detImg.load(it.image)
                binding.detName.text = it.name
                binding.detOrigin.text = it.origin
                binding.detPower.text = it.power
                binding.detSince.text = it.since.toString()
                binding.detColor.text = it.color

                val translateValue: String =
                    if (it.translate) {
                        "si tiene traduccion"
                    } else {
                        "no tiene traduccion"
                    }
                binding.detTranslate.text = translateValue

            }
        }
    }

    /*private fun sendMail() {
        TODO("Not yet implemented")
    }*/

}