package EjercicioHerencia2;

public class MainListaMultimedia {
    public static void main(String[] args) {

        ListaMultimedia lista = new ListaMultimedia(10);

        Pelicula p1 = new Pelicula("El Padrino", "Francis Ford Coppola", Formato.DVD, 175, "Marlon Brando", null);
        Pelicula p2 = new Pelicula("Titanic", "James Cameron", Formato.DVD, 195, null, "Kate Winslet");
        Pelicula p3 = new Pelicula("Sr. y Sra. Smith", "Doug Liman", Formato.AVI, 120, "Brad Pitt", "Angelina Jolie");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        System.out.println(lista);
    }
}

