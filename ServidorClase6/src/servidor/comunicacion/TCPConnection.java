package servidor.comunicacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


import servidor.comunicacion.Receiver.OnMessageListener;



public class TCPConnection {
	
	private static TCPConnection instance;
	private int noMore=0;

	private TCPConnection() {
		
		connections= new ArrayList<>();
		
	}
	
	public synchronized static TCPConnection getInstance() {
		if(instance == null) instance = new TCPConnection();
		return instance;
	}
	
	//Atributos de objeto
	
	private ServerSocket server;
	private int puerto;
	private String ip; 
	OnMessageListener main;
	private ArrayList<Connection> connections;  
	
	public void setMain(OnMessageListener main) {
		this.main = main;
		
	}
	
	public ArrayList<Connection> getConnections(){
		return connections;
	}
	
	public TCPConnection setIp(String ip) {
		this.ip = ip;
		return instance;
	}
	
	public TCPConnection setPuerto(int puerto) {
		this.puerto = puerto;
		return instance;
	}
	
	public void waitForConnection() {
		
		new Thread(
				()->{
					
					try {
						server = new ServerSocket(puerto);
						
						
						while(noMore<2) {
							System.out.println(noMore);
						System.out.println("Esperando conexi�n");
						Socket socket = server.accept();
						Connection c=  new Connection(socket);
						c.setObserver(main);
						System.out.println("Conexion aceptada");
						c.init();
						connections.add(c);
						noMore++;
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}
									
					
				}
				
				).start();
		

		
	}

	public void sendBroadcast(String line) {
		
		for(int i=0; i<connections.size(); i++) {	
			connections.get(i).sendMessage(line);
		}
		
	}

	public int getNoMore() {
		return noMore;
	}

	public void setNoMore(int noMore) {
		this.noMore = noMore;
	}
	
	
//	public ListaUsuarios usuariosConectados(){
//		
//		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//		for(int i = 0; i<connections.size(); i++) {
//			
//			usuarios.add(connections.get(i).getUser());
//		}
//		
//		ListaUsuarios lista = new ListaUsuarios ();
//		
//		lista.setUsuarios(usuarios);
//		
//		return lista;
//	}

//	public void sendDirect(String json, String usuario) {
//		
//		Connection busqueda = null;
//		for(int i = 0; i<connections.size(); i++) {
//			
//			if(connections.get(i).getUser().getNombre().equals(usuario)) {
//				
//				busqueda = connections.get(i);
//				break;
//			}
//		}
//		
//		if(busqueda == null) return;
//		
//		busqueda.sendMessage(json);
//		
//	}
//
//	public void identifyUser(Usuario u) {
//		
//		Connection c = connections.get(connections.size()-1);
//		c.setUser(u);
//	}
//	
	
	

	
	
}
