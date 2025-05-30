/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tipodatos.supermercado;

/**
 *
 * @author 57321
 */
import java.util.Arrays;
import java.util.List;
public class Supermercado {

    public static void main(String[] args) {
        // Lista de productos
        List<Producto> productos1 = Arrays.asList(
                new Producto("Arroz", 3500, 1000),
                new Producto("Leche", 2500, 1500),
                new Producto("Pan", 2000, 800),
                new Producto("panela", 5000, 1200)
        );

        List<Producto> productos2 = Arrays.asList(
                new Producto("Huevos", 4800, 1200),
                new Producto("Aceite", 8900, 2000),
                new Producto("Carne", 7800, 2000)
        );
         List<Producto> productos3 = Arrays.asList(
                new Producto("Huevos", 4800, 1200),
                new Producto("Aceite", 8900, 2000),
                new Producto("Carne", 7800, 2000)
        );

        Cliente cliente1 = new Cliente("Juan", productos1);
        Cliente cliente2 = new Cliente("Ana", productos2);
        Cliente cliente3 = new Cliente("Esteban",productos3);

        // Crear hilos (cajeras)
        Cajera cajera1 = new Cajera("Cajera 1", cliente1);
        Cajera cajera2 = new Cajera("Cajera 2", cliente2);
        Cajera cajera3= new Cajera("cajera 3",cliente3);

        // Medición de tiempo global
        long inicioGlobal = System.currentTimeMillis();

        cajera1.start();
        cajera2.start();
        cajera3.start();

        try {
            cajera1.join();
            cajera2.join();
            cajera3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finGlobal = System.currentTimeMillis();
        System.out.println(" Tiempo total global: " + (finGlobal - inicioGlobal) + "ms");
    }
}
