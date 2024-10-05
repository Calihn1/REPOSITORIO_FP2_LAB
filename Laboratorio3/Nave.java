package Laboratorio3;

public class Nave {
    private String nombre, columna;
    private int fila, puntos;
    private boolean estado;
   
    // Metodos mutadores
    public void setNombre( String nom){
    nombre = nom;
    }
    public void setFila(int fil){
    fila = fil;
    }
    public void setColumna(String col){
    columna = col;
    }
    public void setEstado(boolean est){
    estado = est;
    }
    public void setPuntos(int punt){
    puntos = punt;
    }
    // Metodos accesores
    public String getNombre() {
    return nombre;
    }
    public int getFila() {
    return fila;
    }
    public String getColumna() {
    return columna;
    }
    public boolean getEstado() {
    return estado;
    }
    public int getPuntos() {
    return puntos;
    }
    public String toString() {
        return ("Nombre: "+getNombre()+"\nFila: "+getFila()+"\nColumna: "+getColumna()+"\nEstado: "+getEstado()+"\nPuntos: "+getPuntos() );
    }
}


