package Laboratorio3;
/*Laboratorio Nr3 - Ejercicio3
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: 9 min
*/
import java.util.*;

public class Ejercito {
    private String[] ejercito;
    private String nombreEjercito;

    // Constructor que inicializa el ejército con un número determinado de soldados
    Ejercito(int soldados) {
        ejercito = new String[soldados];
    }

    // Método para llenar el ejército con soldados numerados
    public void completarEjercito() {
        for(int i = 0; i < ejercito.length; i++) 
            ejercito[i] = "soldado" + i;        
    }

    // Método que devuelve la cantidad de soldados en el ejército
    public int cantidadSoldados() {
        return ejercito.length;
    }

    // Método para asignar un nombre al ejército
    public void setNombreEjercito() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dele un nombre al ejército: ");
        nombreEjercito = sc.nextLine();
    }

    // Método para obtener el nombre del ejército
    public String getNombreEjercito() {
        return nombreEjercito;
    }

    // Método para mostrar los soldados del ejército
    public void mostrarSodados() {
        System.out.println("\n" + getNombreEjercito());
        for(String n : ejercito) {
            System.out.print(n + "\n");
        }
    }
}

