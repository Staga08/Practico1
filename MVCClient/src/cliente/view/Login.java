package cliente.view;

import cliente.comunicacion.Receiver.OnMessageListener;
import cliente.comunicacion.TCPConnection;
import cliente.controller.LoginController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Login extends Stage {

	private Scene scene;
	private Label instruccionesL;
	
	private Label ipLabel;
	private TextField ipTF;
	private Label puertoLabel;
	private TextField puertoTF;
	
	private Button conectarB;
	
	//Controlador
	private LoginController controller;
	
	
	public Login() {
		
		ipLabel = new Label("Direcci�n IP");
		puertoLabel = new Label("Puerto");
		
		ipTF = new TextField();
		puertoTF = new TextField();
		
		instruccionesL = new Label("Ingrese la direcci�n IP y el puerto del servidor al que se quiere conectar");
		conectarB = new Button("Conectar");
		
		VBox root = new VBox();
		root.getChildren().add(instruccionesL);
		root.getChildren().add(ipLabel);
		root.getChildren().add(ipTF);
		root.getChildren().add(puertoLabel);
		root.getChildren().add(puertoTF);
		root.getChildren().add(conectarB);
		scene = new Scene(root,400,400);
		this.setScene(scene);
		
		controller = new LoginController(this);
	}


	public Button getConectarB() {
		return conectarB;
	}


	public void setConectarB(Button conectarB) {
		this.conectarB = conectarB;
	}


	public TextField getIpTF() {
		return ipTF;
	}


	public TextField getPuertoTF() {
		return puertoTF;
	}

	
	
	


	
}
