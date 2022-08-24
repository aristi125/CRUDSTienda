package models;
public class Producto {
	//------------------------------------------------ATRIBUTOS------------------------------------------------//
	    private String codigo, nombre, descripcion, fechaVencimiento = null, codigoAprobacion = null,
	            refrigeracionRecomendada = null, paisOrigen = null;
	    private final String a = "Colombia", b = "Argentina", c = "Chile", d = "Ecuador", e = "Peru";
	    private Double valorUntirario, pesoEnvase = null;
	    private Integer cantExistencias;

	    public Producto(String codigo, String nombre, String descripcion, String fechaVencimiento, String codigoAprobacion, String refrigeracionRecomendada, String paisOrigen, Double valorUntirario, Double pesoEnvase, Integer cantExistencias) {
	        this.codigo = codigo;
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	        this.fechaVencimiento = fechaVencimiento;
	        this.codigoAprobacion = codigoAprobacion;
	        this.refrigeracionRecomendada = refrigeracionRecomendada;
	        this.paisOrigen = paisOrigen;
	        this.valorUntirario = valorUntirario;
	        this.pesoEnvase = pesoEnvase;
	        this.cantExistencias = cantExistencias;
	    }

	    public String getCodigo() {
	        return codigo;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public String getFechaVencimiento() {
	        return fechaVencimiento;
	    }

	    public String getCodigoAprobacion() {
	        return codigoAprobacion;
	    }

	    public String getRefrigeracionRecomendada() {
	        return refrigeracionRecomendada;
	    }

	    public String getPaisOrigen() {
	        return paisOrigen;
	    }
	    public int getNumPaisOrigen() {
	        int paisOrigenAux;
	        switch (paisOrigen) {
	            case "Colombia":
	                paisOrigenAux = 0;
	                break;
	            case "Argentina":
	                paisOrigenAux = 1;
	                break;
	            case "Chile":
	                paisOrigenAux = 2;
	                break;
	            case "Ecuador":
	                paisOrigenAux = 3;
	                break;
	            case "Peru":
	                paisOrigenAux = 0;
	                break;
	            default:
	                paisOrigenAux = -1;
	                break;
	        }
	        return paisOrigenAux;
	    }

	    public String getA() {
	        return a;
	    }

	    public String getB() {
	        return b;
	    }

	    public String getC() {
	        return c;
	    }

	    public String getD() {
	        return d;
	    }

	    public String getE() {
	        return e;
	    }

	    public Double getValorUntirario() {
	        return valorUntirario;
	    }

	    public Double getPesoEnvase() {
	        return pesoEnvase;
	    }

	    public Integer getCantExistencias() {
	        return cantExistencias;
	    }


	    public void setCodigo(String codigo) {
	        this.codigo = codigo;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public void setFechaVencimiento(String fechaVencimiento) {
	        this.fechaVencimiento = fechaVencimiento;
	    }

	    public void setCodigoAprobacion(String codigoAprobacion) {
	        this.codigoAprobacion = codigoAprobacion;
	    }

	    public void setRefrigeracionRecomendada(String refrigeracionRecomendada) {
	        this.refrigeracionRecomendada = refrigeracionRecomendada;
	    }

	    public void setValorUntirario(Double valorUntirario) {
	        this.valorUntirario = valorUntirario;
	    }

	    public void setPesoEnvase(Double pesoEnvase) {
	        this.pesoEnvase = pesoEnvase;
	    }

	    public void setCantExistencias(Integer cantExistencias) {
	        this.cantExistencias = cantExistencias;
	    }

	    public void setPaisOrigen(int pais){
	            switch (pais) {
	                case 0:
	                    paisOrigen = a;
	                    break;
	                case 1:
	                    paisOrigen = b;
	                    break;
	                case 2:
	                    paisOrigen = c;
	                    break;
	                case 3:
	                    paisOrigen = d;
	                    break;
	                    case 4:
	                    paisOrigen = e;
	                    break;
	                default:
	                    paisOrigen = null;
	                    break;
	            }
	        }

	    @Override
	    public String toString() {
	        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento + ", codigoAprobacion=" + codigoAprobacion + ", refrigeracionRecomendada=" + refrigeracionRecomendada + ", paisOrigen=" + paisOrigen + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", valorUntirario=" + valorUntirario + ", pesoEnvase=" + pesoEnvase + ", cantExistencias=" + cantExistencias+'}';
	    }
	    
	}