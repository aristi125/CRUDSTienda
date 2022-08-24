package controllers;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Almacen;
import models.Cliente;

public class registroClienteController implements Initializable{

	@FXML
    private Button btnActualizar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btneliminar;

    @FXML
    private RadioButton rbJuridica;

    @FXML
    private RadioButton rbNatural;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Cliente> tablaCliente = new TableView<Cliente>();
    
    @FXML
    private TableColumn<Cliente, String> tblApellidos = new TableColumn<Cliente, String>();

    @FXML
    private TableColumn<Cliente, String> tblDireccion = new TableColumn<Cliente, String>();

    @FXML
    private TableColumn<Cliente, String> tblEmail = new TableColumn<Cliente, String>();

    @FXML
    private TableColumn<Cliente, String> tblFechaNacimiento = new TableColumn<Cliente, String>();

    @FXML
    private TableColumn<Cliente, String> tblIdTributaria = new TableColumn<Cliente, String>();

    @FXML
    private TableColumn<Cliente, String> tblIdentificacion = new TableColumn<Cliente, String>();

    @FXML
    private TableColumn<Cliente, String> tblNit = new TableColumn<Cliente, String>();

    @FXML
    private TableColumn<Cliente, String> tblNombre = new TableColumn<Cliente, String>();

    @FXML
    private TableColumn<Cliente, String> tblTelefono = new TableColumn<Cliente, String>();

    @FXML
    private ToggleGroup group;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFechaNacimiento;

    @FXML
    private TextField txtIDTributaria;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNit;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtxApellidos;

    //VARIABLES
    Stage stage;
    ObservableList<Cliente> listacliente = FXCollections.observableArrayList();
    private Cliente cliente;
    
    private Cliente clienteSeleccionado;
    Almacen almacen;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		txtEmail.setVisible(false);
		txtFechaNacimiento.setVisible(false);
		txtNit.setVisible(false);
		txtIDTributaria.setVisible(false);
		
		
		this.tblNombre.setCellValueFactory( new PropertyValueFactory<>("Nombre"));
		this.tblApellidos.setCellValueFactory( new PropertyValueFactory<>("Apellidos"));
		this.tblIdentificacion.setCellValueFactory( new PropertyValueFactory<>("Identificacion"));
		this.tblTelefono.setCellValueFactory( new PropertyValueFactory<>("Telefono"));
		this.tblApellidos.setCellValueFactory( new PropertyValueFactory<>("Apellidos"));
		this.tblDireccion.setCellValueFactory( new PropertyValueFactory<>("Direccion"));
		this.tblEmail.setCellValueFactory( new PropertyValueFactory<>("Email"));
		this.tblFechaNacimiento.setCellValueFactory( new PropertyValueFactory<>("Fecha nacimiento"));
		this.tblNit.setCellValueFactory( new PropertyValueFactory<>("Nit"));
		this.tblIdTributaria.setCellValueFactory( new PropertyValueFactory<>("Id tributaria"));
		
		for (int i = 0; i < listacliente.size(); i++) {
			System.out.println(listacliente.get(i).toString());
		}
		
		tablaCliente.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
			clienteSeleccionado = newSelection;
		});
	}
	
	//METODOS
	
	@FXML
    void BorrarCliente(ActionEvent event) {
		eliminarCliente();
    }

    @FXML
    void actualizarCliente(ActionEvent event) {
    	actualizarCliente();
    }
	
	@FXML
    void guardarCliente(ActionEvent event) {
		crearCliente();
    }

	private void eliminarCliente() {
		for(int i=0; i<listacliente.size(); i++) {
			if(listacliente.get(i).getIdentificacion().equals(txtIdentificacion.getText())) {
				listacliente.remove(i);
				
			}
		}
		tablaCliente.refresh();
	}
	private void actualizarCliente() {
		String nit, idTributaria, nombre, apellido, identificacion, direccion, telefono, correo,fechaNacimiento;
    	int tipoCliente;
    	
    	try {
			
    		nit = this.txtNit.getText();
    		idTributaria = this.txtIDTributaria.getText();
    		nombre = this.txtNombre.getText();
    		apellido = this.txtxApellidos.getText();
    		identificacion = this.txtIdentificacion.getText();
    		direccion = this.txtDireccion.getText();
    		telefono = this.txtTelefono.getText();
    		tipoCliente = Integer.parseInt(this.rbJuridica.getTypeSelector());
    		correo = this.txtEmail.getText();
    		fechaNacimiento = this.txtFechaNacimiento.getText();
    		
    		Cliente clienteNuevo = almacen.crearCliente(nit, idTributaria, nombre, apellido, identificacion, direccion, telefono, tipoCliente, correo, fechaNacimiento);
    		for(int i=0; i<listacliente.size(); i++) {
    			if(listacliente.get(i).getIdentificacion().equals(clienteNuevo.getIdentificacion())) {
    				listacliente.add(i, clienteNuevo);
    				listacliente.remove(i+1);
    			}
    		}
    			
    			tablaCliente.refresh();
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    private void crearCliente() {
		
    	String nit, idTributaria, nombre, apellido, identificacion, direccion, telefono, correo,fechaNacimiento;
    	int tipoCliente;
    	
    	try {
			
    		nit = this.txtNit.getText();
    		idTributaria = this.txtIDTributaria.getText();
    		nombre = this.txtNombre.getText();
    		apellido = this.txtxApellidos.getText();
    		identificacion = this.txtIdentificacion.getText();
    		direccion = this.txtDireccion.getText();
    		telefono = this.txtTelefono.getText();
    		tipoCliente = Integer.parseInt(this.rbJuridica.getTypeSelector());
    		correo = this.txtEmail.getText();
    		fechaNacimiento = this.txtFechaNacimiento.getText();
    		
    		Cliente clienteNuevo = almacen.crearCliente(nit, idTributaria, nombre, apellido, identificacion, direccion, telefono, tipoCliente, correo, fechaNacimiento);
    		if(!this.listacliente.contains(clienteNuevo)) {
    			listacliente.add(clienteNuevo);
    			
    			tablaCliente.refresh();
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@FXML
    void mostrarPersona(ActionEvent event) {
    	
    	if(rbNatural.isSelected()) {
    		txtEmail.setVisible(true);
    		txtFechaNacimiento.setVisible(true);
    		txtNit.setVisible(false);
    		txtIDTributaria.setVisible(false);
    	}
    	else if (rbJuridica.isSelected()) {
			txtNit.setVisible(true);
			txtIDTributaria.setVisible(true);
			txtEmail.setVisible(false);
			txtFechaNacimiento.setVisible(false);
    	}
    }

}
