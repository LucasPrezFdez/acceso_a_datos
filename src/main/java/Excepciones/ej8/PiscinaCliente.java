package Excepciones.ej8;

public class PiscinaCliente {
    public static void operacionesPiscina(Piscina p) {
        for (int i = 1; i <= 3; i++) {
            int cantidadLlenar = (int)(Math.random() * 100);
            try {
                p.llenar(cantidadLlenar);
                System.out.println("Llenando con: " + cantidadLlenar + ". Nivel actual: " + p.getNivel());
            } catch (NivelPorEncimaDeMaximoException e) {
                System.out.println("Excepción: " + e.getMessage() + " Nivel actual: " + p.getNivel());
            }
        }
        for (int i = 1; i <= 3; i++) {
            int cantidadVaciar = (int)(Math.random() * 100);
            try {
                p.vaciar(cantidadVaciar);
                System.out.println("Vaciando con: " + cantidadVaciar + ". Nivel actual: " + p.getNivel());
            } catch (NivelPorDebajoDeCeroException e) {
                System.out.println("Excepción: " + e.getMessage() + " Nivel actual: " + p.getNivel());
            }
        }
    }

    public static void main(String[] args) {
        Piscina p = new Piscina(150);
        operacionesPiscina(p);
    }
}

