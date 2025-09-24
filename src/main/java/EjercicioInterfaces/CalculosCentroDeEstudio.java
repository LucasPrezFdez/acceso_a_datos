package EjercicioInterfaces;

public interface CalculosCentroDeEstudio {
    short numeroDeAprobados(float[] notas);

    short numeroDeSuspensos(float[] notas);

    float notaMedia(float[] notas);

    float varianza(float[] notas);
}

