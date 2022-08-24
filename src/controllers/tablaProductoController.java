package controllers;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class tablaProductoController implements Initializable{

	@FXML
    private TableColumn<?, ?> ColPaisOrigen;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnListar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableColumn<?, ?> colCantidadExistente;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colFechaEnvasado;

    @FXML
    private TableColumn<?, ?> colFechaVencimiento;

    @FXML
    private TableColumn<?, ?> colIDAprovacion;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colPesoEnvase;

    @FXML
    private TableColumn<?, ?> colTemperatura;

    @FXML
    private TableColumn<?, ?> colValorUnitario;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tablaProductos;

    @FXML
    private TextField txtBuscarProducto;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	//METODOS
	
	@FXML
    void borrarProducto(ActionEvent event) {

    }

    @FXML
    void buscarProducto(KeyEvent event) {

    }

    @FXML
    void editarProducto(ActionEvent event) {

    }

    @FXML
    void listarProductos(ActionEvent event) {

    }

    registroProductoController registroProductoController;
    Stage stageProducto = null;
    @FXML
    void nuevoProducto(ActionEvent event) throws IOException {

    	root.setEffect(new GaussianBlur(7.0));
        //CEAMOS UNA INSTANCIA DEL FXMLLOADER
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/View/RegistroProductos.fxml"));
        //LOAD ES EL QUE AYUDA A CARGAR LA VENTANA DE LA INTERFAZ GRAFICA
        AnchorPane ap =fxmlLoader.load();
        registroProductoController = fxmlLoader.getController();
        //ES LA VENTANA COMO SI FUEREA UN JFRAME
        Scene scene = new Scene(ap);
        stageProducto = new Stage();

        stageProducto.setScene(scene);
        stageProducto.initOwner(root.getScene().getWindow());
        stageProducto.initModality(Modality.WINDOW_MODAL);
        stageProducto.initStyle(StageStyle.DECORATED);
        stageProducto.setResizable(false);
        stageProducto.setOnCloseRequest((WindowEvent e)->{
            root.setEffect(null);
        });

        stageProducto.setOnHidden((WindowEvent e)->{
            root.setEffect(null);
        });
        stageProducto.showAndWait();
        
    }

}
