package models;

public enum TipoProducto {
    //------------------------------------------------ATRIBUTOS------------------------------------------------//

    REFRIGERACION(0,"refrigerar"), PERECEDERO(1, "perecedero"), ENVASADO(2, "envace");
    private Integer numTipo;
    private String nomTipo;
    
//------------------------------------------------CONSTRUCTORES------------------------------------------------//

    private TipoProducto(Integer numTipo, String nomTipo) {
        this.numTipo = numTipo;
        this.nomTipo = nomTipo;
    }

//------------------------------------------------GETTERS------------------------------------------------//

    public Integer getNumTipo() {
        return numTipo;
    }

    public String getNomTipo() {
        return nomTipo;
    }
    
}
