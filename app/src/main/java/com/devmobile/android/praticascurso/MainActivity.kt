package com.devmobile.android.praticascurso

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.devmobile.android.praticascurso.databinding.ActivityMainBinding

class MainActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var bindind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(bindind.root)

        bindind.buttonValueToCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        calculate()
    }

    private fun calculate() {
        val totToPay: Float
        val distanceText = bindind.editDistance.text.toString()
        val priceText = bindind.editPrice.text.toString()
        val autonomyText = bindind.editAutonomy.text.toString()
        val valueToPay: TextView = bindind.textValueToPay

        try {
            totToPay = distanceText.toFloat() * priceText.toFloat() / autonomyText.toFloat()

            valueToPay.setText("R$ ${"%.2f".format(totToPay)}")

            showToast("Valor calculado com Sucesso")

        } catch (e: ArithmeticException) {
            showToast("Não pode ter divisão por 0")
        } catch (e: NumberFormatException) {
            showToast("Preencha todos os campos")
        }
    }

    private fun showToast(message: String) {

        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}