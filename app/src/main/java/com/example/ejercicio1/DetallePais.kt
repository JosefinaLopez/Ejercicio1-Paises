package com.example.ejercicio1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio1.databinding.ActivityDetallePaisBinding
import com.squareup.picasso.Picasso

class DetallePais : AppCompatActivity() {
    private lateinit var binding: ActivityDetallePaisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Se inicializa el binding
        binding = ActivityDetallePaisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Obtener extras del Intent
        val extras = intent.extras

        if (extras != null) {
            val nombrePais = extras.getString("nombre")
            val capital = extras.getString("capital")
            val bandera = extras.getString("bandera")
            val informacion = extras.getString("informacion")

            Picasso.get().load(bandera).into(binding.Bandera)
            binding.TextNom.text = nombrePais
            binding.textInfor.text = informacion
            binding.TextCapital.text = capital



        }
    }
}