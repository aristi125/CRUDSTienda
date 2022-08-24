package controllers;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ventanaProductoController implements Initializable{

	@FXML
	private Menu menuCliente;

	@FXML
	private MenuItem menuNuevoCliente;

	@FXML
	private Menu menuProducto;

	@FXML
	private Menu menuVentas;

	@FXML
	private MenuItem menuVerProducto;

	@FXML
	private MenuItem menuVerVentas;

	@FXML
	private BorderPane root;

	@FXML
	private TabPane tabPane;
	
	//ATRIBUTOS
	private Tab tabProductos;
	private Tab tabCliente;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


	//ATRIBUTOS
	@FXML
	void menuRealizarVentas(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/RegistrarVenta.fxml"));
        VBox ap = loader.load();
        registrarVentaController rvc = loader.getController();
        Tab tabRealizarVenta = new Tab(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE dd MMM hh:mm:ss a")), ap);
        
        tabRealizarVenta.setClosable(true);
        tabPane.getTabs().add(tabRealizarVenta);
//        rvc.getCjCodigoBarras().requestFocus();
        tabPane.getSelectionModel().select(tabRealizarVenta);
	}

	
	@FXML
	void menuVerProductos(ActionEvent event) throws IOException {

		if(tabProductos == null){
            AnchorPane ap = FXMLLoader.load(getClass().getResource("/views/RegistroProductos.fxml"));
            tabProductos = new Tab("PRODUCTOS", ap);
            tabProductos.setClosable(true);
            tabProductos.setOnClosed(event1 -> {
                tabProductos = null;
            });
            tabPane.getTabs().add(tabProductos);
        }
        tabPane.getSelectionModel().select(tabProductos);
	}

	@FXML
	void nuevoCliente(ActionEvent event) throws IOException {
		if(tabCliente == null){
            AnchorPane ap = FXMLLoader.load(getClass().getResource("/views/RegistroCliente.fxml"));
            tabCliente = new Tab("CLIENTES", ap);
            tabCliente.setClosable(true);
            tabCliente.setOnClosed(event1 -> {
            	tabCliente = null;
            });
            tabPane.getTabs().add(tabCliente);
        }
        tabPane.getSelectionModel().select(tabCliente);
	}
	

}
