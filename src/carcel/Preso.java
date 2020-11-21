package carcel;

import java.util.ArrayList;

import javax.print.attribute.HashDocAttributeSet;

public class Preso implements Comparable<Preso>{
	String id;
	String nombre;
	int edad;
	float pagoFianza;
	int tiempoCondena;
	ArrayList<String> listDelitos;
	int prioridad;
	
	public Preso(String idPreso, String nombrePreso, int edadPreso, float pagoFianzaPreso, int tiempoCondenaPreso, int prioridadPreso ) {
		this.id = idPreso;
		this.nombre = nombrePreso;
		this.edad = edadPreso;
		this.pagoFianza = pagoFianzaPreso;
		this.tiempoCondena = tiempoCondenaPreso;
		this.prioridad = prioridadPreso;
		listDelitos = new ArrayList<String>();
	}
	
	@Override	
	public int compareTo(Preso otroPreso) {
	
		return  otroPreso.prioridad - this.prioridad;
	}
}
	

