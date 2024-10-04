public class Cliente {
    private String nombreCompleto;
    private String dni;
    private boolean tieneRegistro;

    public Cliente(String nombreCompleto, String dni, boolean tieneRegistro) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.tieneRegistro = tieneRegistro;
    }
}