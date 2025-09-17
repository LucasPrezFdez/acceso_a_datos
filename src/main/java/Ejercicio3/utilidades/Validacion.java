package utilidades;

public final class Validacion {

    public static boolean esEmailValido(String email) {
        return email.contains("@");
    }

    public static boolean noVacio(String email) {
        return email != null && !email.isEmpty();
    }

}
