package app;

import modelo.Usuario;
import servicio.RegistroMensajes;
import servicio.RegistroUsuarios;
import utilidades.Mensajes;

public class MainApp {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Lucas", "lucaslinoperez@gmail.com");
        Usuario user2 = new Usuario("Morenito", "minimoregay@gmail.com");

        RegistroUsuarios.altaUsuario(user1);
        RegistroUsuarios.altaUsuario(user2);

        Mensajes.mostrarSaludo(user1);
        Mensajes.mostrarSaludo(user2);

        RegistroMensajes mensajes = new RegistroMensajes();

        RegistroMensajes.enviar("lucaslinoperez@gmail.com", "minimoregay@gmail.com", "hierro cojo");

        System.out.println(mensajes.bandejaDeEntrada("minimoregay@gmail.com"));

        System.out.println(mensajes.bandejaDeEntrada("lucaslinoperez@gmail.com"));

        System.out.println("Contador de usuarios creados: " + Usuario.contadorUsuarios);
        System.out.println("Total de usuarios registrados: " + RegistroUsuarios.getTotalUsuarios());
        System.out.println("Total de mensajes enviados: " + RegistroMensajes.totalMensajes());

        System.out.println(Mensajes.formatearMensaje("La base de virus ha sido actualizada"));

    }

}