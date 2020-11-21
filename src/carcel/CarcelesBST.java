package carcel;

public class CarcelesBST {
	NodoCarcel root;
	
	public void addCarcel(Carcel nuevaCarcel) {
		if (root == null) {
			root = new NodoCarcel(nuevaCarcel);
			return;
		}
		
		addCarcel(root, nuevaCarcel);
		
	}
	private void addCarcel (NodoCarcel node, Carcel nuevaCarcel){
		if (node == null) {
			return;
		}
		if(nuevaCarcel.id == node.carcel.id) {
			System.out.println("La carcel ya se había agregado");
		}
		if(nuevaCarcel.id > node.carcel.id) {
			if(node.derecho == null) {
				node.derecho = new NodoCarcel(nuevaCarcel);
				
			}
			else {
				addCarcel(node.derecho, nuevaCarcel);
			}
		}
		else {
			if(node.izquierdo == null) {
				node.izquierdo = new NodoCarcel(nuevaCarcel);
			}
			else {
				addCarcel(node.izquierdo, nuevaCarcel);
			}
		}
	}
	
	public void verEdadDeSalidad(String id) {
		calcularEdadDeSalida(root, id);
	}
	
	private void calcularEdadDeSalida(NodoCarcel root, String id) {
		if (root == null) {
			return;
		} 
		for(Preso p : root.carcel.colaPresos){
			if(p.id.equals(id)) {
				int edadSalida = 0;
				edadSalida = p.tiempoCondena;
				edadSalida = edadSalida + p.edad;
				System.out.println("La edad de salida de " + p.nombre + " " + edadSalida);
				return;
			}	
		}
		if (root.derecho != null) {
			calcularEdadDeSalida(root.derecho,id);
		}
		if (root.izquierdo != null) {
			calcularEdadDeSalida(root.izquierdo,id);
		}
	}
	
	public void totalPagos() {
		float totalPagos = totalPagosCarcel(root);
		if(root != null) {
			for(Preso p : root.carcel.colaPresos){
				totalPagos += p.pagoFianza;
			}
		}
		System.out.println("El total de dinero recaudado es: " + totalPagos);
		}
		
	private float totalPagosCarcel(NodoCarcel nodo) {
		if(nodo == null) {
		return 0;
		}		
		float derecho = 0;
		if(nodo.derecho != null) {
			derecho =  totalPagosCarcel(nodo.derecho);
			for(Preso p : nodo.derecho.carcel.colaPresos){
				derecho += p.pagoFianza;
			}
		}
		float izquierdo = 0;
		if(nodo.izquierdo != null) {
			izquierdo =  totalPagosCarcel(nodo.izquierdo);
			for(Preso p : nodo.izquierdo.carcel.colaPresos){
				izquierdo += p.pagoFianza;
			}			
		}
		float totalPagos = derecho + izquierdo;
		return totalPagos;		
			
		}
	
	public void mostrarDatos() {
		if(root != null) {
			
			System.out.println("Carcel: " + root.carcel.id );
			for(Preso p : root.carcel.colaPresos){
				
				System.out.println(p.nombre);
				System.out.println(p.listDelitos);
			}
			float totalFianzasXPagar = root.carcel.calcularPagoCarcel();
			System.out.println("El total que deben pagar es: " + totalFianzasXPagar);
			 
			float promedioEdades = root.carcel.promedioEdades();
			System.out.println("El promedio de edades de los presos es: " + promedioEdades);
			
			root.carcel.calcularPresoMasDelitos();
			 
			String delitoMasComun = root.carcel.calcularDelitoMasComun();
			System.out.println("El delito más común es: " + delitoMasComun + "\n");
		}
		buscarDatos(root);
	}
	
	private void buscarDatos(NodoCarcel nodo) {
		
		if(nodo == null) {
			return;
		}
	
		
		if(nodo.derecho != null) {
			System.out.println("Carcel: " + nodo.derecho.carcel.id);
			
			for(Preso p : nodo.derecho.carcel.colaPresos){
				System.out.println(p.nombre);
				System.out.println(p.listDelitos);
			}
			float totalFianzasXPagar = nodo.derecho.carcel.calcularPagoCarcel();
			 System.out.println("El total que deben pagar es: " + totalFianzasXPagar);
			 
			 float promedioEdades = nodo.derecho.carcel.promedioEdades();
			 System.out.println("El promedio de edades de los presos es: " + promedioEdades);
			 
			 nodo.derecho.carcel.calcularPresoMasDelitos();
			 
			 String delitoMasComun = nodo.derecho.carcel.calcularDelitoMasComun();
			 System.out.println("El delito más común es: " + delitoMasComun + "\n");
			 buscarDatos(nodo.derecho);
			 
		}
		if(nodo.izquierdo != null) {
			System.out.println("Carcel: " + nodo.izquierdo.carcel.id);
			for(Preso p : nodo.izquierdo.carcel.colaPresos){
				
				System.out.println(p.nombre);
				System.out.println(p.listDelitos);
			}
			float totalFianzasXPagar = nodo.izquierdo.carcel.calcularPagoCarcel();
			 System.out.println("El total que deben pagar es: " + totalFianzasXPagar);
			 
			 float promedioEdades = nodo.izquierdo.carcel.promedioEdades();
			 System.out.println("El promedio de edades de los presos es: " + promedioEdades);
			 
			 nodo.izquierdo.carcel.calcularPresoMasDelitos();
			 
			 String delitoMasComun = nodo.izquierdo.carcel.calcularDelitoMasComun();
			 System.out.println("El delito más común es: " + delitoMasComun + "\n");
			 
		 buscarDatos(nodo.izquierdo);
		 
		}
	}
}
	
	
	
	

	

