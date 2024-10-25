package Laboratorio6;
import java.util.ArrayList;

public class Soldado {
	   
    private String nombre;
    private int vida, fila, columna;

    private static int contador1 = 0;
    private static int contador2 = 0;
    private static final int ramdorizarVida = 5;

    public static final int VALOR_MOBIBLE = 1;

    Soldado() {
    	if(VideoJuego3.numEjercito == 1) {
        	nombre = "soldado" + contador1 + "x" + VideoJuego3.numEjercito;
        	contador1++;
        }
        else {
        	nombre = "soldado" + contador2 + "x" + VideoJuego3.numEjercito;
        	contador2++;
        }
    }

    public void generarVida() {
        vida = (int)(Math.random() * ramdorizarVida + Soldado.VALOR_MOBIBLE);
    }

    public void generarFila(int ramdorizar) {
        fila = (int)(Math.random() * ramdorizar + Soldado.VALOR_MOBIBLE);
    }

    public void generarColumna(int ramdorizar) {
        columna = (int)(Math.random() * ramdorizar + Soldado.VALOR_MOBIBLE);
    }
   
    public boolean comprobarPosicion(ArrayList<Soldado> solds, int indiceActual) {
        for (int i = 0; i < indiceActual; i++) {
            Soldado soldExistente = solds.get(i);  

            if (this.fila == soldExistente.getFila() && this.columna == soldExistente.getColumna()) {
                return true;
            }
        }
        return false;
    }
   
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
   
    // Representación en cadena del soldado para imprimirlo
    public String toString() {
        // Si la fila es menor a 10, se ajusta el formato para alinear correctamente las columnas
        if (fila < 10) {
            return("Nombre: " + nombre + "   Vida: " + vida + "   Fila: " + fila + "    Columna: " + columna);
        } else {
            return("Nombre: " + nombre + "   Vida: " + vida + "   Fila: " + fila + "   Columna: " + columna);
        }
    }

}
