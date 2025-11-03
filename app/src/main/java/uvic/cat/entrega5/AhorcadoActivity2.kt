package uvic.cat.entrega5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uvic.cat.entrega5.entidad.Partida

class AhorcadoActivity2 : AppCompatActivity() {

    private lateinit var partida: Partida
    private lateinit var tvPalabra: TextView
    private lateinit var tvPista: TextView
    private lateinit var tvIntentos: TextView
    private lateinit var etLetra: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahorcado2)

        tvPalabra = findViewById(R.id.tv_palabra)
        tvPista = findViewById(R.id.tv_pista)
        tvIntentos = findViewById(R.id.tv_intentos)
        etLetra = findViewById(R.id.et_letra)

        // Recuperar partida desde el Singleton
        val app = App_Singleton.getInstance()
        partida = app.partida!!

        mostrarEstado()
    }

    fun comprobarLetra(view: View) {
        val letraTexto = etLetra.text.toString().trim()
        if (letraTexto.isNotEmpty()) {
            val letra = letraTexto[0]
            val acierto = partida.comprobarLetra(letra)

            if (acierto) {
                Toast.makeText(this, "¡Has acertado!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Fallaste...", Toast.LENGTH_SHORT).show()
            }

            mostrarEstado()

            if (partida.esGanada() || partida.esPerdida()) {
                val i = Intent(this, AhorcadoResultadoActivity::class.java)
                startActivity(i)
                finish()
            }

            etLetra.text.clear()
        }
    }

    private fun mostrarEstado() {
        tvPalabra.text = partida.estadoActual
        tvPista.text = "Pista: ${partida.pista}"
        tvIntentos.text = "Intentos restantes: ${partida.intentos}"

        Log.i("AhorcadoActivity2", "Estado: ${partida.estadoActual}")
    }
}
