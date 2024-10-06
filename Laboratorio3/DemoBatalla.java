package Laboratorio3;
/*Laboratorio Nr3 - Ejercicio1
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: --
*/
import java.util.*;

public class DemoBatalla {
    public static void main(String [] args) {
        // Se crea un arreglo de objetos Nave con capacidad para 10 naves
        Nave [] misNaves = new Nave[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        // Ciclo para solicitar los datos de cada nave al usuario
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i+1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado (true = operativa, false = dañada): ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            // Se crea una nueva nave y se asignan los valores proporcionados
            misNaves[i] = new Nave();
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        // Muestra las naves creadas
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);

        // Muestra las naves filtradas por nombre y puntos
        mostrarPorNombre(misNaves, sc);
        mostrarPorPuntos(misNaves, sc);

        // Muestra la nave con mayor número de puntos
        System.out.println("\nNave con mayor número de puntos:\n" + mostrarMayorPuntos(misNaves));

        // Muestra las naves en orden aleatorio
        System.out.println("\nLas naves desordenadas:\n");
        mostrarNaves(desordenarNaves(misNaves));
    }

    // Método para mostrar todas las naves en la flota
    public static void mostrarNaves(Nave [] flota) {
        for(Nave n: flota)
            System.out.println(n + "\n");
    }

    // Método para mostrar naves por nombre
    public static void mostrarPorNombre(Nave [] flota, Scanner sc) {
        System.out.print("Ingrese el nombre de la flota: ");
        String nomBuscado = sc.next();
        for(Nave n: flota)
            if(n.getNombre().equals(nomBuscado))  // Compara el nombre de cada nave
                System.out.println(n + "\n");
    }

    // Método para mostrar naves con puntos menores o iguales a los indicados
    public static void mostrarPorPuntos(Nave [] flota, Scanner sc) {
        System.out.print("Ingrese un número de puntos: ");
        int cantPunt = sc.nextInt();
        for(Nave n: flota)
            if(n.getPuntos() <= cantPunt)
                System.out.println(n + "\n");
    }

    // Método que devuelve la nave con mayor número de puntos
    public static Nave mostrarMayorPuntos(Nave [] flota) {
        int pos = 0;
        int mayorPunt = flota[pos].getPuntos();
        for(int i = 1; i < flota.length; i++) {
            if(mayorPunt < flota[i].getPuntos()) {
                mayorPunt = flota[i].getPuntos();
                pos = i;
            }
        }
        return flota[pos];
    }

    // Método que desordena aleatoriamente las naves en la flota
    public static Nave[] desordenarNaves(Nave [] flota) {
        Nave [] flota1 = new Nave[flota.length];
        System.arraycopy(flota, 0 , flota1, 0 , flota.length);
        for(int i = 0; i < flota1.length; i++) {
            int posCambio1 = (int)(Math.random() * flota1.length);
            int posCambio2 = (int)(Math.random() * flota1.length);
            Nave nave = flota1[posCambio2];
            flota1[posCambio2] = flota1[posCambio1];
            flota1[posCambio1] = nave;
        }
        return flota1;
    }
}




