import java.util.ArrayList;

public class Habitacion {

	private String nombre;
	private String descripcion;
	private int posicioHabitacion;
	private ArrayList<Items> inventarioZona = new ArrayList<Items>();		//arraylist que fa de inventari de cada habitacio
	private boolean luz;	//aun no se utiliza
	private boolean escaleraArriba;
	private boolean escaleraAbajo;
	private boolean puertaNorte;
	private boolean puertaSud;
	private boolean puertaEste;
	private boolean puertaOeste;
	private Habitacion tincNorte;
	private Habitacion tincSud;
	private Habitacion tincEste;
	private Habitacion tincOeste;
	private Habitacion tincArriba;
	private Habitacion tincAbajo;
	
	public Items recorrerInventarioHab(Items item) {		//mira que este item esta en la habitacion
		for(int i = 0; i < inventarioZona.size(); i++) {	
			if(inventarioZona.get(i) == null) {
				return null;								//si no esta devuelve null
			}
			else {
				return inventarioZona.get(i);				//si está, devuelve el item de la posicion i
			}
		}
		
		 return null;
	}
	
	public boolean tengoItems() {
		for(int i = 0; i < inventarioZona.size(); i++) {	
			if(inventarioZona.get(i) == null) {
											//si no esta devuelve null
			}
			else {
				return true;				//si está, devuelve el item de la posicion i
			}
		}
		
		 return false;
	}
	public void mostrarItems() {
		for(int i = 0; i < inventarioZona.size(); i++) {		//recorre el arraylist de habitacion
			System.out.println(inventarioZona.get(i).getNombre());	//y muestra el nombre de el o los items que hay en la habitacion
		}
		
	}
	public void setItemHab(Items item) {	//añade el item entrado a la arraylist inventarioZona
		inventarioZona.add(item);
	}
	public void quitarItemHab(Items item) {	//elimina el item entrado de la arraylist inventarioZona
		inventarioZona.remove(item);
	}

	public String getNombre() {		//getters y setters
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosicioHabitacion() {
		return posicioHabitacion;
	}

	public void setPosicioHabitacion(int posicioHabitacion) {
		this.posicioHabitacion = posicioHabitacion;
	}

	public boolean getLuz() {
		return luz;
	}

	public void setLuz(boolean luz) {
		this.luz = luz;
	}

	public boolean getEscaleraArriba() {
		return escaleraArriba;
	}

	public void setEscaleraArriba(boolean escaleraArriba) {
		this.escaleraArriba = escaleraArriba;
	}
	
	public boolean getEscaleraAbajo() {
		return escaleraAbajo;
	}

	public void setEscaleraAbajo(boolean escaleraAbajo) {
		this.escaleraAbajo = escaleraAbajo;
	}

	public boolean getPuertaNorte() {
		return puertaNorte;
	}

	public void setPuertaNorte(boolean puertaNorte) {
		this.puertaNorte = puertaNorte;
	}

	public boolean getPuertaSud() {
		return puertaSud;
	}

	public void setPuertaSud(boolean puertaSud) {
		this.puertaSud = puertaSud;
	}

	public boolean getPuertaEste() {
		return puertaEste;
	}

	public void setPuertaEste(boolean puertaEste) {
		this.puertaEste = puertaEste;
	}

	public boolean getPuertaOeste() {
		return puertaOeste;
	}

	public void setPuertaOeste(boolean puertaOeste) {
		this.puertaOeste = puertaOeste;
	}

	public Habitacion getTincNorte() {
		return tincNorte;
	}

	public void setTincNorte(Habitacion tincNorte) {
		this.tincNorte = tincNorte;
	}

	public Habitacion getTincSud() {
		return tincSud;
	}

	public void setTincSud(Habitacion tincSud) {
		this.tincSud = tincSud;
	}

	public Habitacion getTincEste() {
		return tincEste;
	}

	public void setTincEste(Habitacion tincEste) {
		this.tincEste = tincEste;
	}

	public Habitacion getTincOeste() {
		return tincOeste;
	}

	public void setTincOeste(Habitacion tincOeste) {
		this.tincOeste = tincOeste;
	}

	public Habitacion getTincArriba() {
		return tincArriba;
	}

	public void setTincArriba(Habitacion tincArriba) {
		this.tincArriba = tincArriba;
	}

	public Habitacion getTincAbajo() {
		return tincAbajo;
	}

	public void setTincAbajo(Habitacion tincAbajo) {
		this.tincAbajo = tincAbajo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
