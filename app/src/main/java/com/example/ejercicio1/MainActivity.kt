package com.example.ejercicio1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio1.databinding.ActivityMainBinding
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        try {
           Fuel.get("https://restcountries.com/v3.1/all?fields=name,capital,flags")
               .response(){request, response, result ->
                   val JsonBody = response.body().asString("application/json")
                   val gson = Gson()
                   listPaises = gson.fromJson(JsonBody,Array<Pais>::class.java).toList()
                   binding.recyclerView.layoutManager = LinearLayoutManager(this)
                   binding.recyclerView.adapter = PaisAdapter(listPaises,this)


                   //binding.TextHello.setText(listPaises[0].toString())
               }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}