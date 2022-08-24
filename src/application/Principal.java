package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Principal extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//CARGAMOS EL FXML QUE SE HACE PARA QUE MUESTRE LA INTERFAZ
		BorderPane anchorPane = FXMLLoader.load(getClass().getResource("/views/VentanaProducto.fxml"));

		//HACEMOS UNA ECENA QUE ES COMO EL FORMULARIO
		primaryStage.setTitle("TIENDA!");
		//SE LLAMA LA VARIABLE DONE QUEDA LA VISTA DE LA INTERFAZ GRAFICA
		primaryStage.setScene(new Scene(anchorPane));
		//PARA QUE MUESTRE LA INTERFAZ GRAFICA
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	

}
