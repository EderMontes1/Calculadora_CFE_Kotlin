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

        //Variables
        val tarifaBasico = 1.023 * 150
        val tarifaIntermedio = 1.247 * 130
        val tarifaExcedente = 3.646
        val iva_vigente = 0.16

        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)
        val consumoFinalKwh = findViewById<TextView>(R.id.textViewConsumoKwhFinal)
        val consumoPagoTotal = findViewById<TextView>(R.id.textViewPagoFinal)
        val eTextAnterior = findViewById<EditText>(R.id.eTextAnterior)
        val eTextFinal = findViewById<EditText>(R.id.eTextFinal)



        // Cambia el Texto del Consumo en Khw restando (consumoFinal - consumoInicial)
        buttonCalcular.setOnClickListener {
            val consumoInicial = eTextAnterior.text.toString().toInt()
            val consumoFinal = eTextFinal.text.toString().toInt()
            val consumoTotal = consumoFinal - consumoInicial

            //Condicionales para conocer el tipo de tarifa
            if (consumoTotal > 280){
                val pago = (tarifaBasico + tarifaIntermedio) + (tarifaExcedente * (consumoTotal - 280))
                val pagoTotal = (pago * iva_vigente) + (pago)
                consumoPagoTotal.text = "%.2f".format(pagoTotal)
            }else if (consumoTotal  < 151){
                val pago = (consumoTotal * 1.023)
                val pagoTotal = (pago * iva_vigente) + (pago)
                consumoPagoTotal.text = "%.2f".format(pagoTotal)
            }else if(consumoTotal > 150 && consumoTotal < 281){
                val pago = ((tarifaBasico) + (consumoTotal - 150) * 1.247)
                val pagoTotal = (pago * iva_vigente) + (pago)
                consumoPagoTotal.text = "%.2f".format(pagoTotal)
            }

            consumoFinalKwh.text = consumoTotal.toString()

        }
    }
}