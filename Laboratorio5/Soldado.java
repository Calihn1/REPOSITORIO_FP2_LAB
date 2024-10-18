package Laboratorio5;
/*Laboratorio Nr5 - Ejercicio1
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: --
*/

public class Soldado {
    private String nombre;
    private int vida, fila, columna;
    private static int contador = 0;
    private static final int ramdorizarVida = 5;

    Soldado() {
        nombre = "soldado"+contador;
        contador++;
    }

    public void generarVida() {
        vida = (int)( Math.random()*ramdorizarVida+1);
    }

    public void generarFila(int ramdorizar) {
        fila = (int)( Math.random()*ramdorizar+1);
    }

    public void generarColumna(int ramdorizar) {
        columna = (int)( Math.random()*ramdorizar+1);
    }
    
    public boolean comprobarPosicion(Soldado[] solds, int indiceActual) {
    	for(int i = 0; i < indiceActual; i++) {
    		
    		if ( this.fila == solds[i].getFila() && this.columna == solds[i].getColumna()  )
    			return true;
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
    
    public String toString() {
    	if(fila < 10)
    		return("\nNombre: " + nombre + "   Vida: " + vida + "   Fila: " + fila + "    Columna: " + columna);
    	else
    		return("\nNombre: " + nombre + "   Vida: " + vida + "   Fila: " + fila + "   Columna: " + columna);
    }
}

