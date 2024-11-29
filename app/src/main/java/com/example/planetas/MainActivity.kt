package com.example.planetas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definir los planetas y sus características
        val planets = listOf("Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno")
        val planetCharacteristics = mapOf(
            "Mercurio" to "Diámetro: 0.382, Densidad: 5400, Distancia al sol: 0.387",
            "Venus" to "Diámetro: 0.949, Densidad: 5250, Distancia al sol: 0.723",
            "Tierra" to "Diámetro: 1.0, Densidad: 5520, Distancia al sol: 1.0",
            "Marte" to "Diámetro: 0.53, Densidad: 3960, Distancia al sol: 1.542",
            "Júpiter" to "Diámetro: 11.2, Densidad: 1350, Distancia al sol: 5.203",
            "Saturno" to "Diámetro: 9.41, Densidad: 700, Distancia al sol: 9.539",
            "Urano" to "Diámetro: 3.38, Densidad: 1200, Distancia al sol: 19.81",
            "Neptuno" to "Diámetro: 3.81, Densidad: 1500, Distancia al sol: 30.07"
        )

        // Configurar el AutoCompleteTextView para planetas
        val planet1AutoComplete: AutoCompleteTextView = findViewById(R.id.planet1AutoComplete)
        val planet2AutoComplete: AutoCompleteTextView = findViewById(R.id.planet2AutoComplete)

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, planets)
        planet1AutoComplete.setAdapter(adapter)
        planet2AutoComplete.setAdapter(adapter)

        // Actualizar características al seleccionar los planetas
        planet1AutoComplete.setOnItemClickListener { _, _, position, _ ->
            val selectedPlanet = planet1AutoComplete.adapter.getItem(position).toString()
            val planet1Info: TextView = findViewById(R.id.planet1Info)
            planet1Info.text = planetCharacteristics[selectedPlanet] ?: "Características no disponibles"
        }

        planet2AutoComplete.setOnItemClickListener { _, _, position, _ ->
            val selectedPlanet = planet2AutoComplete.adapter.getItem(position).toString()
            val planet2Info: TextView = findViewById(R.id.planet2Info)
            planet2Info.text = planetCharacteristics[selectedPlanet] ?: "Características no disponibles"
        }
    }
}