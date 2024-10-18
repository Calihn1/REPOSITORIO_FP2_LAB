package Laboratorio5;
/* Laboratorio Nr5 - Ejercicio1
 * Autor: Hilacondo Begazo, Emanuel David
 * Colaboró: con nadie
 * Tiempo: --
 */

public class Soldado {
    // Atributos privados del soldado
    private String nombre;
    private int vida, fila, columna;
    // Variable estática que lleva el conteo de los soldados creados
    private static int contador = 0;
    // Vida máxima aleatoria que un soldado puede tener
    private static final int ramdorizarVida = 5;

    // Constructor del soldado, genera un nombre único basado en el contador
    Soldado() {
        nombre = "soldado" + contador;
        contador++;
    }

    // Genera un nivel de vida aleatorio para el soldado (entre 1 y 5)
    public void generarVida() {
        vida = (int)(Math.random() * ramdorizarVida + 1);
    }

    // Genera aleatoriamente la fila en la que se colocará el soldado
    public void generarFila(int ramdorizar) {
        fila = (int)(Math.random() * ramdorizar + 1);
    }

    // Genera aleatoriamente la columna en la que se colocará el soldado
    public void generarColumna(int ramdorizar) {
        columna = (int)(Math.random() * ramdorizar + 1);
    }
    
    // Comprueba si la posición de este soldado ya está ocupada por otro
    public boolean comprobarPosicion(Soldado[] solds, int indiceActual) {
        for (int i = 0; i < indiceActual; i++) {
            // Si otro soldado ya está en la misma fila y columna, la posición está ocupada
            if (this.fila == solds[i].getFila() && this.columna == solds[i].getColumna()) {
                return true;
            }
        }
        return false; // No se encontró conflicto de posición
    }
    
    // Devuelve la fila en la que se encuentra el soldado
    public int getFila() {
        return fila;
    }
    
    // Devuelve la columna en la que se encuentra el soldado
    public int getColumna() {
        return columna;
    }
    
    // Devuelve el nombre del soldado
    public String getNombre() {
        return nombre;
    }
    
    // Devuelve la vida del soldado
    public int getVida() {
        return vida;
    }
    
    // Representación en cadena del soldado para imprimirlo
    public String toString() {
        // Si la fila es menor a 10, se ajusta el formato para alinear correctamente las columnas
        if (fila < 10) {
            return("\nNombre: " + nombre + "   Vida: " + vida + "   Fila: " + fila + "    Columna: " + columna);
        } else {
            return("\nNombre: " + nombre + "   Vida: " + vida + "   Fila: " + fila + "   Columna: " + columna);
        }
    }
}

