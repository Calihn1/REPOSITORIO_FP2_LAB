package Laboratorio3;

public class Soldados {
	private int vida;
    private String nombre;

    public void setNombre( String nombre_) {
        nombre=nombre_;
    }
    public void setVida( int vida_) {
        vida=vida_;
    }
    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }
    public String toString() {
        return ("Nombre: "+getNombre()+"\nVida: "+getVida()+"\n");
    }

}
