package uvic.cat.entrega5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import uvic.cat.entrega5.entidad.Partida

class AhorcadoResultadoActivity : AppCompatActivity() {

    private lateinit var tvResultado: TextView
    private lateinit var tvPalabra: TextView
    private lateinit var btnReiniciar: Button
    private lateinit var btnMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahorcado_resultado)

        tvResultado = findViewById(R.id.tv_resultado)
        tvPalabra = findViewById(R.id.tv_palabra_final)
        btnReiniciar = findViewById(R.id.btn_reiniciar)
        btnMenu = findViewById(R.id.btn_menu)

        // Recuperamos la partida desde el Singleton
        val app = App_Singleton.getInstance()
        val partida = app.partida ?: Partida("", "")

        // Mostramos resultado según el estado del juego
        if (partida.esGanada()) {
            tvResultado.text = "🎉 ¡Has ganado!"
        } else {
            tvResultado.text = "💀 Has perdido..."
        }

        tvPalabra.text = "La palabra era: ${partida.palabra}"

        // Reiniciar el juego
        btnReiniciar.setOnClickListener {
            val i = Intent(this, AhorcadoActivity::class.java)
            startActivity(i)
            finish()
        }

        // Volver al menú principal
        btnMenu.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
