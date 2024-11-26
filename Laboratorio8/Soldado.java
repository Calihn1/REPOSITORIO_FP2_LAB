package Laboratorio8;

import java.util.*;
/* Laboratorio Nr7 - Ejercicio1
 * Autor: Hilacondo Begazo, Emanuel David
 * Colaboró: con nadie
 * Tiempo: --
 */

public class Soldado {
   
    private String nombre; // Nombre del soldado, incluye su identificador y número de ejército
    private int vida, fila, columna; // Atributos para la vida y posición del soldado en el tablero

    private static int contador = 0; // Contador para soldados del ejército
    private static final int ramdorizarVida = 5; // Valor máximo de vida aleatoria

    public static final int VALOR_MOVIBLE = 1; // Constante para ajustar el índice de posición

    // Constructor que asigna un nombre único al soldado basado en el ejército al que pertenece
    Soldado() {
        if (VideoJuego5.numEjercito == 1) {
            nombre = "soldado" + Soldado.contador + "x" + VideoJuego5.numEjercito;
            Soldado.contador++;
        } else {
            nombre = "soldado" + Soldado.contador+ "x" + VideoJuego5.numEjercito;
            Soldado.contador++;
        }
    }
    
    Soldado(boolean cambio) { }

    public static void reiniciarContadorSoldados() {
        Soldado.contador = 0;
    }

    // Genera un valor aleatorio para la vida del soldado entre 1 y el máximo definido
    public void generarVida() {
        vida = (int)(Math.random() * Soldado.ramdorizarVida + Soldado.VALOR_MOVIBLE);
    }

    // Genera un valor aleatorio para la fila del soldado en el tablero, dentro de los límites
    public void generarFila(int ramdorizar) {
        fila = (int)(Math.random() * ramdorizar + Soldado.VALOR_MOVIBLE);
    }

    // Genera un valor aleatorio para la columna del soldado en el tablero, dentro de los límites
    public void generarColumna(int ramdorizar) {
        columna = (int)(Math.random() * ramdorizar + Soldado.VALOR_MOVIBLE);
    }
    
    // Comprueba si la posición generada para el soldado ya está ocupada por otro soldado en la lista
    public boolean comprobarPosicion(HashMap<String,Soldado> solds, String password) {
    	return(solds.containsKey(password));
    }
   
    // Getters para acceder a los atributos del soldado
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }
   
    // Representación en cadena del soldado, ajustando formato para una correcta alineación
    public String toString() {
        if (fila < 10) {
            return("Nombre: " + nombre + "   Vida: " + vida + "   Fila: " + fila + "    Columna: " + columna);
        } else {
            return("Nombre: " + nombre + "   Vida: " + vida + "   Fila: " + fila + "   Columna: " + columna);
        }
    }




}

