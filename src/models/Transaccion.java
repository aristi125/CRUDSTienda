package models;

import java.util.ArrayList;

public class Transaccion {
	//------------------------------------------------ATRIBUTOS------------------------------------------------//
	    private String codigo, fecha;
	    private Cliente comprador;
	    private ArrayList<Detalle> detallesVenta = new ArrayList<>();
	    private Double  total, iva;
	//------------------------------------------------CONSTRUCTORES------------------------------------------------//
	    public Transaccion(String codigo, String fecha, Cliente comprador, ArrayList<Detalle> listaDetalles) {
	        this.codigo = codigo;
	        this.fecha = fecha;
	        this.comprador = comprador;
	        this.detallesVenta = (ArrayList<Detalle>) listaDetalles.clone();
	        this.total = generarTotal(listaDetalles);
	        this.iva = generarIva(listaDetalles);
	    }
	//------------------------------------------------GETTERS------------------------------------------------//
	    public String getCodigo() {
	        return codigo;
	    }

	    public String getFecha() {
	        return fecha;
	    }

	    public Cliente getComprador() {
	        return comprador;
	    }

	    public ArrayList<Detalle> getDetallesVenta() {
	        return detallesVenta;
	    }

	    public Double getTotal() {
	        return total;
	    }

	    public Double getIva() {
	        return iva;
	    }

	    //------------------------------------------------SETTERS------------------------------------------------//
	    
	    public void setCodigo(String codigo) {
	        this.codigo = codigo;
	    }

	    public void setFecha(String fecha) {
	        this.fecha = fecha;
	    }

	    public void setComprador(Cliente comprador) {
	        this.comprador = comprador;
	    }

	    public void setTotal(Double total) {
	        this.total = total;
	    }

	    public void setIva(Double iva) {
	        this.iva = iva;
	    }

	    public void setDetallesVenta(ArrayList<Detalle> detallesVenta) {
	        this.detallesVenta = detallesVenta;
	    }
	 //------------------------------------------------FUNCIONES------------------------------------------------//
	    private double generarTotal (ArrayList<Detalle> listaDetallesAux){
	       double totalAux = 0;
	       for(int i=0; i<listaDetallesAux.size(); i++){
	           totalAux+=listaDetallesAux.get(i).getTotalProducto();
	       }
	       return totalAux;
	   } 
	   private double generarIva (ArrayList<Detalle> listaDetallesAux){
	       double totalAux = 0;
	       for(int i=0; i<listaDetallesAux.size(); i++){
	           totalAux+=listaDetallesAux.get(i).getIva();
	       }
	       return totalAux;
	   } 

	}
