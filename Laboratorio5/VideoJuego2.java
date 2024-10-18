


package Laboratorio5;
/* Laboratorio Nr5 - Ejercicio1
 * Autor: Hilacondo Begazo, Emanuel David
 * Colaboró: con nadie
 * Tiempo: --
 */

public class VideoJuego2 {

    static final int tamanoTablero = 10;

    public static void main(String[] args) {
        // Inicializamos el tablero de tamaño 10x10
        Soldado[][] tablero = new Soldado[tamanoTablero][tamanoTablero];

        // Se genera un número aleatorio de soldados (entre 1 y 10)
        int cantSoldado = (int)(Math.random() * tamanoTablero + 1);
        Soldado[] soldados = new Soldado[cantSoldado];

        // Llenamos los atributos de cada soldado y los colocamos en el tablero
        llenarAtributosSoldados(soldados);
        llenarTablero(tablero, soldados);
        imprimirTablero(tablero);

        // Creamos una nueva copia del arreglo de soldados
        Soldado[] nuevaListaSoldados = new Soldado[soldados.length];
        System.arraycopy(soldados, 0, nuevaListaSoldados, 0, soldados.length);

        // Mostramos el soldado con mayor vida
        mostrarSoldadoMayorVida(nuevaListaSoldados);
        // Calculamos y mostramos el promedio de vida de los soldados
        System.out.println("\nPromedio de vida de los soldados: " + promedioVidaSoldados(soldados));
        // Mostramos los nombres y vidas de todos los soldados
        mostrarVidaSoldados(nuevaListaSoldados);
        mostrarSoldados(soldados);

        // Creamos otra copia de los soldados para el ranking por vida
        Soldado[] nuevaListaSoldados1 = new Soldado[soldados.length];
        System.arraycopy(soldados, 0, nuevaListaSoldados1, 0, soldados.length);

        // Ordenamos y mostramos el ranking de los soldados por su vida
        rankingPorVidaSoldados(nuevaListaSoldados1);
    }

    // Método que llena los atributos de los soldados
    public static void llenarAtributosSoldados(Soldado[] soldados) {
        for (int i = 0; i < soldados.length; i++) {
            boolean posicionOcupada = true;

            soldados[i] = new Soldado();
            soldados[i].generarVida(); // Generamos vida para el soldado

            // Se asegura de que la posición generada no esté ocupada por otro soldado
            while (posicionOcupada) {
                soldados[i].generarFila(tamanoTablero); // Generamos la fila
                soldados[i].generarColumna(tamanoTablero); // Generamos la columna
                posicionOcupada = soldados[i].comprobarPosicion(soldados, i); // Comprobamos si la posición está ocupada
            }
        }
    }

    // Método que coloca los soldados en el tablero
    public static void llenarTablero(Soldado[][] tablero, Soldado[] solds) {
        for (Soldado s : solds) {
            int fila = s.getFila() - 1; // Convertimos la fila a índice
            int columna = s.getColumna() - 1; // Convertimos la columna a índice
            tablero[fila][columna] = s; // Colocamos el soldado en la posición correspondiente
        }
    }

    // Método que imprime el tablero con la ubicación de los soldados
    public static void imprimirTablero(Soldado[][] tablero) {
        imprimirLetrasColumnas(); // Imprimimos las letras de las columnas (A-J)

        String separador = "|   ", separador1 = "|_______", separador2 = "|";
        System.out.println("\n\t" + " _______________________________________________________________________________");

        // Recorremos el tablero fila por fila
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + 1 + "\t"); // Imprimimos el número de fila

            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(separador);
                esSoldado(tablero[i][j]); // Comprobamos si hay un soldado en esa posición
            }
            System.out.println(separador2); // Fin de la fila

            // Imprimimos la separación entre filas
            System.out.print("\t");
            for (int j = 0; j < tablero[i].length; j++) {
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
        if (soldado != null)
            System.out.print("x   ");
        else
            System.out.print("    ");
    }

    // Muestra el soldado con mayor vida después de ordenar por vida
    public static void mostrarSoldadoMayorVida(Soldado[] NuevosSolds) {
        ordenamientoBurbuja(NuevosSolds); // Ordenamos los soldados por vida
        System.out.println("\nSoldado con más vida: " + NuevosSolds[0]); // Mostramos el primero (máxima vida)
    }

    // Ordenamiento burbuja para ordenar soldados por vida (mayor a menor)
    public static void ordenamientoBurbuja(Soldado[] NuevosSolds) {
        for (int i = 1; i < NuevosSolds.length; i++) {
            for (int j = 0; j < NuevosSolds.length - i; j++) {
                if (NuevosSolds[j].getVida() < NuevosSolds[j + 1].getVida()) {
                    intercambiarPosiciones(NuevosSolds, j, j + 1); // Intercambiamos si el siguiente tiene más vida
                }
            }
        }
    }

    // Método auxiliar para intercambiar posiciones entre dos soldados
    public static void intercambiarPosiciones(Soldado[] s, int menor, int mayor) {
        Soldado temporal = s[menor];
        s[menor] = s[mayor];
        s[mayor] = temporal;
    }

    // Calcula el promedio de vida de todos los soldados
    public static double promedioVidaSoldados(Soldado[] solds) {
        int promedio = 0;

        // Sumamos la vida de todos los soldados
        for (Soldado s : solds)
            promedio += s.getVida();

        return (double) promedio / solds.length; // Dividimos por la cantidad de soldados
    }

    // Muestra los nombres y vidas de los soldados
    public static void mostrarVidaSoldados(Soldado[] NuevoSolds) {
        for (Soldado s : NuevoSolds)
            System.out.print("\nNombre: " + s.getNombre() + "\tNivel de vida: " + s.getVida());
    }

    // Muestra todos los soldados en el arreglo
    public static void mostrarSoldados(Soldado[] solds) {
        System.out.println();
        for (Soldado s : solds)
            System.out.print(s);
    }

    // Método que ordena los soldados por vida y muestra el ranking
    public static void rankingPorVidaSoldados(Soldado[] NuevoSolds1) {
        ordenamientoInsercion(NuevoSolds1); // Ordenamos por el método de inserción
        mostrarSoldados(NuevoSolds1); // Mostramos los soldados ya ordenados
    }

    // Ordenamiento por inserción para ordenar soldados por vida (mayor a menor)
    public static void ordenamientoInsercion(Soldado[] s) {
        for (int i = 1; i < s.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (s[j - 1].getVida() < s[j].getVida()) {
                    intercambiarPosiciones(s, j, j - 1); // Intercambiamos si el anterior tiene menos vida
                }
            }
        }
    }
}
