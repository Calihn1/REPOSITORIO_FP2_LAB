package Laboratorio3;
import java.util.*;

public class Ejercito {
	private String[] ejercito;
	private String nombreEjercito;
	
	Ejercito(int soldados) {
		ejercito=new String[soldados];
	}
	public void completarEjercito() {
		for(int i=0; i<ejercito.length; i++) 
			ejercito[i]="soldado"+i;		
	}
	public int cantidadSoldados() {
		return(ejercito.length);
	}
	public void setNombreEjercito() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dele un nombre al ejercito: ");
		nombreEjercito=sc.nextLine();
	}
	public String getNombreEjercito() {
		return nombreEjercito;
	}
	public void mostrarSodados() {
		System.out.println("\n"+getNombreEjercito());
		for( String n:ejercito) {
			System.out.print(n+"\n");
		}
	}
}
