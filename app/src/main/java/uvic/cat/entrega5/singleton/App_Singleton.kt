package uvic.cat.entrega5

import uvic.cat.entrega5.entidad.Persona
import uvic.cat.entrega5.entidad.Partida

class App_Singleton private constructor() {

    var persona: Persona? = null
    var partida: Partida? = null

    companion object {
        @Volatile
        private var instance: App_Singleton? = null

        fun getInstance(): App_Singleton {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = App_Singleton()
                    }
                }
            }
            return instance!!
        }
    }

    fun resetPartida() {
        partida = null
    }

    fun resetAll() {
        persona = null
        partida = null
    }
}
