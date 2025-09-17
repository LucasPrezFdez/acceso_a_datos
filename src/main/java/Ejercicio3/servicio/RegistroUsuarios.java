package servicio;

import modelo.Canal;
import modelo.Usuario;

public class RegistroUsuarios {

    public static Usuario[] userList = new Usuario[Canal.MAX_USUARIOS];

    public static boolean altaUsuario(Usuario u) {
        if (Usuario.contadorUsuarios >= Canal.MAX_USUARIOS) {
            return false;
        }
        // Comprobar si el email ya existe
        for (int i = 0; i < Usuario.contadorUsuarios; i++) {
            if (userList[i] != null && userList[i].getEmail().equalsIgnoreCase(u.getEmail())) {
                return false;
            }
        }
        userList[Usuario.contadorUsuarios] = u;
        return true;
    }

    public static Usuario buscarPorEmail(String email) {
        for (int i = 0; i < Usuario.contadorUsuarios; i++) {
            if (userList[i] != null && userList[i].getEmail().equalsIgnoreCase(email)) {
                return userList[i];
            }
        }
        return null;
    }

    public static void listar() {
        for (int i = 0; i < Usuario.contadorUsuarios; i++) {
            System.out.println(userList[i].mostrarInfo());
        }
    }

    public static int getTotalUsuarios() {
        return Usuario.contadorUsuarios;
    }

}
