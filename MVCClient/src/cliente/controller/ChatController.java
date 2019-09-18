package cliente.controller;

import com.google.gson.Gson;

import cliente.comunicacion.Receiver.OnMessageListener;
import cliente.comunicacion.TCPConnection;
import cliente.model.Juego;
import cliente.view.Chat;
import javafx.application.Platform;

public class ChatController implements OnMessageListener{
	
	public static final String NONE = "Broadcast";
	
	private boolean p=true;
	
	private Chat referencia;
	private Gson gson;
	
	
	private String selected;
	private Juego ju;
	private Juego ene;
	private String queSoy;
	
	private String realReceiver = NONE;
	public ChatController(Chat referencia) {
		this.referencia = referencia;
		gson = new Gson();
		initView();
	}

	@SuppressWarnings("unchecked")
	private void initView() {
		
		TCPConnection.getInstance().setMain(this);
		
		referencia.getStopB().setOnAction(
				(event)->{
					
					
					Juego ju= new Juego(referencia.getNombreT().getText(), referencia.getApellidoT().getText(), referencia.getLugarT().getText(), referencia.getAnimalT().getText(), referencia.getPuntaje().getText(), queSoy);
					TCPConnection.getInstance().sendMessage(gson.toJson(ju));
					p=false;
					
					referencia.getStop().setDisable(true);
				
				}
				);
	
//		referencia.getListado().setOnAction(
//				(event)->{
//					int intName = referencia.getListado().getSelectionModel().getSelectedIndex();
//					System.out.println(""+intName);
//					realReceiver = referencia.getItems().get(intName);
//				}
//				);
	
	
	}
	
	

	@Override
	public void onMessage(String msg) {
		Platform.runLater(
				()->{
					
					System.out.println("Mensaje recibido: "+ msg);
					
					if(msg.contains("--")&& referencia.getQueSoy().getText().length()!=2) {
						String[] a=msg.split("--");
						
						queSoy=a[0];
						referencia.getQueSoy().setText(queSoy);
					}
					
					
					if(msg.contains("@")) {
						String[] a=msg.split("@");
						char efe= (char) Integer.parseInt(a[0]);
						referencia.getLetra().setText(""+efe);
					}
					
					
					if(msg.equals("AHORA") && p==true) {
						Juego ju= new Juego(referencia.getNombreT().getText(), referencia.getApellidoT().getText(), referencia.getLugarT().getText(), referencia.getAnimalT().getText(), referencia.getPuntaje().getText(), queSoy);
						TCPConnection.getInstance().sendMessage(gson.toJson(ju));
						referencia.getStop().setDisable(true);
					}
					
					
					Gson g= new Gson();
					//System.out.println(msg);
					
					if(msg.contains("\"nombre\"") && msg.contains("\"apellido\"") &&msg.contains("\"lugar\"") && msg.contains("\"animal\"") && msg.contains("\"puntaje\"") && msg.contains("\"id\"")) {
//						System.out.println("ya desde el cliente");
						Juego ju= g.fromJson(msg.trim(), Juego.class);
						
						if(ju.getId().compareTo(queSoy)!=0) {
							ene=ju;
							
						}
						
						if(ene!=null) {
							if(ju.getId().equals(queSoy)) {
								System.out.println("tu puntaje es: "+ju.getPuntaje());
								String p= ""+ ju.getPuntaje();
								referencia.getPuntaje().setText(p);
								
								referencia.getNombredT().setText(ene.getNombre());
								System.out.println(ene.getNombre());
								referencia.getApellidodT().setText(ene.getApellido());
								referencia.getLugardT().setText(ene.getLugar());
								referencia.getAnimaldT().setText(ene.getAnimal());
								
								
								
								
							}
							
							
						}
						
							
						}
					
						
						
					
				}
				);	
	}


	
	
}