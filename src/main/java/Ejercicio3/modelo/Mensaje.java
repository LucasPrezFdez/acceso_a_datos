package modelo;

public class Mensaje {

    private int id;
    private String remitente;
    private String destinatario;
    private String texto;

    public Mensaje(int id, String remitente, String destinatario, String texto) {
        this.id = id;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTexto() {
        return texto;
    }

    public void mostrarInfo() {
        System.out.println("#id: "+id+
                "\nDe remitente: "+remitente+
                "\nA destinatario: "+destinatario

        );

    }
}
