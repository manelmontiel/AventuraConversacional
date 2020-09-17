import java.util.ArrayList;

public class NPC {

	private String nombre;
	private String descripcion;
	private Habitacion posicioNPC;
	private boolean soborno;
	private boolean vida;
	private ArrayList<Items> inventarioNPC = new ArrayList<Items>();
	
	public Items recorrerInventarioNPC(Items item) {			//mira que este item esta en el inventario del jugador
		for(int i = 0; i < inventarioNPC.size(); i++) {
			if(inventarioNPC.get(i) == null) {				//sino esta devuelve null
				return null;
			}
			else {
				return inventarioNPC.get(i);				//si esta devuelve el objeto
			}
		}
		
		 return null;
	}
	
	public void mostrarItemsNPC() {
		for(int i = 0; i < inventarioNPC.size(); i++) {		//recorre el arraylist del inventario del jugador
			System.out.println(inventarioNPC.get(i).getNombre());		//y muestra los objetos que hay en el
		}
		
	}
	public void setItemNPC(Items item) {		//añade el objeto entrado del arraylist del jugador
		inventarioNPC.add(item);
	}
	public void quitarItemNPC(Items item) {		//elimina el objeto entrado del arraylist del jugador
		inventarioNPC.remove(item);
	}
	
	public String getNombre() {		//getters y setters de las propiedades del NPC
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Habitacion getPosicioNPC() {
		return posicioNPC;
	}
	public void setPosicioNPC(Habitacion posicioNPC) {
		this.posicioNPC = posicioNPC;
	}
	public boolean getSoborno() {
		return soborno;
	}
	public void setSoborno(boolean soborno) {
		this.soborno = soborno;
	}
	public boolean getVida() {
		return vida;
	}
	public void setVida(boolean vida) {
		this.vida = vida;
	}
	
	

}
