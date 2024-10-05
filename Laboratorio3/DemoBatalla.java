package Laboratorio3;

import java.util.*;
public class DemoBatalla {
    public static void main(String [] args) {
        Nave [] misNaves = new Nave[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;


        for (int i = 0; i < misNaves.length; i++) {
        System.out.println("Nave " + (i+1));
        System.out.print("Nombre: ");
        nomb = sc.next();
        System.out.print("Fila: ");
        fil = sc.nextInt();
        System.out.print("Columna: ");
        col = sc.next();
        System.out.print("Estado: ");
        est = sc.nextBoolean();
        System.out.print("Puntos: ");
        punt = sc.nextInt();


        misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves


        misNaves[i].setNombre(nomb);
        misNaves[i].setFila(fil);
        misNaves[i].setColumna(col);
        misNaves[i].setEstado(est);
        misNaves[i].setPuntos(punt);
        }


        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves, sc);
        mostrarPorPuntos(misNaves, sc);
        System.out.println("\nNave con mayor número de puntos:\n" + mostrarMayorPuntos(misNaves));
        System.out.println("\nLas naves desordenadas:\n");
        mostrarNaves(desordenarNaves(misNaves));
    }
    //Método para mostrar todas las naves
    public static void mostrarNaves(Nave [] flota) {
        for(Nave n: flota)
            System.out.println(n+"\n");
    }


    //Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave [] flota, Scanner sc) {
        System.out.print("Ingrese el nombre de la flota: ");
        String nomBuscado=sc.next();
        for(Nave n: flota)
            if(n.getNombre()==nomBuscado)
                System.out.println(n+"\n");
    }


    //Método para mostrar todas las naves con un número de puntos inferior o igual
    //al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave [] flota, Scanner sc) {
        System.out.print("Ingrese un numero de puntos: ");
        int cantPunt=sc.nextInt();
        for(Nave n: flota)
            if(n.getPuntos()<=cantPunt)
                System.out.println(n+"\n");
    }


    //Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave [] flota) {
        int pos=0;
        int mayorPunt=flota[pos].getPuntos();
        for(int i=1; i<flota.length; i++) {
            if(mayorPunt<flota[i].getPuntos()) {
                mayorPunt=flota[i].getPuntos();
                pos=i;
            }
        }
        return flota[pos];
    }
    //Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
    //pero aleatoriamente desordenados
    public static Nave[] desordenarNaves(Nave [] flota) {
        Nave [] flota1=new Nave[flota.length];
        System.arraycopy(flota, 0 , flota1, 0 , flota.length);
        for(int i=0; i<flota1.length; i++) {
            int posCambio1=(int)(Math.random()*flota1.length);
            int posCambio2=(int)(Math.random()*flota1.length);
            Nave nave=flota[posCambio2];
            flota[posCambio2]=flota[posCambio1];
            flota[posCambio1]=nave;
        }
        return flota1;
    }


}




