package EjercicioInterfaces;

public class CCentroDeEstudios implements CentroDeEstudio {
    @Override
    public short NumeroDeAprobados(float[] Notas) {
        short NumAprobados = 0;
        for (int i = 0; i < Notas.length; i++) {
            if (Notas[i] >= 5.0f) {
                NumAprobados++;
            }
        }
        return NumAprobados;
    }

    @Override
    public short NumeroDeSuspensos(float[] Notas) {
        short NumSuspensos = 0;
        for (int i = 0; i < Notas.length; i++) {
            if (Notas[i] < 5.0f) {
                NumSuspensos++;
            }
        }
        return NumSuspensos;
    }

    @Override
    public float NotaMedia(float[] Notas) {
        float Suma = 0;
        for (int i = 0; i < Notas.length; i++) {
            Suma += Notas[i];
        }
        return Suma / (float) Notas.length;
    }

    @Override
    public float Varianza(float[] Notas) {
        float Media = NotaMedia(Notas);
        float Suma = 0;
        for (int i = 0; i < Notas.length; i++) {
            Suma += Math.abs(Media - Notas[i]);
        }
        return Suma / (float) Notas.length;
    }
}

