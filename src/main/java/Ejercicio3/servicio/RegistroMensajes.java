package servicio;

import modelo.Canal;
import modelo.Mensaje;

public class RegistroMensajes {

    public static Mensaje[] messegeList = new Mensaje[Canal.MAX_MENSAJES];
    static int siguienteId = 0;

    public static void enviar(String remitente, String destinatario, String texto) {

        if (RegistroUsuarios.buscarPorEmail(remitente) != null &&
                RegistroUsuarios.buscarPorEmail(destinatario) != null) {
            for (int j = 0; j < messegeList.length; j++) {
                if (messegeList[j] == null) {
                    messegeList[j] = new Mensaje(siguienteId++, remitente, destinatario, texto);
                    return;
                }
            }
        }
    }

    public Mensaje[] bandejaDeEntrada(String email) {
        int count = 0;
        // Contar cuántos mensajes hay para ese destinatario
        for (Mensaje mensaje : messegeList) {
            if (mensaje != null && mensaje.getDestinatario().equalsIgnoreCase(email)) {
                count++;
            }
        }
        Mensaje[] bandeja = new Mensaje[count];
        int idx = 0;
        // Guardar los mensajes en el array
        for (Mensaje mensaje : messegeList) {
            if (mensaje != null && mensaje.getDestinatario().equalsIgnoreCase(email)) {
                bandeja[idx++] = mensaje;
            }
        }
        return bandeja;
    }

    public static int totalMensajes() {
        int idx = 0;
        for (int i = 0; i < messegeList.length; i++) {
            if (messegeList[i] != null) {
                idx++;
            }
        }

        return idx;
    }

}
