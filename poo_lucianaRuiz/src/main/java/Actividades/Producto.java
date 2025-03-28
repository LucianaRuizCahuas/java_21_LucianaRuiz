package Actividades;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void actualizarStock(int cantidad) {
        stock += cantidad;
        System.out.println("Nuevo stock de " + nombre + ": " + stock);
    }

    public void mostrarDetalles() {
        System.out.println("Producto: " + nombre + ", Precio: S/" + precio + ", Stock: " + stock);
    }

    public static void main(String[] args) {
        Producto producto1 = new Producto("Laptop", 1200.50, 10);
        producto1.mostrarDetalles();
        producto1.actualizarStock(5);
    }
}
