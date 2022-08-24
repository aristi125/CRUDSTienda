package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import models.Almacen;
import models.Cliente;
import models.Producto;

public class registroProductoController implements Initializable{

	@FXML
    private TableColumn<?, ?> ColDescripcion;

    @FXML
    private TableColumn<?, ?> ColPaisOrigen;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnGuardar;

    @FXML
    private TableColumn<Producto, Integer> colCantidadExistente = new TableColumn<Producto, Integer>();

    @FXML
    private TableColumn<Producto, String> colCodigo = new TableColumn<Producto, String>();

    @FXML
    private TableColumn<Producto, String> colFechaEnvasado = new TableColumn<Producto, String>();

    @FXML
    private TableColumn<Producto, String> colFechaVencimiento = new TableColumn<Producto, String>();

    @FXML
    private TableColumn<Producto, String> colIDAprovacion = new TableColumn<Producto, String>();

    @FXML
    private TableColumn<Producto, String> colNombre = new TableColumn<Producto, String>();

    @FXML
    private TableColumn<Producto, Double> colPesoEnvase = new TableColumn<Producto, Double>();

    @FXML
    private TableColumn<Producto, String> colTemperatura = new TableColumn<Producto, String>();

    @FXML
    private TableColumn<Producto, Double> colValorUnitario = new TableColumn<Producto, Double>();

    @FXML
    private RadioButton rbEnvasados;

    @FXML
    private RadioButton rbPerecederos;

    @FXML
    private RadioButton rbRefigerados;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Producto> tablaProductos = new TableView<Producto>();

    @FXML
    private ToggleGroup grupo;

    @FXML
    private TextField txtCantidadExistente;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCodigoAprovacion;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtFechaVencimiento;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPaisOrigen;

    @FXML
    private TextField txtPesoEnvase;

    @FXML
    private TextField txtTemperaturaRecomendada;

    @FXML
    private TextField txtValorUnitario;

    @FXML
    private TextField txtxFechaEnvasado;

	private Almacen almacen;
	
	ObservableList<Producto> listaProducto = FXCollections.observableArrayList();

    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		txtFechaVencimiento.setVisible(false);
		txtCodigoAprovacion.setVisible(false);
		txtTemperaturaRecomendada.setVisible(false);
		txtxFechaEnvasado.setVisible(false);
		txtPesoEnvase.setVisible(false);
		txtPaisOrigen.setVisible(false);
		
	}
	
	//METODOS
	
	@FXML
    void BorrarCliente(ActionEvent event) {
		eliminarCliente();
    }

    @FXML
    void actualizarCliente(ActionEvent event) {
    	actualizarProducto();
    }
	
	@FXML
    void guardarCliente(ActionEvent event) {
		crearProducto();
    }

	private void eliminarCliente() {
		String codigo,  nombreProducto,  descripcion,  
        refrigeracionRegistrada,  codigoAprobacion,
        fechaVencimiento,    pais;
    	double valorUntirario, pesoEnvase;
    	int cantExistencias;
    	
    	try {
			
    		codigo = this.txtCodigo.getText();
    		nombreProducto = this.txtNombre.getText();
    		descripcion = this.txtDescripcion.getText();
    		refrigeracionRegistrada = this.txtTemperaturaRecomendada.getText();
    		codigoAprobacion = this.txtCodigoAprovacion.getText();
    		fechaVencimiento = this.txtFechaVencimiento.getText();
    		pais = this.txtPaisOrigen.getText();
    		valorUntirario = Double.parseDouble(this.txtValorUnitario.getTypeSelector());
    		pesoEnvase = Double.parseDouble(this.txtPesoEnvase.getTypeSelector());
    		cantExistencias = Integer.parseInt(this.txtCantidadExistente.getTypeSelector());
    		
    		Producto clienteNuevo = almacen.eliminarProducto(codigo);
    		for(int i= 0; i<listaProducto.size(); i++) {
    			if(!this.listaProducto.contains(clienteNuevo)) {
        			listaProducto.remove(clienteNuevo);
        			
        			//tablaCliente.refresh();
        		}
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	 private void actualizarProducto() {
		 String codigo,  nombreProducto,  descripcion,  
	        refrigeracionRegistrada,  codigoAprobacion,
	        fechaVencimiento,    pais;
	    	double valorUntirario, pesoEnvase;
	    	int cantExistencias;
	    	
	    	try {
				
	    		codigo = this.txtCodigo.getText();
	    		nombreProducto = this.txtNombre.getText();
	    		descripcion = this.txtDescripcion.getText();
	    		refrigeracionRegistrada = this.txtTemperaturaRecomendada.getText();
	    		codigoAprobacion = this.txtCodigoAprovacion.getText();
	    		fechaVencimiento = this.txtFechaVencimiento.getText();
	    		pais = this.txtPaisOrigen.getText();
	    		valorUntirario = Double.parseDouble(this.txtValorUnitario.getTypeSelector());
	    		pesoEnvase = Double.parseDouble(this.txtPesoEnvase.getTypeSelector());
	    		cantExistencias = Integer.parseInt(this.txtCantidadExistente.getTypeSelector());
	    		
	    		Producto clienteNuevo = almacen.actualizarCliente(codigo, nombreProducto, descripcion, valorUnitario, cantExistencias, refrigeracionRegistrada, codigoAprobacion, fechaVencimiento, pesoEnvase, pais);
	    		if(!this.listaProducto.contains(clienteNuevo)) {
	    			listaProducto.add(clienteNuevo);
	    			
	    			//tablaCliente.refresh();
	    		}
			} catch (Exception e) {
				// TODO: handle exception
			}
	 }
    private void crearProducto() {
		
    	String codigo,  nombreProducto,  descripcion,  
        refrigeracionRegistrada,  codigoAprobacion,
        fechaVencimiento,    pais;
    	Double valorUntirario, pesoEnvase;
    	int cantExistencias;
    	
    	try {
			
    		codigo = this.txtCodigo.getText();
    		nombreProducto = this.txtNombre.getText();
    		descripcion = this.txtDescripcion.getText();
    		refrigeracionRegistrada = this.txtTemperaturaRecomendada.getText();
    		codigoAprobacion = this.txtCodigoAprovacion.getText();
    		fechaVencimiento = this.txtFechaVencimiento.getText();
    		pais = this.txtPaisOrigen.getText();
    		valorUntirario = Double.parseDouble(this.txtValorUnitario.getTypeSelector());
    		pesoEnvase = Double.parseDouble(this.txtPesoEnvase.getTypeSelector());
    		cantExistencias = Integer.parseInt(this.txtCantidadExistente.getTypeSelector());
    		
    		Producto clienteNuevo = almacen.crearProducto(codigo, nombreProducto, descripcion, valorUnitario, cantExistencias, refrigeracionRegistrada, codigoAprobacion, fechaVencimiento, pesoEnvase, pais);
    		if(!this.listaProducto.contains(clienteNuevo)) {
    			listaProducto.add(clienteNuevo);
    			
    			//tablaCliente.refresh();
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	@FXML
    void MostrarProductos(ActionEvent event) {
		

		if(rbPerecederos.isSelected()) {
			txtFechaVencimiento.setVisible(true);
			
			txtCodigoAprovacion.setVisible(false);
			txtTemperaturaRecomendada.setVisible(false);
			txtxFechaEnvasado.setVisible(false);
			txtPesoEnvase.setVisible(false);
			txtPaisOrigen.setVisible(false);
		}
		else if (rbRefigerados.isSelected()) {
			txtCodigoAprovacion.setVisible(true);
			txtTemperaturaRecomendada.setVisible(true);
			
			txtFechaVencimiento.setVisible(false);
			txtxFechaEnvasado.setVisible(false);
			txtPesoEnvase.setVisible(false);
			txtPaisOrigen.setVisible(false);
		}
		else if (rbEnvasados.isSelected()) {
			txtxFechaEnvasado.setVisible(true);
			txtPesoEnvase.setVisible(true);
			txtPaisOrigen.setVisible(true);
			
			txtFechaVencimiento.setVisible(false);
			txtCodigoAprovacion.setVisible(false);
			txtTemperaturaRecomendada.setVisible(false);
		}
    }

	@FXML
    void actualizarProducto(ActionEvent event) {
		
    }

    @FXML
    void borrarProducto(ActionEvent event) {

    }
	
    @FXML
    void guardarProducto(ActionEvent event) {

    }

}
