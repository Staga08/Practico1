package cliente.view;

import java.util.Random;

import javax.swing.JComboBox;

import cliente.controller.ChatController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Chat extends Stage{
	private Scene scene;
	private Label instruccionesL;
	private Label letra;
	private Label nombre;
	private TextField nombreT;
	private Label apellido;
	private TextField apellidoT;
	private Label lugar;
	private TextField lugarT;
	private Label animal;
	private TextField animalT;
	private Button stop;
	
	private Label puntaje;


	private Label nombred;
	private TextField nombredT;
	private Label apellidod;
	private TextField apellidodT;
	private Label lugard;
	private TextField lugardT;
	private Label animald;
	private TextField animaldT;
	
	
	
	
	private Label queSoy;
	//ObservableList<String> items = FXCollections.observableArrayList();
	
	
	
	
	//Controlador	
	private ChatController controller;
	
	public Chat() {
		
		
		
		//items.addAll("P1", "P2");

		//listado= new ComboBox(items);

		queSoy=new Label("No se ha podido establecer conexion");
		
		nombreT = new TextField();
		nombreT.setText("");
		apellidoT = new TextField();
		apellidoT.setText("");
		lugarT = new TextField();
		lugarT.setText("");
		animalT = new TextField();
		animalT.setText("");
		
		nombredT = new TextField();
		nombredT.setText("");
		apellidodT = new TextField();
		apellidodT.setText("");
		lugardT = new TextField();
		lugardT.setText("");
		animaldT = new TextField();
		animaldT.setText("");
		
		letra= new Label("");
		nombre=new Label("NOMBRE");
		apellido=new Label("APELLIDO");
		lugar=new Label("LUGAR");
		animal=new Label("ANIMAL");
		
		nombred=new Label("NOMBRE");
		apellidod=new Label("APELLIDO");
		lugard=new Label("LUGAR");
		animald=new Label("ANIMAL");
		
		puntaje= new Label("0");

		instruccionesL = new Label("LETRA: ");
		stop = new Button("STOP");
		
		
		
		

		
		VBox root = new VBox();
		root.getChildren().add(instruccionesL);
		root.getChildren().add(letra);
		root.getChildren().add(queSoy);
		root.getChildren().add(nombre);
		root.getChildren().add(nombreT);
		root.getChildren().add(apellido);
		root.getChildren().add(apellidoT);
		root.getChildren().add(lugar);
		root.getChildren().add(lugarT);
		root.getChildren().add(animal);
		root.getChildren().add(animalT);
		root.getChildren().add(stop);
		
		root.getChildren().add(nombred);
		root.getChildren().add(nombredT);
		root.getChildren().add(apellidod);
		root.getChildren().add(apellidodT);
		root.getChildren().add(lugard);
		root.getChildren().add(lugardT);
		root.getChildren().add(animald);
		root.getChildren().add(animaldT);
		root.getChildren().add(puntaje);
		
		
		scene = new Scene(root,500,500);
		this.setScene(scene);
		this.setTitle("Domi Games");
		
		controller = new ChatController(this);
	}

	public Button getStopB() {
		return stop;
	}

	public Label getInstruccionesL() {
		return instruccionesL;
	}

	public void setInstruccionesL(Label instruccionesL) {
		this.instruccionesL = instruccionesL;
	}

	public Label getLetra() {
		return letra;
	}

	public void setLetra(Label letra) {
		this.letra = letra;
	}

	public Label getNombre() {
		return nombre;
	}

	public void setNombre(Label nombre) {
		this.nombre = nombre;
	}

	public TextField getNombreT() {
		return nombreT;
	}

	public void setNombreT(TextField nombreT) {
		this.nombreT = nombreT;
	}

	public Label getApellido() {
		return apellido;
	}

	public void setApellido(Label apellido) {
		this.apellido = apellido;
	}

	public TextField getApellidoT() {
		return apellidoT;
	}

	public void setApellidoT(TextField apellidoT) {
		this.apellidoT = apellidoT;
	}

	public Label getLugar() {
		return lugar;
	}

	public void setLugar(Label lugar) {
		this.lugar = lugar;
	}

	public TextField getLugarT() {
		return lugarT;
	}

	public void setLugarT(TextField lugarT) {
		this.lugarT = lugarT;
	}

	public Label getAnimal() {
		return animal;
	}

	public void setAnimal(Label animal) {
		this.animal = animal;
	}

	public TextField getAnimalT() {
		return animalT;
	}

	public void setAnimalT(TextField animalT) {
		this.animalT = animalT;
	}

	public Button getStop() {
		return stop;
	}

	public void setStop(Button stop) {
		this.stop = stop;
	}


	public ChatController getController() {
		return controller;
	}

	public void setController(ChatController controller) {
		this.controller = controller;
	}

	public Label getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Label puntaje) {
		this.puntaje = puntaje;
	}


	public Label getNombred() {
		return nombred;
	}

	public void setNombred(Label nombred) {
		this.nombred = nombred;
	}

	public TextField getNombredT() {
		return nombredT;
	}

	public void setNombredT(TextField nombredT) {
		this.nombredT = nombredT;
	}

	public Label getApellidod() {
		return apellidod;
	}

	public void setApellidod(Label apellidod) {
		this.apellidod = apellidod;
	}

	public TextField getApellidodT() {
		return apellidodT;
	}

	public void setApellidodT(TextField apellidodT) {
		this.apellidodT = apellidodT;
	}

	public Label getLugard() {
		return lugard;
	}

	public void setLugard(Label lugard) {
		this.lugard = lugard;
	}

	public TextField getLugardT() {
		return lugardT;
	}

	public void setLugardT(TextField lugardT) {
		this.lugardT = lugardT;
	}

	public Label getAnimald() {
		return animald;
	}

	public void setAnimald(Label animald) {
		this.animald = animald;
	}

	public TextField getAnimaldT() {
		return animaldT;
	}

	public void setAnimaldT(TextField animaldT) {
		this.animaldT = animaldT;
	}

	public Label getQueSoy() {
		return queSoy;
	}

	public void setQueSoy(Label queSoy) {
		this.queSoy = queSoy;
	}

	
	


}
