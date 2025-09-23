package EjercicioHerencia2;

public class ListaMultimedia {

    int contador = 0;
    Multimedia[] arrayMultimedia;

    public ListaMultimedia(int contador) {
        this.contador = contador;
        this.arrayMultimedia = new Multimedia[contador];
    }


    public int size() {
        return arrayMultimedia.length;
    }

    public boolean add(Multimedia m) {
        for (int i = 0; i < arrayMultimedia.length; i++) {
            if (arrayMultimedia[i] == null) {
                arrayMultimedia[i] = m;
                return true;
            }
        }
        return false;
    }

    public Multimedia get(int posicion) {
        if (posicion < 0 || posicion >= arrayMultimedia.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + posicion);
        }
        if (arrayMultimedia[posicion] != null){
            return arrayMultimedia[posicion];
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayMultimedia.length; i++) {
            if (arrayMultimedia[i] != null) {
                sb.append(arrayMultimedia[i].toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private boolean listaLlena() {
        for (int i = 0; i < arrayMultimedia.length; i++) {
            if (arrayMultimedia[i] == null) {
                return false;
            }
        }
        return true;
    }

}
