package models;
public class ClienteJuridico extends Cliente{

	//------------------------------------------------ATRIBUTOS------------------------------------------------//

	    private String nit, idTributaria;

	//------------------------------------------------CONSTRUCTORES------------------------------------------------//

	    public ClienteJuridico(String nit, String idTributaria, String nombre, String apellido, String identificacion, String direccion, String telefono, TipoCliente tipoCliente) {
	        super(nombre, apellido, identificacion, direccion, telefono, tipoCliente);
	        this.nit = nit;
	        this.idTributaria = idTributaria;
	    }

	    

	//------------------------------------------------GETTERS------------------------------------------------//
	    
	    public String getNit() {
	        return nit;
	    }

	    public String getIdTributaria() {
	        return idTributaria;
	    }

	//------------------------------------------------SETTERS------------------------------------------------//
	    
	    public void setNit(String nit) {
	        this.nit = nit;
	    }

	    public void setIdTributaria(String idTributaria) {
	        this.idTributaria = idTributaria;
	    }

	    @Override
	    public String toString() {
	        return "ClienteJuridico{" + "nit=" + nit + ", idTributaria=" + idTributaria + '}';
	    }
	    
	    
	}
