package cl.awakelabs.examen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelabs.examen.R
import cl.awakelabs.examen.databinding.FragmentListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private val viewModel: HeroViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater,container, false)
        viewModel.getAllHeros()
        loadData()
        return  binding.root
    }

    private fun loadData() {
        val adapter = HeroAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.heroLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }


}