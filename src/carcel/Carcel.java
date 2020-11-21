package carcel;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Carcel {
	int id;
	
	public Carcel(int idCarcel) {
		this.id = idCarcel;
	}
	
	/*
	 * Prioridades de encarcelamiento:
	 * 9 (más alta) = delito tipo 3 asesinato
	 * 5 (intermedia) = delito tipo 2 secuestro 
	 * 1 (baja) = delito tipo 1. robo
	 */
	
	PriorityQueue<Preso> colaPresos = new PriorityQueue<Preso>();
	public void addPreso(Preso preso) {
		colaPresos.add(preso);
	}
	
	public float calcularPagoCarcel() {
		float totalDinero = 0;
		for(Preso preso : colaPresos) {
			totalDinero = totalDinero + preso.pagoFianza;
		}
		return totalDinero;
	}
	
	public float promedioEdades() {
		float promedio = 0;
		int contadorEstudiantes = 0;
		
		for(Preso preso : colaPresos) {
			promedio = promedio + preso.edad;
			contadorEstudiantes++;
		}
		
		promedio = promedio / contadorEstudiantes;
		
		return promedio;		
	}
	
	public String calcularDelitoMasComun() {
		Hashtable<String, Integer> HashDelitos = new Hashtable<String,Integer>(); 
		
		for(Preso preso : colaPresos) {
			for(String delito : preso.listDelitos) {
				int cant = 1;
				if(HashDelitos.containsKey(delito)) {
					cant = HashDelitos.get(delito);
					cant ++;
				}
				HashDelitos.put(delito, cant);
			}
			
		}
		int mayor = 0;
		String delitoMasComun = "";
		
		Enumeration<String> enumeration = HashDelitos.keys();
		while(enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			if(HashDelitos.get(key) > mayor) {
				mayor = HashDelitos.get(key);
				delitoMasComun = key;
			}	
		}
		return delitoMasComun;
	}	
	
	public void calcularPresoMasDelitos() {
	Hashtable<Preso, Integer> HashDelitos = new Hashtable<Preso,Integer>(); 
		
	for(Preso preso : colaPresos) {
		for(String delito : preso.listDelitos) {
			int cant = 1;
			if(HashDelitos.containsKey(preso)) {
				cant = HashDelitos.get(preso);
				cant ++;
			}
			HashDelitos.put(preso, cant);	
			}
		
			}
			int mayor = 0;
			Preso presoMasComun = null ;

			Enumeration<Preso> enumeration = HashDelitos.keys();
			while(enumeration.hasMoreElements()) {
				Preso key = enumeration.nextElement();
				if(HashDelitos.get(key) > mayor) {
					mayor = HashDelitos.get(key);
					presoMasComun = key;
				}		
			}	
			System.out.println("El preso con más delitos, es: " + presoMasComun.nombre);
		}
}
