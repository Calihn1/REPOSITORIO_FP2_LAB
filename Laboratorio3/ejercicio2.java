package Laboratorio3;
/*Laboratorio Nr3 - Ejercicio2
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: 7 min
*/
import java.util.*;

public class ejercicio2 {
    public static void main(String[] args) {
        // Se crea un arreglo de 5 soldados
        Soldados[] soldados = new Soldados[5];
        rellenarLista(soldados);  // Llenar el arreglo con datos
        imprimirLista(soldados);  // Imprimir la lista de soldados
    }

    // Método para rellenar la lista de soldados con sus datos
    public static void rellenarLista(Soldados[] lista) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < lista.length; i++) {
            lista[i] = new Soldados();
            System.out.print("Ingrese su nombre: ");
            lista[i].setNombre(sc.next());
            System.out.print("Ingrese el nivel de vida: ");
            lista[i].setVida(sc.nextInt());
        }
    }

    // Método para imprimir la lista de soldados
    public static void imprimirLista(Soldados[] lista) {
        for(Soldados n : lista)
            System.out.println(n);
    }
}
