🧩 README.md — Proyecto “Entrega 5: Juegos Android (Memoria & Ahorcado)”
📱 Descripción general

Este proyecto contiene una aplicación Android desarrollada en Kotlin, compuesta por dos minijuegos clásicos:

🎮 Juego de Memoria (Memory Game) — donde el jugador debe encontrar pares de cartas iguales.

🪢 Juego del Ahorcado (Penjat / Ahorcado) — donde el jugador debe adivinar una palabra letra por letra antes de quedarse sin intentos.

Ambos juegos están conectados desde un menú principal que solicita el nombre del jugador, y mantienen sus datos mediante un patrón Singleton global.

🧱 Estructura general del proyecto
Componente	Descripción
MainActivity	Pantalla principal del juego. Permite ingresar el nombre del jugador y acceder a los dos juegos.
GameActivity	Lógica y diseño del juego de memoria. Incluye una cuadrícula de cartas (botones) y control de aciertos.
AhorcadoActivity	Primera pantalla del juego del ahorcado, donde se introduce la palabra y la pista.
AhorcadoActivity2	Segunda pantalla del ahorcado, donde el jugador intenta adivinar la palabra.
AhorcadoResultadoActivity	Pantalla final del ahorcado: muestra si el jugador ha ganado o perdido.
App_Singleton	Clase Singleton que mantiene los datos globales (Persona y Partida) accesibles desde cualquier pantalla.
Persona	Clase de modelo para representar al jugador.
Partida	Clase de modelo para la lógica del juego del ahorcado: palabra, pista, intentos y estado actual.
🧩 Tecnologías utilizadas

Lenguaje: Kotlin

Entorno: Android Studio Electric Eel / Jellyfish

Diseño: XML (ConstraintLayout, GridLayout)

Patrones de diseño:

Singleton (para gestión de estado global)

MVC básico (Actividades + Lógica separada en clases entidad/)

Compatibilidad: Android 7.0 (API 24) o superior

🧠 Lógica principal
🧮 Juego de Memoria

Usa una matriz de 8x4 (32 botones).

Las cartas se almacenan en un Array y se comparan dos a dos.

Se contabilizan los aciertos y se reinicia la partida al completarla.

Dispone de botón para reiniciar y otro para salir del juego.

🪢 Juego del Ahorcado

Fase 1: El jugador introduce una palabra secreta y una pista.

Fase 2: Otro jugador intenta adivinar la palabra letra a letra.

Fase 3: Se muestra el resultado (ganó o perdió).

La clase Partida gestiona toda la lógica (intentos, letras acertadas, estado actual).

🔁 Persistencia global

Los datos del jugador y de la partida se guardan en un Singleton (App_Singleton),
evitando el uso de Intent.putExtra() y permitiendo una transición fluida entre pantallas.

⚙️ Instalación y ejecución

Clona el repositorio o copia el proyecto en Android Studio:
```
git clone https://github.com/tuusuario/Entrega5-JuegosAndroid.git
```

Abre el proyecto en Android Studio.

Conecta un dispositivo o inicia un emulador.

Pulsa ▶️ Run ‘app’ para ejecutar la aplicación.

🧩 Navegación entre pantallas
```
MainActivity
 ├──> GameActivity (Juego de Memoria)
 └──> AhorcadoActivity (Inicio del Ahorcado)
       └──> AhorcadoActivity2 (Juego)
             └──> AhorcadoResultadoActivity (Resultado)
```
👩‍💻 Autoría y créditos

Autor: Duván Vargas
Centro: Universitat de Vic – Mòdul 0485 de Programació
Curso: DAM 2º — 2024 / 2025
Lenguaje: Kotlin
IDE: Android Studio

🧾 Licencia

Este proyecto se distribuye bajo la licencia MIT License, que permite su libre uso, copia y modificación con atribución al autor original.

💬 Conclusión

Este proyecto demuestra el uso de Kotlin aplicado a Android Studio, implementando:

Navegación entre múltiples Activities.

Paso de datos entre pantallas mediante un patrón Singleton.

Gestión de lógica de juego modular y orientada a objetos.

Diseño adaptable mediante ConstraintLayout y GridLayout.

📚 Es un ejemplo completo de desarrollo de una app educativa con varios juegos integrados y código limpio, modular y mantenible.
