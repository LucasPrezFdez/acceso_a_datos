package ConexionBBDD.ModeloVCExercise.Modelo.vo;

public class ProductosVo {

    private int idProducto;
    private String nombre;
    private int suplierID;
    private int categoryID;
    private String cantidadProducto;
    private int precioUnidad;
    private int stock;
    private int unidadesEnOrden;
    private int nivelPrioridadOrden;
    private int descontinuado;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSuplierID() {
        return suplierID;
    }

    public void setSuplierID(int suplierID) {
        this.suplierID = suplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getUnidadesEnOrden() {
        return unidadesEnOrden;
    }

    public void setUnidadesEnOrden(int unidadesEnOrden) {
        this.unidadesEnOrden = unidadesEnOrden;
    }

    public int getNivelPrioridadOrden() {
        return nivelPrioridadOrden;
    }

    public void setNivelPrioridadOrden(int nivelPrioridadOrden) {
        this.nivelPrioridadOrden = nivelPrioridadOrden;
    }

    public int getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(int descontinuado) {
        this.descontinuado = descontinuado;
    }
}
