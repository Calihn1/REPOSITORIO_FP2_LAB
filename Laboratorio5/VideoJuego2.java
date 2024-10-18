package Laboratorio5;
/*Laboratorio Nr5 - Ejercicio1
 *Autor: Hilacondo Begazo,Emanuel David
 *Colaboró: con nadie
 *Tiempo: --
*/

public class VideoJuego2 {
	
	static final int tamanoTablero = 10;
	
    public static void main(String[] args) {
        Soldado[][] tablero= new Soldado[tamanoTablero][tamanoTablero];

        int cantSoldado = (int)(Math.random() * tamanoTablero + 1);
        Soldado[] soldados = new Soldado[cantSoldado];

        llenarAtributosSoldados(soldados);
        llenarTablero(tablero, soldados);
        imprimirTablero(tablero);
        
        Soldado[] nuevaListaSoldados = new Soldado[soldados.length];
        System.arraycopy(soldados, 0, nuevaListaSoldados, 0, soldados.length);
     
        mostrarSoldadoMayorVida(nuevaListaSoldados);
        System.out.println("\nPromedio de vida de los soldados : "+ promedioVidaSoldados(soldados) );
        mostrarVidaSoldados(nuevaListaSoldados);
        mostrarSoldados( soldados );
        
        Soldado[] nuevaListaSoldados1 = new Soldado[soldados.length];
        System.arraycopy(soldados, 0, nuevaListaSoldados1, 0, soldados.length);
        
        rankingPorVidaSoldados( nuevaListaSoldados1 );
    }

    public static void llenarAtributosSoldados(Soldado[] soldados) {
        for(int i = 0; i <soldados.length; i++ ) {
        	boolean posicionOcupada = true;
    
            soldados[i] = new Soldado();
            soldados[i].generarVida();
            
            while(posicionOcupada) {
            	soldados[i].generarFila(tamanoTablero);
                soldados[i].generarColumna(tamanoTablero);
                posicionOcupada = soldados[i].comprobarPosicion(soldados, i);
            }
        }
    }

    public static void llenarTablero(Soldado[][] tablero, Soldado[] solds) {
    	for(Soldado s : solds) {
            int fila = s.getFila() - 1;
            int columna =s.getColumna() - 1;
	        tablero[fila][columna] = s; 
        }
    }

    public static void imprimirTablero(Soldado[][] tablero) {
    	imprimirLetrasColumnas();
    	
        String separador = "|   ", separador1 = "|_______", separador2 = "|";
        System.out.println("\n\t" + " _______________________________________________________________________________");
        
        for(int i = 0; i < tablero.length; i++) {
        	System.out.print(i + 1 +"\t");
        	
            for(int j = 0; j < tablero[i].length; j++) {
                System.out.print(separador);
                esSoldado(tablero[i][j]);	           
            }
            System.out.println(separador2);
            
            System.out.print("\t");
            for(int j = 0; j < tablero[i].length; j++)
            	System.out.print(separador1);
            
            System.out.println(separador2);
        }
    }
    
    public static void imprimirLetrasColumnas() {
    	System.out.print("     ");
    	for( char i = 'A'; i < 'K'; i++)
    		System.out.print("       " + i );
    }
    
    public static void esSoldado(Soldado soldado) {
            if( soldado != null )
                System.out.print("x   ");
            else
                System.out.print("    ");            
    }
    
    public static void mostrarSoldadoMayorVida( Soldado[] NuevosSolds) {
    	ordenamientoBurbuja(NuevosSolds);
    	System.out.println( "\nSoldado con mas vida: " + NuevosSolds[0]);
    }
    
    public static void ordenamientoBurbuja(Soldado[] NuevosSolds) {
    	for(int i = 1; i < NuevosSolds.length; i++) {
    		for(int j = 0; j < NuevosSolds.length - i; j++) {
    			
    			if( NuevosSolds[j].getVida() < NuevosSolds[j + 1].getVida() )
    				intercambiarPosiciones( NuevosSolds, j, j + 1 );
    		}
    	}
    }
    
    public static void intercambiarPosiciones( Soldado[] s, int menor , int mayor ) {
    	Soldado temporal = s[menor];
    	s[menor] = s[mayor];
    	s[mayor] = temporal;
    }
    
    public static double promedioVidaSoldados( Soldado[] solds ) {
    	int promedio = 0;
    	
    	for( Soldado s : solds ) 
    		promedio += s.getVida();
    	
    	return (double) promedio/solds.length;
    }
    
    public static void mostrarVidaSoldados( Soldado[] NuevoSolds ) {
    	for(Soldado s : NuevoSolds ) 
    		System.out.print("\nNombre: "+ s.getNombre() + "\tNivel de vida: " + s.getVida() );
    }
    
    public static void mostrarSoldados( Soldado[] solds ) {
    	System.out.println();
    	for( Soldado s : solds )
    		System.out.print(s);
    }
    
    public static void rankingPorVidaSoldados( Soldado[] NuevoSolds1 ) {
    	ordenamientoInsercion( NuevoSolds1 );
    	mostrarSoldados( NuevoSolds1 );
    }
    
    public static void ordenamientoInsercion( Soldado[] s ) {
    	for(int i = 1; i < s.length; i++) {
			for(int j = i; j >= 1; j--) {
				if( s[j-1].getVida() < s[j].getVida() ) 
					intercambiarPosiciones( s, j, j - 1 );
			}
    	}
    }
}


