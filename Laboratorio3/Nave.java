package Laboratorio3;
/*Laboratorio Nr3 - Ejercicio1
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: 7 min
*/
public class Nave {
    // Atributos de la clase Nave
    private String nombre, columna;
    private int fila, puntos;
    private boolean estado;
   
    // Métodos mutadores 
    public void setNombre(String nom) {
        nombre = nom;
    }
    public void setFila(int fil) {
        fila = fil;
    }
    public void setColumna(String col) {
        columna = col;
    }
    public void setEstado(boolean est) {
        estado = est;
    }
    public void setPuntos(int punt) {
        puntos = punt;
    }

    // Métodos accesores 
    public String getNombre() {
        return nombre;
    }
    public int getFila() {
        return fila;
    }
    public String getColumna() {
        return columna;
    }
    public boolean getEstado() {
        return estado;
    }
    public int getPuntos() {
        return puntos;
    }

    // Método toString para mostrar la información de la nave
    public String toString() {
        return ("Nombre: " + getNombre() + "\nFila: " + getFila() + 
                "\nColumna: " + getColumna() + "\nEstado: " + getEstado() + 
                "\nPuntos: " + getPuntos());
    }
}



