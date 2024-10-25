package Laboratorio6;
import java.util.ArrayList;

public class VideoJuego3 {
    static final int tamanoTablero = 10;
    public static int numEjercito = 0;
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<ArrayList<Soldado>>();

        int cantSoldados1 = (int)(Math.random() * tamanoTablero + 1);
        ArrayList<Soldado> ejercito1 = new ArrayList<Soldado>() ;
        
        int cantSoldados2 = (int)(Math.random() * tamanoTablero + 1);
        ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>() ;
        
        generarEspaciosArrayList(tablero);
        
        numEjercito++;
        llenarAtributosSoldados(ejercito1, cantSoldados1);
        llenarTablero(tablero, ejercito1);
        
        numEjercito++;
        llenarAtributosSoldados(ejercito2, cantSoldados2);
        llenarTablero(tablero, ejercito2);
        
        imprimirTablero(tablero);

        mostrarSoldadoMayorVida(ejercito1);
        mostrarSoldadoMayorVida(ejercito2);
        
        System.out.println("\nPromedio de vida de los soldados: " + promedioVidaSoldados(ejercito1));
        System.out.println("\nPromedio de vida de los soldados: " + promedioVidaSoldados(ejercito2));
        
        mostrarSoldados(ejercito1);
        mostrarSoldados(ejercito2);

        rankingPorVidaSoldados1(ejercito1);
        rankingPorVidaSoldados2(ejercito2);
        
        decidirEjercitoGanador(ejercito1, ejercito2);
    }

    public static void generarEspaciosArrayList(ArrayList<ArrayList<Soldado>> tablero) {
        for(int i=0; i<tamanoTablero; i++) {
        	ArrayList<Soldado> arr = new ArrayList<Soldado>();
            tablero.add(arr);
            
            for(int j=0; j<tamanoTablero; j++) 
                tablero.get(i).add(null);
        }
    }

    public static void llenarAtributosSoldados(ArrayList<Soldado> soldados, int cantSolds) {
        for (int i = 0; i < cantSolds; i++) {
            boolean posicionOcupada = true;

            Soldado soldado = new Soldado();
            soldado.generarVida();

            while (posicionOcupada) {
                soldado.generarFila(tamanoTablero);
                soldado.generarColumna(tamanoTablero);
                posicionOcupada = soldado.comprobarPosicion(soldados, i);
            }
            soldados.add(soldado);
        }
    }

    // Método que coloca los soldados en el tablero
    public static void llenarTablero(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> ejercito) {
        for (Soldado s : ejercito) {
            int fila = s.getFila() - Soldado.VALOR_MOBIBLE;// Convertimos la fila a índice
            int columna = s.getColumna() - Soldado.VALOR_MOBIBLE;
            tablero.get(fila).set(columna,s); // Colocamos el soldado en la posición correspondiente
        }
    }

    // Método que imprime el tablero con la ubicación de los soldados
    public static void imprimirTablero(ArrayList<ArrayList<Soldado>> tablero) {
        imprimirLetrasColumnas(); // Imprimimos las letras de las columnas (A-J)

        String separador = "|   ", separador1 = "|_______", separador2 = "|";
        System.out.println("\n\t" + " _______________________________________________________________________________");

        // Recorremos el tablero fila por fila
        for (int i = 0; i < tablero.size(); i++) {
            System.out.print(i + 1 + "\t"); // Imprimimos el número de fila

            for (int j = 0; j < tablero.get(i).size(); j++) {
                System.out.print(separador);
                esSoldado(tablero.get(i).get(j)); // Comprobamos si hay un soldado en esa posición
            }
            System.out.println(separador2); // Fin de la fila

            // Imprimimos la separación entre filas
            System.out.print("\t");
            for (int j = 0; j < tablero.size(); j++) {
                System.out.print(separador1);
            }
            System.out.println(separador2); // Fin de la separación
        }
    }

    // Imprime las letras de las columnas (A-J)
    public static void imprimirLetrasColumnas() {
        System.out.print("     ");
        for (char i = 'A'; i < 'K'; i++) {
            System.out.print("       " + i);
        }
    }

    // Verifica si hay un soldado en la posición y lo indica con una "x"
    public static void esSoldado(Soldado soldado) {
        if (soldado == null) {
            System.out.print("    ");
        }
        else {
        	String nombre = soldado.getNombre();
        	if(nombre.substring( nombre.length()-1 ).equals( "1" ))
        		System.out.print("x   ");
        	else
        		System.out.print("°   ");
        }
    }
 // Muestra el soldado con mayor vida después de ordenar por vida
    public static void mostrarSoldadoMayorVida(ArrayList<Soldado> ejercito) {
    	 Soldado soldadoMasVida = ejercito.get(0);
    	 
        for(int i = 1; i < ejercito.size()-1; i++) {
        	Soldado soldado = ejercito.get(i);
        	if(soldadoMasVida.getVida() < soldado.getVida() ) {
        		soldadoMasVida = soldado;
        	}
        }
        System.out.println("\nSoldado con más vida: " + soldadoMasVida); // Mostramos el primero (máxima vida)
    }

    // Calcula el promedio de vida de todos los soldados
    public static double promedioVidaSoldados(ArrayList<Soldado> ejercito) {
        int promedio = 0;

        // Sumamos la vida de todos los soldados
        for (Soldado s : ejercito)
            promedio += s.getVida();

        return (double) promedio / ejercito.size(); // Dividimos por la cantidad de soldados
    }

    // Muestra todos los soldados en el arreglo
    public static void mostrarSoldados(ArrayList<Soldado> ejercito) {
    	System.out.println();
        for (Soldado s : ejercito)
            System.out.println(s);
    }

    // Método que ordena los soldados por vida y muestra el ranking
    public static void rankingPorVidaSoldados1(ArrayList<Soldado> ejercito) {
        ordenamientoBurbuja(ejercito); // Ordenamos por el método de inserción
        mostrarSoldados(ejercito); // Mostramos los soldados ya ordenados
    }
    
 // Ordenamiento burbuja para ordenar soldados por vida (mayor a menor)
    public static void ordenamientoBurbuja(ArrayList<Soldado> ejercito) {
        for (int i = 1; i < ejercito.size(); i++) {
            for (int j = 0; j < ejercito.size() - i; j++) {
            		Soldado soldado1 = ejercito.get(j);
            		Soldado soldado2 = ejercito.get(j+1);
            		
                if (soldado1.getVida() < soldado2.getVida()) {
                    ejercito.set(j, soldado2);
                    ejercito.set(j+1, soldado1);
                }
            }
        }
    }
    
 // Método que ordena los soldados por vida y muestra el ranking
    public static void rankingPorVidaSoldados2(ArrayList<Soldado> ejercito) {
        ordenamientoInsercion(ejercito); // Ordenamos por el método de inserción
        mostrarSoldados(ejercito); // Mostramos los soldados ya ordenados
    }
    
    // Ordenamiento por inserción para ordenar soldados por vida (mayor a menor)
    public static void ordenamientoInsercion(ArrayList<Soldado> ejercito) {
        for (int i = 1; i < ejercito.size(); i++) {
            for (int j = i; j >= 1; j--) {
            	Soldado soldado1 = ejercito.get(j-1);
        		Soldado soldado2 = ejercito.get(j);
        		
        		if (soldado1.getVida() < soldado2.getVida()) {
                    ejercito.set(j-1, soldado2);
                    ejercito.set(j, soldado1);
                }
            }
        }
    }
    
    public static void decidirEjercitoGanador(ArrayList<Soldado> ejer1, ArrayList<Soldado> ejer2) {
    	if(ejer1.size() > ejer2.size()) { 
    		System.out.println("\nEl ejercito ganador es el 1: ");
    		mostrarSoldados(ejer1);
    	}
    	else if(ejer1.size() < ejer2.size()) {
    		System.out.println("\nEl ejercito ganador es el 2: ");
    		mostrarSoldados(ejer2);
    	}
    	else if(promedioVidaSoldados(ejer1) > promedioVidaSoldados(ejer2)) {
    		System.out.println("\nEl ejercito ganador es el 1: ");
    		mostrarSoldados(ejer1);
    	}
    	else if(promedioVidaSoldados(ejer1) < promedioVidaSoldados(ejer2)) {
    		System.out.println("\nEl ejercito ganador es el 2: ");
    		mostrarSoldados(ejer2);
    	}
    	else
    		System.out.println("\nEs un empate");
    }
}


    
