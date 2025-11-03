package uvic.cat.entrega5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import uvic.cat.entrega5.entidad.Persona
import uvic.cat.entrega5.entidad.Partida

class AhorcadoActivity : AppCompatActivity() {

    private lateinit var palabra: EditText
    private lateinit var pista: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahorcado)

        palabra = findViewById(R.id.palabra)
        pista = findViewById(R.id.pista)
    }

    fun iniciarJuego(view: View) {
        val palabraTexto = palabra.text.toString().trim()
        val pistaTexto = pista.text.toString().trim()

        if (palabraTexto.isNotEmpty() && pistaTexto.isNotEmpty()) {
            val app = App_Singleton.getInstance()

            // Recuperar o crear el jugador
            val jugador = app.persona ?: Persona()
            jugador.nombre = "Jugador"


            // Actualizar los datos del jugador
            jugador.palabra_buscar = palabraTexto
            jugador.pista = pistaTexto
            app.persona = jugador

            // Crear y guardar la partida
            val partida = Partida(palabraTexto, pistaTexto)
            app.partida = partida

            Log.i("AhorcadoActivity", "Partida iniciada: $palabraTexto / Pista: $pistaTexto")

            // Ir a la pantalla del juego principal
            val i = Intent(this, AhorcadoActivity2::class.java)
            startActivity(i)
        } else {
            Log.i("AhorcadoActivity", "Faltan datos para iniciar el juego")
        }
    }
}
