package uz.iskandarbek.imtihon_iyul.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.iskandarbek.imtihon_iyul.R
import uz.iskandarbek.imtihon_iyul.databinding.ItemRvBinding
import uz.iskandarbek.imtihon_iyul.models.User

class RvAdapter(var list: ArrayList<User>) : RecyclerView.Adapter<RvAdapter.Vh>() {

    val selectedColors = MutableList(list.size) { Color.parseColor("#FFFFFF") }

    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: User) {
            itemRv.root.setOnClickListener {
                itemRv.root.setCardBackgroundColor(user.color)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        //         Har bitta Item ni yasalishi

        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size
    //            Nechta item yasay


    override fun onBindViewHolder(holder: Vh, position: Int) {
//            Item qiymatlarini beruchi
        holder.itemView.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim)
        holder.onBind(list[position])
        val user = list[position]
        holder.itemView.setBackgroundColor(selectedColors[position])
        holder.itemView.setOnClickListener {
            selectedColors[position] = Color.parseColor("#FFC107")
            notifyItemChanged(position)
        }
    }
}