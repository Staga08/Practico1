package servidor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;

import model.Juego;
import servidor.comunicacion.Receiver.OnMessageListener;
import servidor.comunicacion.TCPConnection;

public class Main implements OnMessageListener{
	public final static String pl1="P1";
	public final static String pl2="P2";
	private Juego p1;
	private Juego p2;
	private int n=0;
	private boolean mandado=true;
	String adivina;
	private int player=2;
	
	public static void main(String[] args) {
		Main main = new Main();
	}
	
	public Main() {
		TCPConnection conexion = TCPConnection.getInstance().setPuerto(5000);
		conexion.setMain(this);
		conexion.waitForConnection();
	}

	@Override
	public void onMessage(String msg) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(player>0) {
			if(player==2) {
			TCPConnection.getInstance().sendBroadcast(pl1+"--");
			}else {
				TCPConnection.getInstance().sendBroadcast(pl2+"--");
			}
			player--;
			}
			
		
		
		if(mandado) {
			Random r= new Random();
			int a= r.nextInt((90-65)+ 1)+ 65;
			 adivina= a+"@" ;
			 mandado=false;
		}
		
		
	
		TCPConnection.getInstance().sendBroadcast(adivina);
		
		n+=1;
		//System.out.println(msg);
		
		
		Gson g = new Gson();
		
		if(msg.contains("\"nombre\"") && msg.contains("\"apellido\"") &&msg.contains("\"lugar\"") && msg.contains("\"animal\"") &&  msg.contains("\"puntaje\"") && msg.contains("\"id\"") ) {
			//TCPConnection.getInstance().sendBroadcast("AHORA");
			
			
			if(n>2 && n<4) {
				TCPConnection.getInstance().sendBroadcast("AHORA");
			}
			
			System.out.println(msg);
			Juego m =g.fromJson(msg, Juego.class);
			
			if(m.getId().equals("P1")) {
				p1=m;
			}else if(m.getId().equals("P2")){
				p2=m;
			}
			
			System.out.println(""+ m.getId());
			
			if(p1!=null && p2!=null) {
				
				System.out.println(p1.getId());
				System.out.println(p2.getId());

				String gg= ""+ evaluar(p1.getNombre(), p1.getApellido(), p1.getLugar(), p1.getAnimal(), p2.getNombre(), p2.getApellido(), p2.getLugar(), p2.getAnimal());
				
				
				p1.setPuntaje(gg);
				
				String g2= ""+ evaluar(p2.getNombre(), p2.getApellido(), p2.getLugar(), p2.getAnimal(), p1.getNombre(), p1.getApellido(), p1.getLugar(), p1.getAnimal());
				
				p2.setPuntaje(g2);
				
			}
			
			String msg1=g.toJson(p1);
			msg=g.toJson(p2);
			//System.out.println(msg);
			TCPConnection.getInstance().sendBroadcast(msg1);
			TCPConnection.getInstance().sendBroadcast(msg);
			
			TCPConnection.getInstance().sendBroadcast(msg);
			TCPConnection.getInstance().sendBroadcast(msg1);
			
			
		
		}
		
		
		
		
	}


	public int evaluar(String nombre, String apellido, String lugar, String animal, String nombred, String apellidod, String lugard, String animald) {
		int puntaje=0;
		if(nombre.equals("")) {
			puntaje+=0;
		}
		else {
			if(nombre.equalsIgnoreCase(nombred)) {
				puntaje+=50;
			}else {
				puntaje+=100;
			}
		}
		
		if(apellido.equals("")){
			puntaje+=0;
		}else {
			if(apellido.equalsIgnoreCase(apellidod)) {
				puntaje+=50;
			}else {
				puntaje+=100;
			}
			
		}
		
		if(lugar.equals("")) {
			puntaje+=0;
		}else {
			if(lugar.equalsIgnoreCase(lugard)) {
				puntaje+=50;
			}else {
				puntaje+=100;
			}
		}
		
		if(animal.equals("")) {
			puntaje+=0;
		}else {
			if(animal.equalsIgnoreCase(animald)) {
				puntaje+=50;
			}
			else {
				puntaje+=100;
			}
		}
		
		
		
		return puntaje;
	}







}
