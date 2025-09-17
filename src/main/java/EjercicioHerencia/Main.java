package EjercicioHerencia;

public class Main {

    public static void main(String[] args) {
        // Crear un objeto de cada tipo y mostrar sus datos
        Producto producto = new Producto(20250101, 1001);
        ProductosFrescos fresco = new ProductosFrescos(20250102, 1002, 20240901, "España");
        ProductosRefrigerados refrigerado = new ProductosRefrigerados(20250103, 1003, 555);
        ProductosConjelados congelado = new ProductosConjelados(20250104, 1004, -18);
        ConjeladoPorAire aire = new ConjeladoPorAire(20250105, 1005, -20, 78.0, 21.0, 0.03, 0.97);
        ConjeladosPorAgua agua = new ConjeladosPorAgua(20250106, 1006, -22, 3.5);
        ConjeladosPorNitrogeno nitrogeno = new ConjeladosPorNitrogeno(20250107, 1007, -25, "Rápida", 2.5);

        System.out.println(producto);
        System.out.println(fresco);
        System.out.println(refrigerado);
        System.out.println(congelado);
        System.out.println(aire);
        System.out.println(agua);
        System.out.println(nitrogeno);
    }
}
