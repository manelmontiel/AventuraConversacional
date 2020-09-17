import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

	private String nombre;
	private boolean vida;
	private Habitacion posicioJugador;	//habitacion
	private ArrayList<Items> inventarioJugador = new ArrayList<Items>();
	//private String nombrePosicioJugador;
	
	public Items recorrerInventarioJug(Items item) {			//mira que este item esta en el inventario del jugador
		for(int i = 0; i < inventarioJugador.size(); i++) {
			if(inventarioJugador.get(i) == null) {				//sino esta devuelve null
				return null;
			}
			else if(inventarioJugador.get(i) == item){
				return inventarioJugador.get(i);				//si esta devuelve el objeto
			}
		}
		
		 return null;
	}
	
	public void mostrarMochila() {
		for(int i = 0; i < inventarioJugador.size(); i++) {		//recorre el arraylist del inventario del jugador
			System.out.println(inventarioJugador.get(i).getNombre());		//y muestra los objetos que hay en el
		}
		
	}
	public void setItemJug(Items item) {		//añade el objeto entrado del arraylist del jugador
		inventarioJugador.add(item);
	}
	public void quitarItemJug(Items item) {		//elimina el objeto entrado del arraylist del jugador
		inventarioJugador.remove(item);
	}
										//getters y setters y metodos no programados aún
	/*public void utilizar() {			//seguramente no se utilice
		
	}*/
	
	/*public void sobornar() {			//seguramente no se utilice
		
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getVida() {
		return vida;
	}

	public void setVida(boolean vida) {
		this.vida = vida;
	}

	public Habitacion getPosicioJugador() {		
		return posicioJugador;
	}

	public void setPosicioJugador(Habitacion posicioJugador) {	
		this.posicioJugador = posicioJugador;
	}
	
	
}
