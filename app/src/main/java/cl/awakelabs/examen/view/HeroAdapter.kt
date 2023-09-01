package cl.awakelabs.examen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.awakelabs.examen.R
import cl.awakelabs.examen.data.local.HeroEntity
import cl.awakelabs.examen.data.remote.Hero
import cl.awakelabs.examen.databinding.FragmentListBinding
import cl.awakelabs.examen.databinding.ItemHeroBinding
import coil.load

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>() {
    lateinit var binding: ItemHeroBinding
    private val lisItemHero = mutableListOf<HeroEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeroAdapter.ItemHeroViewHolder {
        binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemHeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroAdapter.ItemHeroViewHolder, position: Int) {
        val hero = lisItemHero[position]
        holder.bind(hero)
    }

    fun setData(hero: List<HeroEntity>) {
        this.lisItemHero.clear()
        this.lisItemHero.addAll(hero)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return lisItemHero.size
    }

    class ItemHeroViewHolder(private val view: ItemHeroBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(hero: HeroEntity) {
            view.imgHero.load(hero.image)
            view.txName.text = hero.name
            //view.txOrigin.text = hero.origin
            //view.txPower.text = hero.power
            //view.txSince.text = hero.since.toString()

            view.cardList.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("id", hero.id.toInt())
                Navigation.findNavController(view.root).navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }

    }


}