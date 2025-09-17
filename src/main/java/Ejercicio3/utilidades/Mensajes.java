package utilidades;

import modelo.Usuario;

public class Mensajes {

    public static final String SALUDO = "HOLA";

    public static String mostrarSaludo(Usuario u) {
        return SALUDO + " " + u.getNombre();
    }

    public static final String formatearMensaje(String mensaje) {
        return "[ " + mensaje + " ]";
    }

}
