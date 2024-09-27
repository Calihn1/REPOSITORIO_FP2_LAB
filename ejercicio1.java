package Laboratorio2;
/*Laboratorio Nr2 - Ejercicio1
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: --
*/
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
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

        String[] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};
        int contador = 1;
        char letra;
        String[] palabras = {"programacion", "java", "indentacion", "clases",
                             "objetos", "desarrollador", "pruebas"};
        String palSecreta = getPalabraSecreta(palabras);
        System.out.println(figuras[0]);
        char[] palabCorrecta= new char[palSecreta.length()];
        mostrarBlancos(palabCorrecta);
        System.out.println("\n");
        // COMENZAR JUEGO
        while (contador <= 6) {
            letra = ingreseLetra();
            if (letraEnPalabraSecreta(letra, palSecreta))
                mostrarBlancosActualizados(letra,palSecreta,palabCorrecta);
            else {
                System.out.println(figuras[contador]);
                contador++;
            }
            // Aquí puedes agregar la lógica para comprobar si ganó o perdió
           if(determinarSiGano(palabCorrecta, palSecreta)) {
        	   System.out.println("GANO, FELICIDADES!!!");
        	   break;
           }
        }
        if(contador==7)
        	System.out.println("Lo lamento, usted perdio");
    }
    
    public static String getPalabraSecreta(String[] lasPalabras) {
        int ind;
        int indiceMayor = lasPalabras.length - 1;
        int indiceMenor = 0;
        ind = (int) (Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor);
        return lasPalabras[ind];
    }
    public static void mostrarBlancos(char[] palabCorrecta) {
    	for(int i=0; i<palabCorrecta.length; i++) {
        	palabCorrecta[i]='_';
        	System.out.print(palabCorrecta[i]+" ");
        }
    }
    
    public static char ingreseLetra() {
        char laLetra='n';
        boolean confirmacion=true;
        Scanner sc = new Scanner(System.in);
        while(confirmacion) {
            System.out.print("\nIngrese letra: ");
            laLetra = sc.next().toLowerCase().charAt(0);
            for(char i='a'; i<='z'; i++) {
                if(laLetra==i)
                    confirmacion=false;
            }
        }
        return laLetra;
    }
    
    public static boolean letraEnPalabraSecreta(char letra, String palSecreta) {
        for(int i=0; i<palSecreta.length(); i++) {
             if(letra==palSecreta.charAt(i))      
                    return true;
        }
        return false;
    }
    
    public static void mostrarBlancosActualizados(char letra, String palabra,char[] palabCorrecta) {
        for(int j=0; j<palabCorrecta.length; j++) {
        	if(letra==palabra.charAt(j) && palabCorrecta[j]=='_')
        		palabCorrecta[j]=letra;
        	System.out.print(palabCorrecta[j]+" ");
        }
	}
    
    public static boolean determinarSiGano(char[] palabCorrecta, String palabra) {
    	String palabElegida="";
    	for( char n: palabCorrecta)
    		palabElegida=palabElegida+n;
    	return(palabElegida==palabra);
    }
}






