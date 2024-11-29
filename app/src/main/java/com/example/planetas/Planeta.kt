package com.example.planetas

data class Planeta(
    val nombre: String,
    val diametro: Double,  // en múltiplos del diámetro de la Tierra
    val distanciaSol: Double,  // en unidades astronómicas (UA)
    val densidad: Int  // en kg/m³
)