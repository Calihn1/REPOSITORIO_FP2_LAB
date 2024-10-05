package Laboratorio3;

public class ejercicio3 {
	 public static void main(String[] args){
	        Ejercito ejercito1=new Ejercito( (int)((Math.random()*5)+1) );
	        Ejercito ejercito2=new Ejercito( (int)((Math.random()*5)+1) );
	        ejercito1.setNombreEjercito();
	        ejercito2.setNombreEjercito();
	        
	        ejercito1.completarEjercito();
	        ejercito2.completarEjercito();
	        
	        ejercito1.mostrarSodados();
	        ejercito2.mostrarSodados();
	        
	        mostrarEjercitoGanador(ejercito1,ejercito2);
	 }
	 public static void mostrarEjercitoGanador(Ejercito ejercito1, Ejercito ejercito2) {
		 	System.out.println("\nEl ejercitro ganador es:");
	        if(ejercito1.cantidadSoldados()>ejercito2.cantidadSoldados()) 
	        	ejercito1.mostrarSodados();
	        
	        else if(ejercito1.cantidadSoldados()<ejercito2.cantidadSoldados())
	        	ejercito2.mostrarSodados();
	        
	        else
	            System.out.println("Es un empate");
	    }
}
