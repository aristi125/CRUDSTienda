package models;
public class Detalle {
	//------------------------------------------------ATRIBUTOS------------------------------------------------//

	    private String nombreProducto, codigoProducto;
	    private int cantProducto;
	    private double precioUnitario, totalProducto, iva;
	    
	    
	//------------------------------------------------CONSTRUCTORES------------------------------------------------//

	    public Detalle(String nombreProducto, String codigoProducto, int cantProducto, double precioUnitario) {
	        this.codigoProducto = codigoProducto;
	        this.nombreProducto = nombreProducto;
	        this.cantProducto = cantProducto;
	        this.precioUnitario = precioUnitario;
	        this.totalProducto = this.precioUnitario * this.cantProducto;
	        this.iva = totalProducto * 0.19;
	    }


	    

	//------------------------------------------------GETTERS------------------------------------------------//

	    public String getNombreProducto() {
	        return nombreProducto;
	    }

	     public String getCodigoPorducto() {
	        return codigoProducto;
	    }
	    
	    public int getCantProducto() {
	        return cantProducto;
	    }

	    public double getPrecioUnitario() {
	        return precioUnitario;
	    }

	    public double getTotalProducto() {
	        return totalProducto;
	    }

	    public double getIva() {
	        return iva;
	    }
	    
	    

	//------------------------------------------------SETTERS------------------------------------------------//

	    public void setNombreProducto(String nombreProducto) {
	        this.nombreProducto = nombreProducto;
	    }
	    
	    public void setCodigoProducto(String codigoProducto) {
	        this.codigoProducto = codigoProducto;
	    }

	    public void setCantProducto(int cantProducto) {
	        this.cantProducto = cantProducto;
	    }

	    public void setPrecioUnitario(double precioUnitario) {
	        this.precioUnitario = precioUnitario;
	    }

	    public void setTotalProducto(double totalProducto) {
	        this.totalProducto = totalProducto;
	    }

	    public void setIva(double iva) {
	        this.iva = iva;
	    }

	   

	    
	   
	    
	}
