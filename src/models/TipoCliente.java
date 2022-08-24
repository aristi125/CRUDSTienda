package models;

public enum TipoCliente {
	//------------------------------------------------ATRIBUTOS------------------------------------------------//

	    NATURAL("natural", 0), JURIDICO("juridico", 1);
	    String tipoCliente;
	    int numCliente;
	//------------------------------------------------CONSTRUCTORES------------------------------------------------//

	    private TipoCliente (String tipoCliente, int numCliente){
	        this.tipoCliente = tipoCliente;
	        this.numCliente = numCliente;
	    }

	//------------------------------------------------GETTERS------------------------------------------------//

	    public String getTipoCliente() {
	        return tipoCliente;
	    }

	    public int getNumCliente() {
	        return numCliente;
	    }
	    
	}


