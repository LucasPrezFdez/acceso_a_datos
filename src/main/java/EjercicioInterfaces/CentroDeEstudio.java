package EjercicioInterfaces;

public interface CentroDeEstudio {

    byte NumeroDePisos = 5;
    byte NumeroDeAulas = 25;
    byte NumeroDeDespachos = 10;

    // resto de datos constantes
    short NumeroDeAprobados(float[] Notas);

    short NumeroDeSuspensos(float[] Notas);

    float NotaMedia(float[] Notas);

    float Varianza(float[] Notas);
// resto de metodos
}
