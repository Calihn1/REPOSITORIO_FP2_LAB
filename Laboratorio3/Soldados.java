package Laboratorio3;
/*Laboratorio Nr3 - Ejercicio2
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: 3 min
*/
public class Soldados {
    // Atributos de la clase Soldados
    private int vida;
    private String nombre;

    // Métodos mutadores
    public void setNombre(String nombre_) {
        nombre = nombre_;
    }
    public void setVida(int vida_) {
        vida = vida_;
    }

    // Métodos accesores 
    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }

    // Método toString para mostrar la información del soldado
    public String toString() {
        return ("Nombre: " + getNombre() + "\nVida: " + getVida() + "\n");
    }
}
