package uvic.cat.entrega5.entidad;

import java.io.Serializable;

public class Partida implements Serializable {

    private String palabra;
    private String pista;
    private String estadoActual;
    private int intentos = 6;

    // 🔹 Constructor
    public Partida(String palabra, String pista) {
        this.palabra = palabra.toUpperCase();
        this.pista = pista.toUpperCase();
        this.estadoActual = "_ ".repeat(palabra.length()).trim();
    }

    // 🔹 Método para comprobar una letra
    public boolean comprobarLetra(char letra) {
        letra = Character.toUpperCase(letra);
        boolean acierto = false;
        char[] estadoArray = estadoActual.replace(" ", "").toCharArray();

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                estadoArray[i] = letra;
                acierto = true;
            }
        }

        estadoActual = String.valueOf(estadoArray).replaceAll("", " ").trim();

        if (!acierto) {
            intentos--;
        }

        return acierto;
    }

    // 🔹 Comprobaciones del estado
    public boolean esGanada() {
        return !estadoActual.contains("_");
    }

    public boolean esPerdida() {
        return intentos <= 0;
    }

    // 🔹 Getters
    public String getPalabra() {
        return palabra;
    }

    public String getPista() {
        return pista;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public int getIntentos() {
        return intentos;
    }
}
