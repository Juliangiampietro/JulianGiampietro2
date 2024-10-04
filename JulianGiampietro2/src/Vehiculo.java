public class Vehiculo {
    private String modelo;
    private double kilometraje;
    private int anio;
    private String codigoInterno;
    private double tarifaPorDia;
    private TipoVehiculo tipo;

    public Vehiculo(String modelo, double kilometraje, int anio, String codigoInterno, double tarifaPorDia, TipoVehiculo tipo) {
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.anio = anio;
        this.codigoInterno = codigoInterno;
        this.tarifaPorDia = tarifaPorDia;
        this.tipo = tipo;
    }


    public double getTarifaPorDia() {
        return tarifaPorDia;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }
}