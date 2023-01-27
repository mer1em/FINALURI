package com.example.finaluri.pagers
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finaluri.R
import com.example.finaluri.dataclass.DataClassGood


class RecyclerGood(private val list: List<DataClassGood>) : RecyclerView.Adapter<RecyclerGood.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flag : ImageView
        val name : TextView
        val rank : TextView
        val cases : TextView
        val news : TextView

        init {
            flag = itemView.findViewById(R.id.goodView)
            name = itemView.findViewById(R.id.goodText)
            rank = itemView.findViewById(R.id.goodText2)
            cases = itemView.findViewById(R.id.goodText3)
            news= itemView.findViewById(R.id.goodText4)


            news.setOnClickListener{
                val url = "https://www.google.com/search?q=latest+news+in+"+name.text+"+republic"
                val intent = Intent(ACTION_VIEW)
                intent.data = Uri.parse(url)
                itemView.context.startActivity(intent)
            }


            flag.setOnClickListener{
                val url = "https://en.wikipedia.org/wiki/"+name.text
                val intent = Intent(ACTION_VIEW)
                intent.data = Uri.parse(url)
                itemView.context.startActivity(intent)
            }

            cases.setOnClickListener{
                val url = "https://www.google.com/search?q=Covid+Cases+"+name.text
                val intent = Intent(ACTION_VIEW)
                intent.data = Uri.parse(url)
                itemView.context.startActivity(intent)
            }
        }

        fun data(dataClassGood: DataClassGood) {
            Glide.with(itemView.context).load(dataClassGood.pic).into(flag)
            name.text = dataClassGood.dish_name
            rank.text= dataClassGood.rank

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_country, parent, false)
        return PersonViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val country = list[position]
        holder.data(country)

    }

    override fun getItemCount() = list.size
}