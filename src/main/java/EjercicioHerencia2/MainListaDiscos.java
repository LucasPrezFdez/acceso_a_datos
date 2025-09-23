package EjercicioHerencia2;

public class MainListaDiscos {
    public static void main(String[] args) {
        ListaMultimedia lista = new ListaMultimedia(20);

        Disco d1 = new Disco("The Wall", "Pink Floyd", Formato.CD, 81.0, Genero.ROCK);
        Disco d2 = new Disco("Thriller", "Michael Jackson", Formato.MP3, 42.19, Genero.POP);
        Disco d3 = new Disco("La Traviata", "Verdi", Formato.DVD, 120.0, Genero.OPERA);

        lista.add(d1);
        lista.add(d2);
        lista.add(d3);

        System.out.println("Lista de discos:");
        System.out.println(lista);

        String titulo = lista.get(1).getTitulo();
        String autor = lista.get(1).getAutor();
        Disco discoCopia = new Disco(titulo, autor, null, 0, null);
        System.out.println("\nDisco creado con datos de la lista (resto no significativo):");
        System.out.println(discoCopia);
    }
}

