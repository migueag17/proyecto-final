package carcel;


public class NodoCarcel {
	public NodoCarcel(Carcel nuevaCarcel) {
		this.carcel = nuevaCarcel;
	}
	Carcel carcel;
	NodoCarcel izquierdo;
	NodoCarcel derecho;
}
