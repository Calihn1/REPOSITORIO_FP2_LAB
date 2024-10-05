package Laboratorio3;

import java.util.*;
public class ejercicio2 {
    public static void main(String[] args) {
        Soldados[] soldados= new Soldados[5];
        rellenarLista(soldados);
        imprimirLista(soldados);
    }
    public static void rellenarLista(Soldados[] lista) {
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<lista.length; i++) {
            lista[i]=new Soldados();
            System.out.print("Ingrese su nombre: ");
            lista[i].setNombre(sc.next());
            System.out.print("Ingrese el nivel de vida: ");
            lista[i].setVida(sc.nextInt());
        }
    }
    public static void imprimirLista(Soldados[] lista) {
        for(Soldados n: lista)
        System.out.println(n);
    }
}
