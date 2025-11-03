package uvic.cat.entrega5.entidad;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private String palabra_buscar;
    private String pista;

    public String getPalabra_buscar() {
        return palabra_buscar;
    }

    public void setPalabra_buscar(String palabra_buscar) {
        this.palabra_buscar = palabra_buscar;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, String palabra_buscar, String pista) {
        this.nombre = nombre;
        this.palabra_buscar = palabra_buscar;
        this.pista = pista;

    }

    public Persona() {
        this.nombre = "";
        this.palabra_buscar = "";
        this.pista = "";


    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", palabra_buscar='" + palabra_buscar + '\'' +
                ", pista='" + pista + '\'' +
                '}';
    }
}
