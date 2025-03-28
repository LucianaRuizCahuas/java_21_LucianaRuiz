package Actividades;

public class Computadora {
    private String marca;
    private int ram;
    private boolean encendida;

    public Computadora(String marca, int ram) {
        this.marca = marca;
        this.ram = ram;
        this.encendida = false; // La computadora inicia apagada
    }

    public void encender() {
        if (!encendida) {
            encendida = true;
            System.out.println("La computadora " + marca + " se ha encendido.");
        } else {
            System.out.println("La computadora ya está encendida.");
        }
    }

    public void apagar() {
        if (encendida) {
            encendida = false;
            System.out.println("La computadora " + marca + " se ha apagado.");
        } else {
            System.out.println("La computadora ya está apagada.");
        }
    }

    public void mostrarDetalles() {
        System.out.println("Computadora: " + marca);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Estado: " + (encendida ? "Encendida" : "Apagada"));
    }

    public static void main(String[] args) {
        Computadora pc1 = new Computadora("Dell", 16);
        pc1.mostrarDetalles(); // Muestra la info inicial
        pc1.encender();  // Enciende la computadora
        pc1.apagar();  // Apaga la computadora
    }
}
