package uvic.cat.entrega5

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import uvic.cat.entrega5.entidad.Persona

class GameActivity : AppCompatActivity() {

    private lateinit var p: Persona
    private lateinit var tvName: TextView
    private lateinit var tvAciertos: TextView

    private lateinit var cartas: Array<Button>
    private lateinit var valores: Array<String>

    private var primeraCarta: Button? = null
    private var segundaCarta: Button? = null
    private var aciertos = 0
    private var bloqueo = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tvName = findViewById(R.id.tv_name)
        tvAciertos = findViewById(R.id.tv_aciertos)

        val datos = intent.extras
        if (datos != null) {
            this.p = datos.getSerializable("persona") as Persona
            tvName.text = "Jugador: ${p.nombre}"
        }

        cartas = arrayOf(
            findViewById(R.id.btn1), findViewById(R.id.btn2), findViewById(R.id.btn3), findViewById(R.id.btn4),
            findViewById(R.id.btn5), findViewById(R.id.btn6), findViewById(R.id.btn7), findViewById(R.id.btn8),
            findViewById(R.id.btn9), findViewById(R.id.btn10), findViewById(R.id.btn11), findViewById(R.id.btn12),
            findViewById(R.id.btn13), findViewById(R.id.btn14), findViewById(R.id.btn15), findViewById(R.id.btn16),
            findViewById(R.id.btn17), findViewById(R.id.btn18), findViewById(R.id.btn19), findViewById(R.id.btn20),
            findViewById(R.id.btn21), findViewById(R.id.btn22), findViewById(R.id.btn23), findViewById(R.id.btn24),
            findViewById(R.id.btn25), findViewById(R.id.btn26), findViewById(R.id.btn27), findViewById(R.id.btn28),
            findViewById(R.id.btn29), findViewById(R.id.btn30), findViewById(R.id.btn31), findViewById(R.id.btn32)
        )

        iniciarJuego()
    }

    private fun iniciarJuego() {
        val letras = ('A'..'P').map { it.toString() } // 16 letras
        valores = (letras + letras).toTypedArray() // duplicar para pares
        valores.shuffle() // mezclar

        for (carta in cartas) {
            carta.text = "?"
            carta.isEnabled = true
        }

        aciertos = 0
        tvAciertos.text = "Aciertos: 0"
        primeraCarta = null
        segundaCarta = null
        bloqueo = false
    }

    fun voltearCarta(view: View) {
        if (bloqueo) return //

        val boton = view as Button
        val index = cartas.indexOf(boton)
        boton.text = valores[index]

        // Si es la primera carta
        if (primeraCarta == null) {
            primeraCarta = boton
            boton.isEnabled = false
        }
        // Si es la segunda carta
        else if (segundaCarta == null) {
            segundaCarta = boton
            boton.isEnabled = false
            bloqueo = true // bloquear mientras se compara

            // Comparar
            if (primeraCarta!!.text == segundaCarta!!.text) {
                aciertos++
                tvAciertos.text = "Aciertos: $aciertos"

                // Dejar ambas deshabilitadas permanentemente
                primeraCarta = null
                segundaCarta = null
                bloqueo = false

                // Comprobar si ha ganado
                if (aciertos == 16) {
                    tvAciertos.text = "🎉 ¡Has ganado, ${p.nombre}!"
                    for (carta in cartas) carta.isEnabled = false
                }
            } else {
                // Esperar antes de taparlas
                Handler().postDelayed({
                    primeraCarta!!.text = "?"
                    segundaCarta!!.text = "?"
                    primeraCarta!!.isEnabled = true
                    segundaCarta!!.isEnabled = true
                    primeraCarta = null
                    segundaCarta = null
                    bloqueo = false
                }, 600)
            }
        }
    }

    fun reiniciarJuego(view: View) {
        iniciarJuego()
        tvAciertos.text = "Aciertos: 0"
    }

    fun salir(view: View) {
        finish()
    }
}
