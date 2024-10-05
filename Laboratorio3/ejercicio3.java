package Laboratorio3;
/*Laboratorio Nr3 - Ejercicio3
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: 6 min
*/
public class ejercicio3 {
    public static void main(String[] args) {
        // Se crean dos ejércitos con un número aleatorio de soldados
        Ejercito ejercito1 = new Ejercito((int)((Math.random() * 5) + 1));
        Ejercito ejercito2 = new Ejercito((int)((Math.random() * 5) + 1));

        // Se asignan nombres y completan las listas de soldados
        ejercito1.setNombreEjercito();
        ejercito2.setNombreEjercito();

        ejercito1.completarEjercito();
        ejercito2.completarEjercito();

        // Se muestran los soldados de cada ejército
        ejercito1.mostrarSodados();
        ejercito2.mostrarSodados();

        // Se determina el ejército ganador
        mostrarEjercitoGanador(ejercito1, ejercito2);
    }

    // Método que muestra el ejército con más soldados
    public static void mostrarEjercitoGanador(Ejercito ejercito1, Ejercito ejercito2) {
        System.out.println("\nEl ejército ganador es:");
        if(ejercito1.cantidadSoldados() > ejercito2.cantidadSoldados()) 
            ejercito1.mostrarSodados();
        else if(ejercito1.cantidadSoldados() < ejercito2.cantidadSoldados())
            ejercito2.mostrarSodados();
        else
            System.out.println("Es un empate");
    }
}

