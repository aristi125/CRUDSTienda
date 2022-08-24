package controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.Almacen;
import models.Cliente;
import models.Detalle;
import models.Producto;
import models.Transaccion;

public class registrarVentaController implements Initializable {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnPagar;

    @FXML
    private Button btnRestarProducto;

    @FXML
    private TableColumn<?, ?> colProducto;

    @FXML
    private TableColumn<?, ?> colProductos;

    @FXML
    private TableColumn<?, ?> colcantidad;

    @FXML
    private TableColumn<?, ?> coltotal;

    @FXML
    private TableColumn<?, ?> colvalor;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label lblIva;

    @FXML
    private VBox root;

    @FXML
    private Button sumarCantidad;

    @FXML
    private TableView<?> tablaPedidos;

    @FXML
    private TableView<?> tablaProductos;

    @FXML
    private TextField txtBuscarCompra;

    @FXML
    private TextField txtBuscarProducto;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextField txtFecha;

    @FXML
    private Text txtIva;

    @FXML
    private Text txtSubtotal;

    @FXML
    private Text txtTituloEmpresa;

    @FXML
    private Text txtTotal;
    
    Almacen almacen;
    
    private ArrayList<Detalle> listaDetalles = new ArrayList<>();
    int cantidad = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	
    }

    //METODOS
    
    @FXML
    void cancelarPedido(ActionEvent event) {
    	txtCliente.clear();
    	txtFecha.clear();
    	txtBuscarCompra.clear();
    	txtBuscarProducto.clear();
    }

    @FXML
    void pagar(ActionEvent event) {
    	Cliente cliente = almacen.leerCliente(txtCliente.getText());
  	
    	
    	Transaccion transaccion = almacen.generarTrasaccion(txtFecha.getText(), listaDetalles, cliente);
    }

    @FXML
    void restarCantidad(ActionEvent event) {
    	cantidad--;
    	Cliente cliente = almacen.leerCliente(txtCliente.getText());
    	Producto producto = almacen.leerProducto(txtBuscarProducto.getText());
    	for(int i=0; i<listaDetalles.size(); i++) {
    		if(listaDetalles.get(i).getCodigoPorducto().equals(producto.getCodigo())) {
    			almacen.ActualizarProductosResta(listaDetalles);
    		}
    	}
    }

    @FXML
    void sumarCantidad(ActionEvent event) {
    	cantidad++;
    	boolean comprobante = false;
    	Cliente cliente = almacen.leerCliente(txtCliente.getText());
    	Producto producto = almacen.leerProducto(txtBuscarProducto.getText());
    	for(int i=0; i<listaDetalles.size(); i++) {
    		if(listaDetalles.get(i).getCodigoPorducto().equals(producto.getCodigo())) {
    			almacen.ActualizarProductosSuma(listaDetalles);
    			comprobante = true;
    		}
    	}
    	if( comprobante == true) {
			Detalle detalle = almacen.generarCompra(cliente.getNombre(), producto.getCodigo(), cantidad, producto.getValorUntirario());
			listaDetalles.add(detalle);
    	}
    }

    @FXML
    void tablaPedidosKeyPressed(KeyEvent event) {

    }

    @FXML
    void tablaProductosKeyPressed(KeyEvent event) {

    }

    @FXML
    void tablaProductosMouseClicked(MouseEvent event) {

    }
}
