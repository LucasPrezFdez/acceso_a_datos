package modelo;

public class Canal {

    public static final int MAX_USUARIOS = 100;
    public static final int MAX_MENSAJES = 1000;
    public static final String NOMBRE = "General";

    private Canal() {
        throw new UnsupportedOperationException("No se puede instanciar la clase Canal.");
    }

    public static String prefijo() {
        return "[" + NOMBRE + "]";
    }
}
