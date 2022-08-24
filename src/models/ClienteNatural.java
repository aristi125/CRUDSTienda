package models;

public class ClienteNatural extends Cliente {
    private String correo, fechaNacimiento;

    public ClienteNatural(String correo, String fechaNacimiento, String nombre, String apellido, String identificacion, String direccion, String telefono, TipoCliente tipoCliente) {
        super(nombre, apellido, identificacion, direccion, telefono, tipoCliente);
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    

    
    
    
}
