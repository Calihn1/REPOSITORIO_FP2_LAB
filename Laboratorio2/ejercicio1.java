package Laboratorio2;
/*Laboratorio Nr2 - Ejercicio1
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: --
*/
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        // Representaciones gráficas del ahorcado para cada etapa del juego.
        String ahor1 = " +---+ \n" +
                       " |   | \n" +
                       "     | \n" +
                       "     | \n" +
                       "     | \n" +
                       "     | \n" +
                       "=========";
        String ahor2 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "     | \n" +
                       "     | \n" +
                       "     | \n" +
                       "=========";
        String ahor3 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       " |   | \n" +
                       "     | \n" +
                       "     | \n" +
                       "=========";
        String ahor4 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "/|   | \n" +
                       "     | \n" +
                       "     | \n" +
                       "=========";
        String ahor5 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "/|\\  | \n" +
                       "     | \n" +
                       "     | \n" +
                       "=========";
        String ahor6 = " +---+ \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "/|\\  | \n" +
                       "/    | \n" +
                       "     | \n" +
                       "=========";
        String ahor7 = " +---+  \n" +
                       " |   | \n" +
                       " O   | \n" +
                       "/|\\  | \n" +
                       "/ \\  | \n" +
                       "     | \n" +
                       "=========";

        // Arreglo que contiene todas las etapas del ahorcado.
        String[] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};
        int contador = 1; // Contador para fallos.
        char letra; // Variable para almacenar la letra ingresada por el usuario.
        String[] palabras = {"programacion", "java", "indentacion", "clases",
                             "objetos", "desarrollador", "pruebas"};
        
        // Se elige una palabra secreta de forma aleatoria.
        String palSecreta = getPalabraSecreta(palabras);
        
        // Se muestra la primera figura del ahorcado y las líneas en blanco.
        System.out.println(figuras[0]);
        char[] palabCorrecta = new char[palSecreta.length()];
        
        // Inicializa y muestra los espacios en blanco correspondientes a la palabra secreta.
        mostrarBlancos(palabCorrecta);
        System.out.println("\n");
        
        // COMIENZA EL JUEGO
        while (contador <= 6) {
            letra = ingreseLetra(); // Solicita al usuario una letra.
            
            // Si la letra está en la palabra secreta, se actualizan los espacios en blanco.
            if (letraEnPalabraSecreta(letra, palSecreta))
                mostrarBlancosActualizados(letra, palSecreta, palabCorrecta);
            else {
                // Si la letra no está en la palabra secreta, se muestra la siguiente etapa del ahorcado.
                System.out.println(figuras[contador]);
                contador++; // Aumenta el contador de fallos.
            }
            
            // Verifica si el jugador ha ganado.
            if (determinarSiGano(palabCorrecta, palSecreta)) {
                System.out.println("¡GANASTE, FELICIDADES!");
                break;
            }
        }
        // Si el contador llega a 7, significa que el jugador ha perdido.
        if (contador == 7)
            System.out.println("Lo lamento, usted perdió.");
    }
    
    // Selecciona una palabra aleatoria del arreglo.
    public static String getPalabraSecreta(String[] lasPalabras) {
        int indiceMayor = lasPalabras.length - 1;
        int indiceMenor = 0;
        int ind = (int) (Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor);
        return lasPalabras[ind];
    }
    
    // Muestra los espacios en blanco para la palabra secreta.
    public static void mostrarBlancos(char[] palabCorrecta) {
        for (int i = 0; i < palabCorrecta.length; i++) {
            palabCorrecta[i] = '_';
            System.out.print(palabCorrecta[i] + " ");
        }
    }
    
    // Solicita al usuario ingresar una letra y la valida.
    public static char ingreseLetra() {
        char laLetra = 'n'; 
        boolean confirmacion = true; 
        Scanner sc = new Scanner(System.in); 
        while (confirmacion) {
            System.out.print("\nIngrese letra: ");
            laLetra = sc.next().toLowerCase().charAt(0);
            for (char i = 'a'; i <= 'z'; i++) {
                if (laLetra == i)
                    confirmacion = false; 
            }
        }
        return laLetra;
    }
    
    // Verifica si una letra está en la palabra secreta.
    public static boolean letraEnPalabraSecreta(char letra, String palSecreta) {
        for (int i = 0; i < palSecreta.length(); i++) {
            if (letra == palSecreta.charAt(i))
                return true; 
        }
        return false;
    }
    
    // Actualiza y muestra el estado actual de la palabra secreta con las letras acertadas.
    public static void mostrarBlancosActualizados(char letra, String palabra, char[] palabCorrecta) {
        for (int j = 0; j < palabCorrecta.length; j++) {
            if (letra == palabra.charAt(j) && palabCorrecta[j] == '_')
                palabCorrecta[j] = letra; 
            System.out.print(palabCorrecta[j] + " ");
        }
    }
    
    // Determina si el jugador ha ganado comparando la palabra formada con la secreta.
    public static boolean determinarSiGano(char[] palabCorrecta, String palabra) {
        String palabElegida = "";
        for (char n : palabCorrecta)
            palabElegida = palabElegida + n; 
        return (palabElegida.equals(palabra)); 
    }
}






