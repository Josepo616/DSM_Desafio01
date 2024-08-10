package sv.edu.udb.desafio01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RentaActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var Nombre: EditText
    lateinit var SalarioBase: EditText
    lateinit var Resultado: TextView
    lateinit var Calcular: Button
    lateinit var Bb: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_renta)
        Nombre = findViewById(R.id.Nombre)
        SalarioBase = findViewById(R.id.SalarioBase)
        Resultado = findViewById(R.id.Resultado)
        Calcular = findViewById(R.id.Calcular)
        Bb = findViewById(R.id.Bb)

        Calcular.setOnClickListener(this)
        Bb.setOnClickListener{
            finish()
        }
    }

    override fun onClick(p0: View?) {
        val nombre: String = Nombre.text.toString()
        val salarioBaseStr: String = SalarioBase.text.toString()

        if (nombre.isEmpty() || salarioBaseStr.isEmpty()) {
            Resultado.text = "Por favor, ingrese el nombre y el salario base."
            return
        }

        try {
            val salarioBase = salarioBaseStr.toDouble()
            val afp = salarioBase * 0.0725
            val isss: Double
            if (salarioBase <= 1000) {

                isss = salarioBase * 0.03
            }
            else {
                isss = 30.0

            }
            val salariodescontado =  salarioBase - afp - isss
            val renta = calcularRenta(salariodescontado)
            val salarioNeto = salariodescontado - renta

            Resultado.text = """
                Emepleado: $nombre
                Salario Base: ${String.format("%.2f", salarioBase)}
                Renta: ${String.format("%.2f", renta)}
                AFP: ${String.format("%.2f", afp)}
                ISSS: ${String.format("%.2f", isss)}
                Salario Neto: ${String.format("%.2f", salarioNeto)}
            """.trimIndent()

        } catch (e: NumberFormatException) {
            Resultado.text = "Por favor, ingrese un salario válido."
        }
    }

    private fun calcularRenta(salario: Double): Double {
        return when {
            salario <= 472.0 -> 0.0
            salario <= 895.24 -> (salario - 472.0) * 0.1 + 17.67
            salario <= 2038.10 -> (salario - 895.24) * 0.2 + 60.0
            else -> (salario - 2038.10) * 0.3 + 288.57
        }
    }
}
