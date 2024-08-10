package sv.edu.udb.desafio01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciando los botones
        val btnCalculator = findViewById<Button>(R.id.btnCalculator)
        val btnPromedio = findViewById<Button>(R.id.btnPromedio)
        val btnRenta = findViewById<Button>(R.id.btnRenta)

        // Configurando los listeners para los botones
        btnCalculator.setOnClickListener {
            // Abre la actividad de la Calculadora
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        btnPromedio.setOnClickListener {
            // Abre la actividad del Promedio de Notas
            val intent = Intent(this, PromedioActivity::class.java)
            startActivity(intent)
        }
        btnRenta.setOnClickListener {
            // Abre la actividad del Promedio de Notas
            val intent = Intent(this, RentaActivity::class.java)
            startActivity(intent)
        }
    }
}
