package Actividades;

public class Circulo {
    private double radio;
    private String color;

    public Circulo(double radio, String color) {
        this.radio = radio;
        this.color = color;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double calcularCircunferencia() {
        return 2 * Math.PI * radio;
    }

    public void mostrarDetalles() {
        System.out.println("Círculo de color " + color + " con radio " + radio);
        System.out.println("Área: " + calcularArea());
        System.out.println("Circunferencia: " + calcularCircunferencia());
    }

    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(5, "Rojo");
        circulo1.mostrarDetalles();
    }
}
