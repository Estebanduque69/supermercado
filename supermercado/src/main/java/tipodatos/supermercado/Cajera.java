/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipodatos.supermercado;

/**
 *
 * @author 57321
 */
public class Cajera extends Thread {
    private String nombre;
    private Cliente cliente;

    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println(nombre + " comienza a atender a " + cliente.getNombre());
        long inicio = System.currentTimeMillis();
        double total = 0;

        for (Producto producto : cliente.getProductos()) {
            try {
                Thread.sleep(producto.getTiempoProcesamiento());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            total += producto.getPrecio();
            System.out.println(nombre + " procesó " + producto.getNombre() +
                               " - $" + producto.getPrecio() +
                               " en " + producto.getTiempoProcesamiento() + "ms");
        }

        long fin = System.currentTimeMillis();
        System.out.println(nombre + " terminó con " + cliente.getNombre() +
                           ". Total: $" + total +
                           " | Tiempo total: " + (fin - inicio) + "ms\n");
    }
}

