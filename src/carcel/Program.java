package carcel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Program {

		public static void main(String[] args) throws NumberFormatException, IOException {
		CarcelesBST car = new CarcelesBST();
		BufferedReader archivo = new BufferedReader(new FileReader("datos-car.txt"));
		int numCarceles = Integer.parseInt(archivo.readLine());
		System.out.println(numCarceles);
		for ( int i = 0; i<numCarceles; i++) {
			String datosCarcel[] = archivo.readLine().split(",");
			Carcel carcel = new Carcel(Integer.parseInt(datosCarcel[0]));	
			int numPresos = Integer.parseInt(archivo.readLine());
			for (int j = 0; j < numPresos; j++) {
				String datosPreso[] = archivo.readLine().split(",");
				Preso preso = new Preso((datosPreso[0]), datosPreso[1], Integer.parseInt(datosPreso[2]), Float.parseFloat(datosPreso[3]), Integer.parseInt(datosPreso[4]), Integer.parseInt(datosPreso[5]));
				int numDelitos = Integer.parseInt(datosPreso[6]);
				for ( int k = 0; k<numDelitos; k++) {
					String delito = archivo.readLine();
					preso.listDelitos.add(delito);
				}
				carcel.addPreso(preso);
			}
			car.addCarcel(carcel);
		}
		car.mostrarDatos();
		car.totalPagos();
		car.verEdadDeSalidad("3");
	}
}
				
		
		
		
//		CarcelesBST car = new CarcelesBST();
//	Carcel carcel = new Carcel();
//	 Preso p1 = new Preso();
//	 p1.id = "1";
//	 p1.nombre = "Preso 1";
//	 p1.pagoFianza = 200;
//	 p1.prioridad = 10;
//	 p1.listDelitos.add("robo");
//	 p1.listDelitos.add("secuestro");
//	 p1.listDelitos.add("violencia intrafamiliar");
//	 p1.edad = 22;
//	 p1.tiempoCondena = 30;
//	 carcel.addPreso(p1);
//	
//	 Preso p3 = new Preso();
//	 p3.id = "3";
//	 p3.nombre = "Preso 3";
//	 p3.listDelitos.add("secuestro");
//	 p3.listDelitos.add("robo");
//	 p3.prioridad = 5;
//	 p3.edad = 49;
//	 carcel.addPreso(p3);
//	 carcel.id = 1;
//	 car.addCarcel(carcel);
//	 
//	 Preso p2 = new Preso();
//	 p2.id = "2";
//	 p2.nombre = "Preso 2";
//	 p2.prioridad = 1;
//	 p2.pagoFianza = 200;
//	 p2.listDelitos.add("robo");
//	 p2.listDelitos.add("pelea");
//	 p2.edad = 37;
//	 carcel.addPreso(p2);
//	 
//	 
//	
//	 Carcel carcel2 = new Carcel();
//	 Preso p4 = new Preso();
//	 p4.id = "4";
//	 p4.nombre = "Preso 4";
//		 p4.pagoFianza = 120;
//		 p4.prioridad = 15;
//	
//		 p4.listDelitos.add("pelea");
//		 p4.listDelitos.add("violencia intrafamiliar");
//		 p4.edad = 60;
//		 carcel2.addPreso(p4);
//		
//		 Preso p5 = new Preso();
//		 p5.id = "5";
//		 p5.nombre = "Preso 5";
//		 p5.prioridad = 20;
//		 p5.pagoFianza = 200;
//		 p5.listDelitos.add("robo");
//		 p5.listDelitos.add("pelea");
//		 p5.listDelitos.add("violencia intrafamiliar");
//		 p5.edad = 56;
//		 carcel2.addPreso(p5);
//		 carcel2.id = 2;
//		 car.addCarcel(carcel2);
		 
	
	

