package Excepciones.NewException;

public class Cuenta {

    // src/main/java/Excepciones/NewException/Cuenta.java
    private double saldo = 0;

    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    // El método lanza una excepción si el saldo es insuficiente
    public void extraer(double cantidad) throws Exception {
        if (saldo < cantidad) {
            throw new Exception("Saldo insuficiente");
        } else {
            saldo -= cantidad;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}


