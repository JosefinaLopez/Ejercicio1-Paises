package com.example.ejercicio1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PaisAdapter(private val paises: List<Pais>,private val contexto:Context) :
    RecyclerView.Adapter<PaisAdapter.PaisViewHolder>() {

    // ViewHolder para cada elemento de la lista
     class PaisViewHolder(itemView: View, var contexto:Context) : RecyclerView.ViewHolder(itemView) {
        private var TextPais = itemView.findViewById<TextView>(R.id.TextPais)
        private var TextInfo = itemView.findViewById<TextView>(R.id.TextAlt)
        private var Img = itemView.findViewById<ImageView>(R.id.lvbandera)
        private var cont = itemView.findViewById<CardView>(R.id.container)

        // Función para vincular los datos de un país con las vistas del ViewHolder
        fun bind(pais: Pais) {
            TextPais.text = pais.name.common.toString()
            TextInfo.text = pais.flags.alt
            val imageUrl = pais.flags.png
            Picasso.get().load(imageUrl).into(Img)
            cont.setOnClickListener {
                val intent = Intent(contexto, DetallePais::class.java)
                intent.putExtra("nombre", pais.name.common)
                intent.putExtra("bandera", pais.flags.png)
                intent.putExtra("informacion", pais.flags.alt)
                intent.putExtra("capital",pais.capital[0])
                contexto.startActivity(intent)

            }

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_paises, parent, false)
        return PaisViewHolder(view,contexto)
    }

    override fun getItemCount(): Int {
     return paises.size
    }

    override fun onBindViewHolder(holder: PaisViewHolder, position: Int) {
        val pais = paises[position]
        holder.bind(pais)
    }
}

