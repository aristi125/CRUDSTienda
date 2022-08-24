package models;
public class Cliente {
	//------------------------------------------------ATRIBUTOS------------------------------------------------//
	    private String nombre, apellido, identificacion, direccion, telefono;
	    private TipoCliente tipoCliente;

	//------------------------------------------------CONSTRUCTORES------------------------------------------------//

	    public Cliente(String nombre, String apellido, String identificacion, String direccion, String telefono, TipoCliente tipoCliente) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.identificacion = identificacion;
	        this.direccion = direccion;
	        this.telefono = telefono;
	        this.tipoCliente = tipoCliente;
	    }

	//------------------------------------------------GETTERS------------------------------------------------//

	    public String getNombre() {
	        return nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public String getIdentificacion() {
	        return identificacion;
	    }

	    public String getDireccion() {
	        return direccion;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	//------------------------------------------------SETTERS------------------------------------------------//

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public void setIdentificacion(String identificacion) {
	        this.identificacion = identificacion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    @Override
	    public String toString() {
	        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", identificacion=" + identificacion + ", direccion=" + direccion + ", telefono=" + telefono + '}';
	    }
	    
	    
	}
