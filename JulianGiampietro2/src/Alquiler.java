import java.text.SimpleDateFormat;
import java.util.Date;
public class Alquiler {
    public Cliente cliente;
    private Vehiculo vehiculo;
    private Sucursal sucursalInicio;
    private Sucursal sucursalFin;
    private Date fechaInicio;
    private Date fechaFin;
    private double kmRecorridos;

    public Alquiler(Cliente cliente, Vehiculo vehiculo, Sucursal sucursalInicio, Sucursal sucursalFin, Date fechaInicio, Date fechaFin, double kmRecorridos) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.sucursalInicio = sucursalInicio;
        this.sucursalFin = sucursalFin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.kmRecorridos = kmRecorridos;
    }

    public double calcularCosto() {
        long diasAlquiler = (fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24);
        double costoKilometros = kmRecorridos * 50;
        double costoDias = diasAlquiler * vehiculo.getTarifaPorDia();
        return costoKilometros + costoDias;
    }


    public Vehiculo getVehiculo() {
        return vehiculo;
    }


}