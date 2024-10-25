package Laboratorio6;
import java.util.ArrayList;
/* Laboratorio Nr6 - Ejercicio1
 * Autor: Hilacondo Begazo, Emanuel David
 * Colaboró: con nadie
 * Tiempo: --
 */

public class VideoJuego3 {
    static final int tamanoTablero = 10; // Tamaño del tablero 10x10
    public static int numEjercito = 0; // Número del ejército actual
    
    public static void main(String[] args) {
        // Inicialización de la matriz tablero de ArrayList para almacenar soldados
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<ArrayList<Soldado>>();
        
        // Cantidad de soldados para el primer ejército, generada aleatoriamente
        int cantSoldados1 = (int)(Math.random() * tamanoTablero + 1);
        ArrayList<Soldado> ejercito1 = new ArrayList<Soldado>(); // Lista de soldados para el primer ejército
        
        // Cantidad de soldados para el segundo ejército, generada aleatoriamente
        int cantSoldados2 = (int)(Math.random() * tamanoTablero + 1);
        ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>(); // Lista de soldados para el segundo ejército
        
        // Llenado del tablero con espacios nulos para representar posiciones vacías
        generarEspaciosArrayList(tablero);
        
        // Inicialización y llenado de atributos para el primer ejército
        numEjercito++;
        llenarAtributosSoldados(ejercito1, cantSoldados1);
        llenarTablero(tablero, ejercito1);
        
        // Inicialización y llenado de atributos para el segundo ejército
        numEjercito++;
        llenarAtributosSoldados(ejercito2, cantSoldados2);
        llenarTablero(tablero, ejercito2);
        
        // Impresión del tablero mostrando las posiciones de los soldados
        imprimirTablero(tablero);

        // Mostrar el soldado con mayor vida en cada ejército
        mostrarSoldadoMayorVida(ejercito1);
        mostrarSoldadoMayorVida(ejercito2);
        
        // Cálculo e impresión del promedio de vida de los soldados en cada ejército
        System.out.println("\nPromedio de vida de los soldados: " + promedioVidaSoldados(ejercito1));
        System.out.println("\nPromedio de vida de los soldados: " + promedioVidaSoldados(ejercito2));
        
        // Mostrar detalles de cada soldado en los ejércitos
        mostrarSoldados(ejercito1);
        mostrarSoldados(ejercito2);

        // Ordenamiento y visualización del ranking de soldados por vida para cada ejército
        rankingPorVidaSoldados1(ejercito1);
        rankingPorVidaSoldados2(ejercito2);
        
        // Determinar y mostrar el ejército ganador
        decidirEjercitoGanador(ejercito1, ejercito2);
    }

    // Genera espacios vacíos (nulos) en el tablero de tamaño tamanoTablero x tamanoTablero
    public static void generarEspaciosArrayList(ArrayList<ArrayList<Soldado>> tablero) {
        for(int i=0; i<tamanoTablero; i++) {
        	ArrayList<Soldado> arr = new ArrayList<Soldado>();
            tablero.add(arr); // Añade una nueva fila al tablero
            
            for(int j=0; j<tamanoTablero; j++) 
                tablero.get(i).add(null); // Añade un espacio vacío (null) en cada posición
        }
    }

    // Llenar los atributos de los soldados en la lista especificada
    public static void llenarAtributosSoldados(ArrayList<Soldado> soldados, int cantSolds) {
        for (int i = 0; i < cantSolds; i++) {
            boolean posicionOcupada = true;

            // Creación de un nuevo soldado con vida y posición
            Soldado soldado = new Soldado();
            soldado.generarVida();

            // Genera una posición única para el soldado actual evitando duplicados
            while (posicionOcupada) {
                soldado.generarFila(tamanoTablero);
                soldado.generarColumna(tamanoTablero);
                posicionOcupada = soldado.comprobarPosicion(soldados, i);
            }
            soldados.add(soldado); // Añade el soldado a la lista de soldados
        }
    }

    // Coloca los soldados en el tablero en base a sus posiciones asignadas
    public static void llenarTablero(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> ejercito) {
        for (Soldado s : ejercito) {
            int fila = s.getFila() - Soldado.VALOR_MOBIBLE; // Ajusta la fila para usar como índice
            int columna = s.getColumna() - Soldado.VALOR_MOBIBLE; // Ajusta la columna para usar como índice
            tablero.get(fila).set(columna, s); // Coloca el soldado en la posición correspondiente
        }
    }

    // Imprime el tablero con la ubicación de los soldados
    public static void imprimirTablero(ArrayList<ArrayList<Soldado>> tablero) {
        imprimirLetrasColumnas(); // Imprime las letras de las columnas (A-J)

        String separador = "|   ", separador1 = "|_______", separador2 = "|";
        System.out.println("\n\t" + " _______________________________________________________________________________");

        // Recorre el tablero fila por fila para imprimir cada soldado o espacio vacío
        for (int i = 0; i < tablero.size(); i++) {
            System.out.print(i + 1 + "\t"); // Imprime el número de fila

            for (int j = 0; j < tablero.get(i).size(); j++) {
                System.out.print(separador);
                esSoldado(tablero.get(i).get(j)); // Verifica si hay un soldado en esa posición
            }
            System.out.println(separador2); // Fin de la fila

            // Imprime la separación entre filas
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

    // Comprueba si hay un soldado en la posición dada e imprime "x" o "°" según el ejército
    public static void esSoldado(Soldado soldado) {
        if (soldado == null) {
            System.out.print("    "); // Imprime espacio si no hay soldado
        }
        else {
        	String nombre = soldado.getNombre();
        	if(nombre.substring(nombre.length()-1).equals("1"))
        		System.out.print("x   "); // "x" para soldados del ejército 1
        	else
        		System.out.print("°   "); // "°" para soldados del ejército 2
        }
    }

    // Muestra el soldado con la mayor cantidad de vida en el ejército dado
    public static void mostrarSoldadoMayorVida(ArrayList<Soldado> ejercito) {
    	 Soldado soldadoMasVida = ejercito.get(0);
    	 
        for(int i = 1; i < ejercito.size()-1; i++) {
        	Soldado soldado = ejercito.get(i);
        	if(soldadoMasVida.getVida() < soldado.getVida()) {
        		soldadoMasVida = soldado;
        	}
        }
        System.out.println("\nSoldado con más vida: " + soldadoMasVida); // Muestra el soldado con mayor vida
    }

    // Calcula el promedio de vida de los soldados en el ejército especificado
    public static double promedioVidaSoldados(ArrayList<Soldado> ejercito) {
        int promedio = 0;

        // Suma la vida de todos los soldados
        for (Soldado s : ejercito)
            promedio += s.getVida();

        return (double) promedio / ejercito.size(); // Calcula y retorna el promedio
    }

    // Imprime los datos de todos los soldados en el ejército especificado
    public static void mostrarSoldados(ArrayList<Soldado> ejercito) {
    	System.out.println();
        for (Soldado s : ejercito)
            System.out.println(s);
    }

    // Ordena y muestra soldados por vida usando método burbuja
    public static void rankingPorVidaSoldados1(ArrayList<Soldado> ejercito) {
        ordenamientoBurbuja(ejercito);
        mostrarSoldados(ejercito);
    }
    
    // Ordenamiento burbuja para ordenar soldados por vida (mayor a menor)
    public static void ordenamientoBurbuja(ArrayList<Soldado> ejercito) {
        for (int i = 1; i < ejercito.size(); i++) {
            for (int j = 0; j < ejercito.size() - i; j++) {
            	Soldado soldado1 = ejercito.get(j);
            	Soldado soldado2 = ejercito.get(j+1);
            		
                if (soldado1.getVida() < soldado2.getVida()) {
                    ejercito.set(j, soldado2);
                    ejercito.set(j + 1, soldado1); // Intercambia soldados para ordenar por vida descendente
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

    // Decide el ejército ganador comparando el promedio de vida de ambos ejércitos
    public static void decidirEjercitoGanador(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
        // Calcula los promedios de vida para ambos ejércitos
        double promedio1 = promedioVidaSoldados(ejercito1);
        double promedio2 = promedioVidaSoldados(ejercito2);

        // Compara promedios para determinar el ganador
        if(promedio1 > promedio2) {
            System.out.println("\nEl Ejército 1 gana con un promedio de vida de " + promedio1);
        } 
        else if(promedio2 > promedio1) {
            System.out.println("\nEl Ejército 2 gana con un promedio de vida de " + promedio2);
        } 
        else {
            System.out.println("\nEmpate entre ambos ejércitos con un promedio de vida de " + promedio1);
        }
    }
}

    
