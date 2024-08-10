package sv.edu.udb.desafio01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PromedioActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var Nombre: EditText
    lateinit var N1: EditText
    lateinit var N2: EditText
    lateinit var N3: EditText
    lateinit var N4: EditText
    lateinit var N5: EditText
    lateinit var Resultado: TextView
    lateinit var Bpromedio: Button
    lateinit var Bb: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio)
        Nombre = findViewById(R.id.Nombre)
        N1 = findViewById(R.id.N1)
        N2 = findViewById(R.id.N2)
        N3 = findViewById(R.id.N3)
        N4 = findViewById(R.id.N4)
        N5 = findViewById(R.id.N5)
        Resultado = findViewById(R.id.Resultado)
        Bpromedio = findViewById(R.id.Bpromedio)
        Bb = findViewById(R.id.Bb)


        Bpromedio.setOnClickListener(this)
        Bb.setOnClickListener{
            finish()
        }



    }

    override fun onClick(p0: View?) {
        val nombre: String = Nombre.text.toString()
        val n1: String = N1.text.toString()
        val n2: String = N2.text.toString()
        val n3: String = N3.text.toString()
        val n4: String = N4.text.toString()
        val n5: String = N5.text.toString()

        if (p0?.id == R.id.Bpromedio) {
            try {
                val num1 = n1.toDouble()
                val num2 = n2.toDouble()
                val num3 = n3.toDouble()
                val num4 = n4.toDouble()
                val num5 = n5.toDouble()

                if (num1 !in 0.0..10.0 || num2 !in 0.0..10.0 || num3 !in 0.0..10.0 || num4 !in 0.0..10.0 || num5 !in 0.0..10.0) {
                    Resultado.text = "Las notas deben estar entre 0 y 10."
                    return
                }

                val PorcentajeNota1 = 1.5
                val PorcentajeNota2 = 1.5
                val PorcentajeNota3 = 2.0
                val PorcentajeNota4 = 2.5
                val PorcentajeNota5 = 2.5

                val result = (num1 * PorcentajeNota1 +
                        num2 * PorcentajeNota2 +
                        num3 * PorcentajeNota3 +
                        num4 * PorcentajeNota4 +
                        num5 * PorcentajeNota5) /
                        (PorcentajeNota1 + PorcentajeNota2 + PorcentajeNota3 + PorcentajeNota4 + PorcentajeNota5)

                val estado = if (result >= 6) "aprobado" else "reprobado"

                Resultado.text = "El promedio para el estudiante $nombre es: $result ($estado)"
            } catch (e: NumberFormatException) {
                Resultado.text = "Por favor, ingresa valores numéricos válidos."
            }
        }
    }
}