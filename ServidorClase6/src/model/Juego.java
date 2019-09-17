package model;

public class Juego {

	private String nombre;
	private String apellido;
	private String lugar;
	private String animal;
	private String puntaje;
	private String id;
	
	public Juego(String nombre, String apellido, String lugar, String animal, String puntaje,String id ) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.lugar=lugar;
		this.animal=animal;
		this.puntaje=puntaje;
		this.id=id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getAnimal() {
		return animal;
	}


	public void setAnimal(String animal) {
		this.animal = animal;
	}


	public String getPuntaje() {
		return puntaje;
	}


	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



}
