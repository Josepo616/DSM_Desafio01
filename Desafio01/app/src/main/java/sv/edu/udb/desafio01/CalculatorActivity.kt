package sv.edu.udb.desafio01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var N1: EditText
    lateinit var N2: EditText
    lateinit var Resultado: TextView
    lateinit var Bs: Button
    lateinit var Br: Button
    lateinit var Bm: Button
    lateinit var Bd: Button
    lateinit var Bb: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        N1 = findViewById(R.id.N1)
        N2 = findViewById(R.id.N2)
        Resultado = findViewById(R.id.Resultado)
        Bs = findViewById(R.id.Bs)
        Br = findViewById(R.id.Br)
        Bm = findViewById(R.id.Bm)
        Bd = findViewById(R.id.Bd)
        Bb = findViewById(R.id.Bb)

        Bs.setOnClickListener(this)
        Br.setOnClickListener(this)
        Bm.setOnClickListener(this)
        Bd.setOnClickListener(this)
        Bb.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a la anterior
        }
    }

    override fun onClick(p0: View?) {
        val n1: String = N1.text.toString()
        val n2: String = N2.text.toString()

        if (n1.isEmpty() || n2.isEmpty()) {
            Resultado.text = "Por favor, ingrese ambos números."
            return
        }

        try {
            val num1 = n1.toDouble()
            val num2 = n2.toDouble()

            when (p0?.id) {
                R.id.Bs -> {
                    val result = num1 + num2
                    Resultado.text = "Resultado = $result"
                }
                R.id.Br -> {
                    val result = num1 - num2
                    Resultado.text = "Resultado = $result"
                }
                R.id.Bm -> {
                    val result = num1 * num2
                    Resultado.text = "Resultado = $result"
                }
                R.id.Bd -> {
                    if (num2 == 0.0) {
                        Resultado.text = "No se puede dividir entre 0"
                    } else {
                        val result = num1 / num2
                        Resultado.text = "Resultado = $result"
                    }
                }
            }
        } catch (e: NumberFormatException) {
            Resultado.text = "Por favor, ingrese valores numéricos válidos."
        }
    }
}
