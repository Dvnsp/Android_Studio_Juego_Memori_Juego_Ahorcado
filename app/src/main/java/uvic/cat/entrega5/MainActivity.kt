package uvic.cat.entrega5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uvic.cat.entrega5.entidad.Persona

class MainActivity : AppCompatActivity() {

    private lateinit var p: Persona
    private lateinit var t_name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("MainActivity", "onCreate listo")

        this.t_name = findViewById(R.id.name)
        this.p = Persona("", "", "")  // ✅ Asegura que el objeto existe
    }

    fun goTomemory(view: View) {
        Log.i("MainActivity", "Botón de Memoria pulsado")

        val name = t_name.text.toString()

        if (name.isNotEmpty()) {
            this.p = Persona(name, "", "")  // ✅ Pasa los tres parámetros

            val i = Intent(this, GameActivity::class.java)
            i.putExtra("persona", this.p)
            startActivity(i)

        } else {
            Log.i("MainActivity", "No hay nombre introducido")
        }
    }

    fun goTOahorcado(view: View) {
        Log.i("MainActivity", "Botón de Ahorcado pulsado")

        val name = t_name.text.toString()

        if (name.isNotEmpty()) {
            this.p = Persona(name, "", "")

            val i = Intent(this, AhorcadoActivity::class.java)
            i.putExtra("persona", this.p)
            startActivity(i)

        } else {
            Log.i("MainActivity", "No hay nombre introducido para el ahorcado")
        }
    }
}
