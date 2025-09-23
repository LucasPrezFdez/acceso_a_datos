package EjercicioHerencia2;

public class Pelicula extends Multimedia{

    String actorPrincipal;
    String actrizPrincipal;

    public Pelicula(String titulo, String autor, Formato formato, double duracion, String actorPrincipal, String actrizPrincipal) {
        super(titulo, autor, formato, duracion);
        if (actorPrincipal == null && actrizPrincipal == null) {
            throw new IllegalArgumentException("Al menos uno de los dos (actorPrincipal o actrizPrincipal) debe ser no nulo.");
        }
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;

    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    public void setActrizPrincipal(String actrizPrincipal) {
        this.actrizPrincipal = actrizPrincipal;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "actorPrincipal='" + actorPrincipal + '\'' +
                ", actrizPrincipal='" + actrizPrincipal + '\'' +
                "} " + super.toString();
    }
}
