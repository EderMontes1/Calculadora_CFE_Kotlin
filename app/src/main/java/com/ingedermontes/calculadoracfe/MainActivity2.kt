package com.ingedermontes.calculadoracfe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)
        val consumoFinalKwh = findViewById<TextView>(R.id.textViewConsumoKwhFinal)
        val eTextAnterior = findViewById<EditText>(R.id.eTextAnterior)
        val eTextFinal = findViewById<EditText>(R.id.eTextFinal)


        buttonCalcular.setOnClickListener {
            // Cambia el Texto del Consumo en Khw restando (consumoFinal - consumoInicial)
            val consumoInicial = eTextAnterior.text.toString().toInt()
            val consumoFinal = eTextFinal.text.toString().toInt()
            val consumoTotal = consumoFinal - consumoInicial


            consumoFinalKwh.text= consumoTotal.toString()
        }
    }
}