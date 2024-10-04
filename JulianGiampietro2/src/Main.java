import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


class SistemaAlquiler {
    private static ArrayList<Alquiler> alquileres = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("modelo A", 130050, 2020, "001", 100, TipoVehiculo.CUATRO_PUERTAS);
        Vehiculo vehiculo2 = new Vehiculo("modelo B", 154000, 2021, "002", 120, TipoVehiculo.DOS_PUERTAS);
        Sucursal sucursal1 = new Sucursal("ciudad A", "direccion A", "123456");
        Sucursal sucursal2 = new Sucursal("ciudad B", "direccion B", "654321");

        gestionarAlquiler(vehiculo1, sucursal1, sucursal2);
        mostrarAlquilerMayorCosto();
        contarAlquileresPorTipo();
        scanner.close();
    }

    private static void gestionarAlquiler(Vehiculo vehiculo1, Sucursal sucursal1, Sucursal sucursal2) {
        System.out.print("Ingrese el nombre del cliente... ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese DNI del cliente... ");
        String dni = scanner.nextLine();
        System.out.print("ingrese (true o false) si el cliente tiene registro... ");
        boolean tieneRegistro = scanner.nextBoolean();

        if (tieneRegistro) {
            Cliente cliente = new Cliente(nombreCompleto, dni, tieneRegistro);
            System.out.print("Ingrese km recorridos: ");
            double kmRecorridos = scanner.nextDouble();
            System.out.print("ingrese fecha de inicio, recorda utilizar:0000-00-00 con guion medio: ");
            String fechaInicioStr = scanner.next();
            System.out.print("ingrese fecha de fin : ");
            String fechaFinStr = scanner.next();


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicio = null;
            Date fechaFin = null;
            try {
                fechaInicio = sdf.parse(fechaInicioStr);
                fechaFin = sdf.parse(fechaFinStr);
            } catch (ParseException e) {
                System.out.println("formato mal utilizado, tenes que usar: YYYY-MM-DD.");
                return;
            }

            Alquiler alquiler = new Alquiler(cliente, vehiculo1, sucursal1, sucursal2, fechaInicio, fechaFin, kmRecorridos);
            alquileres.add(alquiler);
            System.out.println("alquiler registrado: " + alquiler);
        } else {
            System.out.println("el cliente no tiene registro para conducir");
        }
    }


    private static void mostrarAlquilerMayorCosto() {
        Alquiler alquilerMayorCosto = null;
        double maxCosto = 0;
        for (Alquiler a : alquileres) {
            double costo = a.calcularCosto();
            if (costo > maxCosto) {
                maxCosto = costo;
                alquilerMayorCosto = a;
            }
        }

        if (alquilerMayorCosto != null) {
            System.out.println("alquiler con mayor costo: " + alquilerMayorCosto);
        } else {
            System.out.println("no hay alquileres registrados.");
        }
    }

    private static void contarAlquileresPorTipo() {
        int[] contadorPorTipo = new int[TipoVehiculo.values().length];
        for (Alquiler a : alquileres) {
            contadorPorTipo[a.getVehiculo().getTipo().ordinal()]++;
        }
        for (TipoVehiculo tipo : TipoVehiculo.values()) {
            System.out.println("alquileres de " + tipo + ": " + contadorPorTipo[tipo.ordinal()]);
        }
    }
}
