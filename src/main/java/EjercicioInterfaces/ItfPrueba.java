package EjercicioInterfaces;

public class ItfPrueba {
    public static void main(String[] args) {
        // Instancias de las clases solicitadas
        ItfNeutro neutro = new ItfNeutro();
        ItfNegativoImpresion negativo = new ItfNegativoImpresion();

        // Demostración de los métodos de impresión
        System.out.println("ItfNeutro.imprimir(): " + neutro.imprimir());
        System.out.println("ItfNeutro.imprimirBonito(): " + neutro.imprimirBonito());
        System.out.println("ItfNegativoImpresion.imprimir(): " + negativo.imprimir());

        float[] Notas = {3, 6, 8, 10, 2, 5, 7, 9, 10};
        CCentroDeEstudios MiAula = new CCentroDeEstudios();
        System.out.println("Aprobados: " + MiAula.NumeroDeAprobados(Notas));
        System.out.println("Suspensos: " + MiAula.NumeroDeSuspensos(Notas));
        System.out.println("Media: " + MiAula.NotaMedia(Notas));
        System.out.println("Varianza: " + MiAula.Varianza(Notas));
    }
}
