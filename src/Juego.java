import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
	private static Habitacion zones[] = new Habitacion[10];	//declaro les habitacions
	private Jugador jugador;	//declaro el jugador
	
	private Items escaleraPort = new Items();	//declaro els items
	private Items llave = new Items();
	private Items espada = new Items();
	private Items dinero = new Items();
	private Items nota1 = new Items();
	private Items nota2 = new Items();
	
	private NPC cocinera = new NPC();	//declaro els NPC
	private NPC jordiJor = new NPC();
	
	private boolean puertaArriba = false;	//declaro variable per saber si puc anar adalt en un moment determinat
	private boolean volverJugar = true;		//declaro variable per saber si vol tornar a jugar o no
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Juego programa = new Juego();
		programa.inici();
		
	}
	
	private void inici() {		//donde pongo todos los 
		crearMapa();
		crearJugador();
		crearNPC();
		crearItems();
		jugar();
	}
	
	private void crearMapa() {					//creamos el mapa, creamos la array zones que contiene las distintas habitaciones que componen el mapa
		zones[0] = new Habitacion();					//le damos un nombre a cada zona, y le decimos a que direccion se puede ir desde esta habitacion
			zones[0].setNombre("ALMACÉN");	//Almacén
			zones[0].setDescripcion("Parece el típico almacén. Unas cuantas estanterías en las paredes con objetos y alimentos en ellos.\n"
					+ "Varios objetos desperdigados por el suelo. Unas cuantas telarañas en las esquinas, incluso si te fijas un poco se pueden ver las arañas.");
			zones[0].setPuertaNorte(false);
			zones[0].setPuertaSud(true);
			zones[0].setPuertaEste(true);
			zones[0].setPuertaOeste(false);
			zones[0].setEscaleraArriba(false);
			zones[0].setEscaleraAbajo(false);
			zones[0].setLuz(randomLuz());
				
		zones[1] = new Habitacion();
			zones[1].setNombre("COCINA");	//Cocina
			zones[1].setDescripcion("Una habitación con una ventana al exterior. Una zona para hacer fuego y poder cocinar la comida.\n"
					+ "Unos cuantos instrumentos de cocina colgados de la pared y una gran mesa de madera en el centro que se usará también para cocinar.");
			zones[1].setPuertaNorte(false);
			zones[1].setPuertaSud(false);	
			zones[1].setPuertaEste(true);
			zones[1].setPuertaOeste(true);
			zones[1].setEscaleraArriba(false);
			zones[1].setEscaleraAbajo(false);
			zones[1].setLuz(randomLuz());
				
		zones[2] = new Habitacion();
			zones[2].setNombre("COMEDOR");	//Comedor
			zones[2].setDescripcion("Una gran sala con una mesa enorme rodeada de doce sillas y decorada con varios cubiertos y vajilla.\n"
					+ "Ventanas para que entre luz en la habitación.");
			zones[2].setPuertaNorte(false);
			zones[2].setPuertaSud(true);
			zones[2].setPuertaEste(false);
			zones[2].setPuertaOeste(true);
			zones[2].setEscaleraArriba(false);
			zones[2].setEscaleraAbajo(false);
			zones[2].setLuz(randomLuz());
				
		zones[3] = new Habitacion();
			zones[3].setNombre("LAVABO");	//Lavabo
			zones[3].setDescripcion("Una pequeña habitación, con una letrina para que el dueño y los empleados hagan sus necesidades.\n"
					+ "Una bañera donde el dueño se lava y un espejo donde no te puedes ver muy bién.");
			zones[3].setPuertaNorte(true);
			zones[3].setPuertaSud(true);
			zones[3].setPuertaEste(true);
			zones[3].setPuertaOeste(false);
			zones[3].setEscaleraArriba(false);
			zones[3].setEscaleraAbajo(false);
			zones[3].setLuz(randomLuz());
				
		zones[4] = new Habitacion();
			zones[4].setNombre("SALA MISTERIOSA");
			zones[4].setDescripcion("Una sala misteriosa donde solo se aprecia una puerta que parece que guarda una escalera.");
			zones[4].setPuertaNorte(false);	
			zones[4].setPuertaSud(true);
			zones[4].setPuertaEste(true);
			zones[4].setPuertaOeste(true);
			zones[4].setEscaleraArriba(false);	//es false perque més tard serà true
			zones[4].setEscaleraAbajo(false);
			zones[4].setLuz(randomLuz());
				
		zones[5] = new Habitacion();
			zones[5].setNombre("SALA DE LA CHIMENEA");	//Sala de la chimenea
			zones[5].setDescripcion("Una habitación hogareña con una chimena en el centro de la pared. En este momento parece estar apagada.\n"
					+ "Encima de la chimenea hay exhibiendose una hermosa espada colgada de la pared. Podría ser útil.");
			zones[5].setPuertaNorte(true);
			zones[5].setPuertaSud(true);
			zones[5].setPuertaEste(false);
			zones[5].setPuertaOeste(true);
			zones[5].setEscaleraArriba(false);
			zones[5].setEscaleraAbajo(false);
			zones[5].setLuz(randomLuz());
				
		zones[6] = new Habitacion();
			zones[6].setNombre("ESTABLO");	//Establo
			zones[6].setDescripcion("Un gran establecimiento lleno de caballos, eno y otras cosas. De hecho huele un poco mal.");
			zones[6].setPuertaNorte(true);
			zones[6].setPuertaSud(false);
			zones[6].setPuertaEste(false);	//true
			zones[6].setPuertaOeste(false);
			zones[6].setEscaleraArriba(false);
			zones[6].setEscaleraAbajo(false);
			zones[6].setLuz(randomLuz());
				
		zones[7] = new Habitacion();
			zones[7].setNombre("ENTRADA PRINCIPAL");	//Entrada Principal
			zones[7].setDescripcion("Zona de bienvenida a los invitados y huéspedes de la casa.\n"
					+ "Tiene algún que otro mueble y un cuadro colgado en una pared.");
			zones[7].setPuertaNorte(true);
			zones[7].setPuertaSud(false);
			zones[7].setPuertaEste(false);	
			zones[7].setPuertaOeste(false);	
			zones[7].setEscaleraArriba(false);
			zones[7].setEscaleraAbajo(false);
			zones[7].setLuz(true);
				
		zones[8] = new Habitacion();
			zones[8].setNombre("SALA DE BAILE Y RECEPCIONES");	//Sala de baile y recepciones
			zones[8].setDescripcion("Una gran sala ancha hecha para permitir un gran número de personas.\n"
					+ "Tiene un enorme espacio para bailes y fiestas.");
			zones[8].setPuertaNorte(true);
			zones[8].setPuertaSud(false);
			zones[8].setPuertaEste(false);
			zones[8].setPuertaOeste(false);	
			zones[8].setEscaleraArriba(false);
			zones[8].setEscaleraAbajo(false);
			zones[8].setLuz(randomLuz());
				
		zones[9] = new Habitacion();
			zones[9].setNombre("DORMITORIO PRINCIPAL");
			zones[9].setDescripcion("La habitación principal de la casa y dormitorio de JordiJor, el dueño.\n"
					+ "Hay una gran cama donde cabrian 4 personas y una terraza que da a la calle.");
			zones[9].setPuertaNorte(false);
			zones[9].setPuertaSud(false);
			zones[9].setPuertaEste(false);
			zones[9].setPuertaOeste(false);
			zones[9].setEscaleraArriba(false);
			zones[9].setEscaleraAbajo(true);
			zones[9].setLuz(true);
				
				//-----------------------------
				zones[0].setTincNorte(null);			//decimos a donde va a ir segun la posicion que elija (si es que puede ir)
				zones[0].setTincSud(zones[3]);
				zones[0].setTincEste(zones[1]);
				zones[0].setTincOeste(null);
				zones[0].setTincAbajo(null);
				zones[0].setTincArriba(null);
				
				zones[1].setTincNorte(null);
				zones[1].setTincSud(null);
				zones[1].setTincEste(zones[2]);
				zones[1].setTincOeste(zones[0]);
				zones[1].setTincAbajo(null);
				zones[1].setTincArriba(null);
				
				zones[2].setTincNorte(null);
				zones[2].setTincSud(zones[5]);
				zones[2].setTincEste(null);
				zones[2].setTincOeste(zones[1]);
				zones[2].setTincAbajo(null);
				zones[2].setTincArriba(null);
				
				zones[3].setTincNorte(zones[0]);
				zones[3].setTincSud(zones[6]);
				zones[3].setTincEste(zones[4]);
				zones[3].setTincOeste(null);
				zones[3].setTincAbajo(null);
				zones[3].setTincArriba(null);
				
				zones[4].setTincNorte(null);
				zones[4].setTincSud(zones[7]);
				zones[4].setTincEste(zones[5]);
				zones[4].setTincOeste(zones[3]);
				zones[4].setTincAbajo(null);
				zones[4].setTincArriba(zones[9]);
				
				zones[5].setTincNorte(zones[2]);
				zones[5].setTincSud(zones[8]);
				zones[5].setTincEste(null);
				zones[5].setTincOeste(zones[4]);
				zones[5].setTincAbajo(null);
				zones[5].setTincArriba(null);
				
				zones[6].setTincNorte(zones[3]);
				zones[6].setTincSud(null);
				zones[6].setTincEste(null);
				zones[6].setTincOeste(null);
				zones[6].setTincAbajo(null);
				zones[6].setTincArriba(null);
				
				zones[7].setTincNorte(zones[4]);
				zones[7].setTincSud(null);
				zones[7].setTincEste(null);
				zones[7].setTincOeste(null);
				zones[7].setTincAbajo(null);
				zones[7].setTincArriba(null);
				
				zones[8].setTincNorte(zones[5]);
				zones[8].setTincSud(null);
				zones[8].setTincEste(null);
				zones[8].setTincOeste(null); 	
				zones[8].setTincAbajo(null);
				zones[8].setTincArriba(null);
				
				zones[9].setTincNorte(null);
				zones[9].setTincSud(null);
				zones[9].setTincEste(null);
				zones[9].setTincOeste(null);
				zones[9].setTincAbajo(zones[4]);
				zones[9].setTincArriba(null);
				
	}
	
	//Mira te comento: que quieres puño o mano abierta
	
	private void crearJugador() {		//creo e instancio al jugador principal
		jugador = new Jugador();
		jugador.setNombre("CarloBon");
		jugador.setVida(true);
	}
	
	private void crearItems() {		//creo e instancio los items (por terminar)
		int NumRandom = randomItems();	//llamo al metodo randomItems que crea un numero random entre el 0 i el 8 y lo guardo en una variable
			
			escaleraPort.setNombre("Escalera");
			escaleraPort.setDescripcion("Una escalera portátil que te puede ayudar a llegar a sitios elevados.");
			zones[NumRandom].setItemHab(escaleraPort);			//la variable NumRandom antes asignada la pongo para definir en que zona se pone el objeto
																//es un numero que equivale a que zona va
			NumRandom = randomItems();							//vuelvo a repetir el proceso por cada objeto
			
			llave.setNombre("Llave");
			llave.setDescripcion("Esta llave puede abrir algunas puertas.");
			zones[NumRandom].setItemHab(llave);
		
			NumRandom = randomItems();
			
			espada.setNombre("Espada");
			espada.setDescripcion("Esta espada puede atravessar según que personas.");
			zones[NumRandom].setItemHab(espada);
		
			NumRandom = randomItems();
			
			dinero.setNombre("Dinero");
			dinero.setDescripcion("Este preciado elemento te puede servir para intercambiarlo por información.");
			zones[NumRandom].setItemHab(dinero);
		
			NumRandom = randomItems();
			
			nota1.setNombre("Nota1");
			nota1.setDescripcion("Hay objetos por el castillo que puedes coger y llevarte contigo.");
			zones[NumRandom].setItemHab(nota1);
		
			NumRandom = randomItems();
			
			nota2.setNombre("Nota2");
			nota2.setDescripcion("Hay objetos valiosos que se pueden intercambiar por información muy preciada.");
			zones[NumRandom].setItemHab(nota2);
	}
	
	private void crearNPC() {
		cocinera.setNombre("Cocinera");		//simplemente de los objetos tipo NPC creados antes, les asigno valores a sus propiedades
		cocinera.setDescripcion("La persona encargada de las comidas en la casa");
		cocinera.setPosicioNPC(zones[1]);
		cocinera.setSoborno(false);
		cocinera.setVida(true);
		
		jordiJor.setNombre("JordiJor");
		jordiJor.setDescripcion("El actual dueño de la casa y tu objetivo."); 	//hacer boolean mostrar, debajo de mostrar el nombre poner un if con el boolean y mostrar la descripcion
		jordiJor.setPosicioNPC(zones[9]);
		jordiJor.setSoborno(false); 
		jordiJor.setVida(true);
	}
	
	public void jugar() {	//metodo que sirve	para jugar
		Scanner teclat = new Scanner (System.in);
		
		historia();									//llame al metodo historia() que imprime en pantalla la historia inicial del juego
		
		while(volverJugar == true) {
		jugador.setPosicioJugador(zones[7]);		//el jugador empieza en la habitacion correspondiente con zones[7]
		
		System.out.println(jugador.getPosicioJugador().getNombre());	//enseño el nombre de la habitacion inicial y la descripcion
		System.out.println();
		System.out.println(jugador.getPosicioJugador().getDescripcion());
		System.out.println();
		
		while(jordiJor.getVida()==true) {				//el juego acaba cuando jordijor muere
		System.out.println("Introduce que quiere hacer.");
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("Mover Norte - Mover Sud - Mover Este - Mover Oeste - Mover Arriba - Mover Abajo");
		System.out.println("Endencer Luz - Apagar Luz");
		System.out.println("Coger escalera - Coger espada - Coger llave - Coger dinero - Coger nota1 - Coger nota2");
		System.out.println("Soltar escalera - Soltar espada - Soltar llave - Soltar dinero - Soltar nota1 - Soltar nota2");
		System.out.println("Ver mochila - Ver nota1 - Ver nota2");
		System.out.println("Abrir puerta");
		System.out.println("Hablar Cocinera - Hablar JordiJor");
		System.out.println("Sobornar Cocinera");
		System.out.println("Matar JordiJor");
		System.out.println("------------------------------------------------------------------------------------------------");
		String movimiento = teclat.nextLine().toLowerCase();	//le pido las ordenes al usuario
		
		String[] palabras = movimiento.split("\\s+");		//las guardo en un array y le digo que me lo separe por donde haya espacios
		System.out.println();
		
		if(palabras.length == 2) {							//le digo que si el array donde guardo la orden del usuario es igual a 2 posiciones, entra en el bucle, sino no
		switch(palabras[0]) {								//palabras[0] es la primera posicion del array, la primera palabra
		case "mover":
			switch(palabras[1]) {							//y palabras[1] es la segunda posicion del array, la segunda palabra
			case "norte":
				if(jugador.getPosicioJugador().getPuertaNorte()==true) {		//si donde esta el jugador se puede ir al norte
					jugador.setPosicioJugador(jugador.getPosicioJugador().getTincNorte());		//cambia la posicion del jugador a la casilla del norte
					if(jugador.getPosicioJugador().getLuz() == false) {							//miro si la luz de la habitacion esta apagada, si lo esta solo muestra interrogantes
						System.out.println("????????\n");
					}
					else {																		//si la luz esta encendida, muestra toda la informacion de la sala
						System.out.println(jugador.getPosicioJugador().getNombre()+"\n");		//muestra el nombre
						if(jugador.getPosicioJugador().getNombre().equals("SALA MISTERIOSA") && cocinera.getSoborno()==false) {		//aqui le digo que si la habitacion es SALA MISTERIOSA y el soborno es false, que no muestre nada
							System.out.println();
						}else {																										//en caso contrario muestra la descripcion de la sala
						System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
						}
						System.out.println("Items habitacion: ");
						jugador.getPosicioJugador().mostrarItems();		//Muestra los items que hay en la habitacion
						System.out.println("");
						System.out.println("Personas en la habitacion:");				//muestras las personas que hay en la sala, si las hay
						if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {
							System.out.println(cocinera.getNombre());
						}
						else if(jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {

							System.out.println(jordiJor.getNombre());
						}
						
						else {
							System.out.println("Aqui no hay nadie.\n");			//si no hay nadie, se lo digo al usuario
						}
					}
				}
				else{
					System.out.println("No es posible ir al norte.");
					System.out.println();
				}
				break;
			case "sud":
				if(jugador.getPosicioJugador().getPuertaSud()==true) {		//si donde esta el jugador se puede ir al sud
					jugador.setPosicioJugador(jugador.getPosicioJugador().getTincSud());		//cambia la posicion del jugador a la casilla del sud
					if(jugador.getPosicioJugador().getLuz() == false) {
						System.out.println("????????\n");
					}
					else {
						System.out.println(jugador.getPosicioJugador().getNombre() + "\n");
						if(jugador.getPosicioJugador().getNombre().equals("SALA MISTERIOSA") && cocinera.getSoborno()==false) {
							System.out.println();
						}else {
						System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
						}
						System.out.println("Items habitacion: ");
						jugador.getPosicioJugador().mostrarItems();
						System.out.println();
						System.out.println("Personas en la habitacion:");
						if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {
							System.out.println(cocinera.getNombre());
						}
						else if(jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {

							System.out.println(jordiJor.getNombre());
						}
						
						else {
							System.out.println("Aqui no hay nadie.\n");
						}
					}
				}
				else{
					System.out.println("No es posible ir al sud.");
					System.out.println();
				}
				break;
			case "este":
				if(jugador.getPosicioJugador().getPuertaEste()==true) {		//si donde esta el jugador se puede ir al este
					jugador.setPosicioJugador(jugador.getPosicioJugador().getTincEste());		//cambia la posicion del jugador a la casilla del este
					if(jugador.getPosicioJugador().getLuz() == false) {
						System.out.println("????????\n");
					}
					else {
						System.out.println(jugador.getPosicioJugador().getNombre() + "\n");
						if(jugador.getPosicioJugador().getNombre().equals("SALA MISTERIOSA") && cocinera.getSoborno()==false) {
							System.out.println();
						}else {
						System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
						}
						System.out.println("Items habitacion: ");
						jugador.getPosicioJugador().mostrarItems();
						System.out.println();
						System.out.println("Personas en la habitacion:");
						if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {
							System.out.println(cocinera.getNombre());
						}
						else if(jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {

							System.out.println(jordiJor.getNombre());
						}
						
						else {
							System.out.println("Aqui no hay nadie.\n");
						}
					}
				}
				else{
					System.out.println("No es posible ir al este.");
					System.out.println();
				}
				break;
			case "oeste":
				if(jugador.getPosicioJugador().getPuertaOeste()==true) {		//si donde esta el jugador se puede ir al oeste
					jugador.setPosicioJugador(jugador.getPosicioJugador().getTincOeste());		//cambia la posicion del jugador a la casilla del oeste
					if(jugador.getPosicioJugador().getLuz() == false) {
						System.out.println("????????\n");
					}
					else {
						System.out.println(jugador.getPosicioJugador().getNombre() + "\n");
						if(jugador.getPosicioJugador().getNombre().equals("SALA MISTERIOSA") && cocinera.getSoborno()==false) {
							System.out.println();
						}else {
						System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
						}
						System.out.println("Items habitacion: ");
						jugador.getPosicioJugador().mostrarItems();
						System.out.println();
						System.out.println("Personas en la habitacion:");
						if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {
							System.out.println(cocinera.getNombre());
						}
						else if(jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {

							System.out.println(jordiJor.getNombre());
						}
						
						else {
							System.out.println("Aqui no hay nadie.\n");
						}
					}
				}
				else{
					System.out.println("No es posible ir al oeste.");
					System.out.println();
				}
				break;
			case "arriba":
				if(jugador.getPosicioJugador().getEscaleraArriba()==true) {		//si donde esta el jugador se puede ir arriba
					if(puertaArriba == true) {									//y si puertaArriba es true entonces se mueve
						jugador.setPosicioJugador(jugador.getPosicioJugador().getTincArriba());		//cambia la posicion del jugador a la casilla de arriba
						System.out.println(jugador.getPosicioJugador().getNombre()+"\n");
						System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
						System.out.println("Items habitacion: ");
						jugador.getPosicioJugador().mostrarItems();
						System.out.println();
							System.out.println("Personas en la habitacion:");
							System.out.println(jordiJor.getNombre());
					}
					else {
						System.out.println("Para poder ir arriba primero necesitas abrir la puerta");		//si la puerta es false no se mueve y le muestro un mensaje
					}
				}
				else{
					System.out.println("No es posible ir arriba.");
					System.out.println();
				}
				break;
			case "abajo":
				if(jugador.getPosicioJugador().getEscaleraAbajo()==true) {		//si donde esta el jugador se puede ir abajo
					jugador.setPosicioJugador(jugador.getPosicioJugador().getTincAbajo());		//cambia la posicion del jugador a la casilla de abajo
					if(jugador.getPosicioJugador().getLuz() == false) {
						System.out.println("????????\n");
					}
					else {
						System.out.println(jugador.getPosicioJugador().getNombre() + "\n");
						if(jugador.getPosicioJugador().getNombre().equals("SALA MISTERIOSA") && cocinera.getSoborno()==false) {
							System.out.println();
						}else {
						System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
						}
						System.out.println("Items habitacion: ");
						jugador.getPosicioJugador().mostrarItems();
						System.out.println();
						System.out.println("Personas en la habitacion:");
						if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {
							System.out.println(cocinera.getNombre());
						}
						else if(jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {

							System.out.println(jordiJor.getNombre());
						}
						
						else {
							System.out.println("Aqui no hay nadie.\n");
						}
					}
				}
				else{
					System.out.println("No es posible ir abajo.");
					System.out.println();
				}
				break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}
		break;
		case "ver":
			switch(palabras[1]) {
			case "mochila":
				System.out.println("En tu mochila hay:");
				jugador.mostrarMochila();		//este metodo lo que hace es mostrar el contenido del arraylist que hace de mochila del jugador
				System.out.println();
			break;
			case "nota1":
				if(jugador.recorrerInventarioJug(nota1) != null) {
					System.out.println(nota1.getDescripcion() + "\n");		//muestra la descripcion (contenido) de nota1
				}
				else {
					System.out.println("Para leer la nota primero tendrás que tenerla en tu poder!\n");
				}
			break;
			case "nota2":
				if(jugador.recorrerInventarioJug(nota2) != null) {
					System.out.println(nota2.getDescripcion() + "\n");		//muestra la descripcion (contenido) de nota2
				}		
				else {
					System.out.println("Para leer la nota primero tendrás que tenerla en tu poder!\n");
				}
			break;
			case "habitacion":		//para ver el contenido de la habitacion
				if(jugador.getPosicioJugador().getLuz() == false) {		//si la luz esta apagado muestra interrogantes
					System.out.println("????????\n");
				}
				else {																				//si esta encendida muestra todo el contenido de la habitacion
					System.out.println(jugador.getPosicioJugador().getNombre()+"\n");
					if(jugador.getPosicioJugador().getNombre().equals("SALA MISTERIOSA") && cocinera.getSoborno()==false) {
						System.out.println();
					}else {
					System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
					}
					System.out.println("Items habitacion: ");
					jugador.getPosicioJugador().mostrarItems();		//Muestra los items que hay en la habitacion
					System.out.println("");
					System.out.println("Personas en la habitacion:");
					if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {
						System.out.println(cocinera.getNombre());
					}
					else if(jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {

						System.out.println(jordiJor.getNombre());
					}
					
					else {
						System.out.println("Aqui no hay nadie.\n");
					}
				}
			break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}
		break;
		case "coger":
			switch(palabras[1]) {
			case "escalera":
				cogerItem(escaleraPort);		//llamo al metodo cogerItem con cada uno de los items depende del case
			break;
			case "llave":
				cogerLlave();
			break;
			case "espada":
				cogerItem(espada);
			break;			
			case "dinero":
				cogerItem(dinero);
			break;			
			case "nota1":
				cogerItem(nota1);
			break;			
			case "nota2":
				cogerItem(nota2);
			break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}
		break;
		case "soltar":
			switch(palabras[1]) {
			case "escalera":			
				soltarItem(escaleraPort);		//llamo al metodo soltarItem con cada uno de los items depende del case
			break;			
			case "llave":
				soltarItem(llave);
			break;			
			case "espada":
				soltarItem(espada);
			break;		
			case "dinero":
				soltarItem(dinero);
			break;			
			case "nota1":
				soltarItem(nota1);
			break;			
			case "nota2":
				soltarItem(nota2);
			break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}
		break;
		case "encender":
			switch(palabras[1]) {
			case "luz":										//al encender la luz, luz pasa a ser true y se muestra todo lo de la habitacion
				jugador.getPosicioJugador().setLuz(true);
				System.out.println(jugador.getPosicioJugador().getNombre()+"\n");
				if(jugador.getPosicioJugador().getNombre().equals("SALA MISTERIOSA") && cocinera.getSoborno()==false) {
					System.out.println();
				}else {
				System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
				}
				System.out.println("Items habitacion: ");
				jugador.getPosicioJugador().mostrarItems();		//Muestra los items que hay en la habitacion
				System.out.println("Personas en la habitacion:");
				if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {
					System.out.println(cocinera.getNombre());
					System.out.println();
				}
				else if(jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {
					System.out.println(jordiJor.getNombre());
					System.out.println();
				}
				
				else {
					System.out.println("Aqui no hay nadie.\n");
				}
			break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}
		break;
		case "apagar":												//luz pasa a ser false y no muestra el contenido de la habitacion
			switch(palabras[1]) {
			case "luz":
				jugador.getPosicioJugador().setLuz(false);
			break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}
		break;
		case "hablar":
			switch(palabras[1]) {
			case "cocinera":												//en el caso de hablar con la cocinera
				if(jugador.getPosicioJugador().getLuz() == false) {			//si la luz esta apagada digo al usuario que la encienda antes
					System.out.println("Primero debería encender la luz porque no veo un cagao.\n");
				}else {
					if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {	//si la cocinera esta en la misma habitacion que e jugador, muestra el dialogo
						if(cocinera.getSoborno() == false) {						//si soborno es igual a false muestra un dialogo
							System.out.println("Cocinera:");
							System.out.println("Muy buenas buen señor.");
							System.out.println("Sabe usted que me conozco esta casa como si me hubiese criado aquí?");
							System.out.println("Sabría decirle donde esta cada cosa en esta casa si me preguntara.");
							System.out.println("Pero claro, la información no es gratis.");
							System.out.println();
						}else {														//si soborno es igual a true muestra otro dialogo
							System.out.println("Cocinera:");
							System.out.println("Oohh!! Esta bolsa de dinero justifica con creces cualquier información que pueda dar.");
							System.out.println("Que quiere saber donde está la entrada a la habitación de JordiJor??");
							System.out.println("Muy fácil!! Podrás acceder a su habitación a través de una escalera en Sala Misteriosa.");
							System.out.println("Pero tendrás que atravesar una puerta que siempre está cerrada con llave.");
							System.out.println();
							zones[4].setEscaleraArriba(true);						//si hablas con la cocinera una vez sobornada, entonces puedes ir arriba donde se encuentra la escalera
						}
					}
					else {
						System.out.println("No puedes hablar con alguien si no está presente.\n");
					}
				}
			break;
			case "jordijor":
				if((jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) && (jugador.recorrerInventarioJug(espada) == espada)) {	//si jugador y jordijor estan en la misma habitacion y el jugador tiene la espada, muestra un dialogo
					System.out.println("JordiJor:");
					System.out.println("Ehh!! Quien es usted!! Fuera de aquí!! Y deje esa espada que va a hacerse daño.\n");
				}else if((jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) && (jugador.recorrerInventarioJug(espada) == null)) {	//si jugador y jordijor estan en la misma habitacion y el jugador no tiene la espada, muestra un dialogo
					System.out.println("JordiJor");
					System.out.println("Usted señor!! Vayase o llamaré a los guardias!!\n");
				}else {																					//si no estan en la misma habitacion se lo digo
					System.out.println("No puedes hablar con alguien si no está presente.\n");
				}
			break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}
		break;
		case "sobornar":
			switch(palabras[1]) {
			case "cocinera":
				if (jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {			//si jugador y cocinera estan en la misma habitacion
					sobornar();															//llamo al metodo sobornar()
				}else {																	//sino le enseño en pantalla que no puede sobornarla
					System.out.println("No puedes sobornar ha alguien que no está contigo.\n");
				}
			break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}		
		break;
		case "matar":
			switch(palabras[1]) {
			case "jordijor":																										//si quiere matar a jordijor
				if((jugador.recorrerInventarioJug(espada) == espada) && jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {	//miro si estan en la misma zona y si el jugador tiene la espada
					jordiJor.setVida(false);	//la vida de jordijor pasa a ser false
					System.out.println("Felicidades caballero!! Ha llevado a cabo su venganza!!");
				}else if ((jugador.recorrerInventarioJug(espada) == espada) && jugador.getPosicioJugador() != jordiJor.getPosicioNPC()){	//si tiene la espada pero no esta en la misma habitacion, aviso al usuario
					System.out.println("No puedes matar a JordiJor desde aquí.");
				}else if((jugador.recorrerInventarioJug(espada) == null)) {								//sino tiene la espada los aviso tambien
					System.out.println("Has de tener la espada para matarlo!!!");
				}
			break;
			default:
				System.out.println("No se reconoce la orden.");
				System.out.println(" ");
			}
			
		break;
		case "abrir":
			switch(palabras[1]) {
			case "puerta":																							//si quiero abrir la puerta
				if((jugador.recorrerInventarioJug(llave) == llave) && (zones[4].getEscaleraArriba() == true)) {		//miro si tiene la llave y si puede ir arriba en la zona donde se puede (aqui interviene si has sobornado a la cocinera o no)
					puertaArriba = true;																			//si puede puertaArriba pasa a ser true y puede pasar
					System.out.println("Has abierto la puerta que te da acceso a la habitación de JordiJor.");
					System.out.println("Más te vale estar bién equipado, no se sabe lo que puede pasar.\n");
				}
				else {
					System.out.println("Lo que está intentando hacer no se puede realizar aquí.\n");
				}
			}
		break;
		default:
			System.out.println("No se reconoce la orden.");
			System.out.println(" ");
		}
		
	}
		else {
			System.out.println("Introduzca solo dos palabras.\n");				//por si ha introducido mas o menos de 2 palabras, vuelve a mostrar la info de la habitacion y a preguntar que quiere hacer
			if(jugador.getPosicioJugador().getLuz() == false) {
				System.out.println("????????\n");
			}
			else {
				System.out.println(jugador.getPosicioJugador().getNombre()+"\n");
				if(jugador.getPosicioJugador().getNombre().equals("SALA MISTERIOSA") && cocinera.getSoborno()==false) {
					System.out.println();
				}else {
				System.out.println(jugador.getPosicioJugador().getDescripcion()+"\n");
				}
				System.out.println("Items habitacion: ");
				jugador.getPosicioJugador().mostrarItems();		//Muestra los items que hay en la habitacion
				System.out.println("");
				System.out.println("Personas en la habitacion:");
				if(jugador.getPosicioJugador() == cocinera.getPosicioNPC()) {
					System.out.println(cocinera.getNombre());
				}
				else if(jugador.getPosicioJugador() == jordiJor.getPosicioNPC()) {

					System.out.println(jordiJor.getNombre());
				}
				
				else {
					System.out.println("Aqui no hay nadie.\n");
				}
			}
		}
	}
		finJuego();		//si ha matado a jordijor sale del bucle y entra en el metodo finJuego()

	}
	}
	
	public void cogerItem(Items item) {
		if(jugador.getPosicioJugador().getLuz() == false) {
			System.out.println("Primero debería encender la luz porque no veo un cagao.\n");
		}else {
			if(jugador.getPosicioJugador().recorrerInventarioHab(item) == item) {	//mira en la posicion del jugador, miro si en la habitacion donde esta el jugador esta el item entrado con parametros
				jugador.getPosicioJugador().quitarItemHab(item);					//si esta, lo elimino de la arraylist de la habitacion
				jugador.setItemJug(item);											//y lo introduzco en el arraylist del jugador
				System.out.println("Has recogido: " + item.getNombre());			//le digo al jugador que ha recogido ese item
			}
			else {																	//sino se puede coger porque no esta el objeto en la habitacion
				System.out.println("Este objeto no se encuentra aquí.");			//se lo digo por pantalla al usuario
			}
		}
	}
	
	public void cogerLlave() {				//es como coger pero para la llave
		if(jugador.getPosicioJugador().getLuz() == false) {
			System.out.println("Primero debería encender la luz porque no veo un cagao.\n");
		}else {
			if((jugador.getPosicioJugador().recorrerInventarioHab(llave) == llave)&&(jugador.recorrerInventarioJug(escaleraPort) == null)) {	//si no tiene la escalera en el inventario no puede coger la llave y se lo muestro al usuario
				System.out.println("Pacere ser que la llave está en un sitio alto y es inaccesible para mi a no ser que me ayude de algo.");
				System.out.println("Si tan siquiera tuviese un objeto que me ayudase a llegar más arriba, como por ejemplo una escalera...\n");
			}
			else if(jugador.getPosicioJugador().recorrerInventarioHab(llave) != null) {			//si tiene la escalera coge la llave
				jugador.getPosicioJugador().quitarItemHab(llave);					
				jugador.setItemJug(llave);											
				System.out.println("Has recogido: " + llave.getNombre());	
				System.out.println();
			}
			else {
				System.out.println("Este objeto no se encuentra aquí.");
			}
		}
	}
	
	public void soltarItem(Items item) {
		if(jugador.recorrerInventarioJug(item) != null) {						//mira en la posicion del jugador, miro si en la mochila del jugador esta el item entrado con parametros
			jugador.quitarItemJug(item);										//si esta, lo elimino de la arraylist del jugador
			jugador.getPosicioJugador().setItemHab(item);						//y lo introduzco en el arraylist de la habitacion
			System.out.println("Has soltado: " + item.getNombre());				//le digo al jugador que ha soltado ese item
			
		}
		else {																	//si el objeto entrado por parametros no esta en la mochila del jugador, no es posible soltarlo
			System.out.println("No tienes este objeto.");						//y se lo digo por pantalla al jugador
		}
			
	}
	
	public void sobornar() {
		if(jugador.getPosicioJugador().getLuz() == false) {
			System.out.println("Primero debería encender la luz porque no veo un cagao.\n");
		}else {
			if((jugador.recorrerInventarioJug(dinero) == dinero)) {						//mira en la posicion del jugador, miro si en la mochila del jugador esta el item dinero
				jugador.quitarItemJug(dinero);										//si esta, lo elimino de la arraylist del jugador
				cocinera.setItemNPC(dinero);										//y lo pongo en el del npc cocinera
				cocinera.setSoborno(true);											//y soborno pasa a ser true
				System.out.println("Has entregado " + dinero.getNombre() + " a la cocinera.\n");	//le digo al jugador que ha entregado dinero a la cocinera
				
			}
			else {																	//si el dinero no esta en la mochila del jugador, no es posible soltarlo
				System.out.println("No es posible entregar este objeto porque no tienes este objeto.");		//y se lo digo por pantalla al jugador
			}
		}
	}

	public boolean randomLuz() {		//para que inicialmente la luz de cada habitacion sea random si esta encendida o apagada
		Random rand = new Random();		//para poder hacer randoms

		int RandomNumber = rand.nextInt(2);		//creo una variable que tendra de valor 0 o 1
		if(RandomNumber == 0) {					//si es 0 returna false, y la luz estara apagada
			return false;
		}else {									//si es 1 returna true y la luz estara encendida
			return true;
		}
	
	}
	public int randomItems() {
		Random rand = new Random();		//para poder hacer randoms

			int RandomNumber = rand.nextInt(9);		//creo una variable que tendra de valor 0, 1, 2, 3, 4, 5, 6, 7 o 8
			while(RandomNumber == 7 || zones[RandomNumber].tengoItems()) {		//si el numero es 7 o en esa zona ya hay un item vuelve a hacer un numero random
				RandomNumber = randomItems();									//lo hago asi porque no quiero que inicialmente haya mas de 1 objeto en cada zona
			}																	//y no quiero que inicialmente haya objetos en la entrada principal
			return RandomNumber;				//returna el numero random
	}
	
	private void finJuego() {
		Scanner teclat = new Scanner (System.in);
		System.out.println("Gracias por jugar a la venganza de CarloBon.\n");
		System.out.println("Quieres volver a jugar?");								//le pregunto si quiere volver a jugar
		System.out.println("Si- No");
		String opcion = teclat.next().toLowerCase();
		
		if(opcion.equals("no")) {													//si dice que no
			volverJugar = false;													//volverJugar pasa a ser false y el programa acaba
			System.out.println("Gracias por jugar y suerte en tu vida.");
		}
		else if(opcion.equals("si")){												//si dice que si vuelve a empezar el juego
			//Juego programa = new Juego();
			inici();
		}else {																		//si no es ni si ni no vuelve ha hacer la pregunta
			System.out.println();
			System.out.println("Quieres volver a jugar?");
			System.out.println("Si - No");
			opcion = teclat.next().toLowerCase();
		}
	}
	
	public void historia() {		//solo muestra en pantalla la historia inicial del juego
		System.out.println("Sou CarloBon, comandant de les legions catalanes destinades a conquerir el món. Esteu sota\r\n" + 
				"el mandat de l’emperador RafaFer conegut arreu per la seva bondat i la seva estimació cap el\r\n" + 
				"poble. CarloBon és un home íntegre per a qui l’honor i la lleialtat són valors inqüestionables.\r\n" + 
				"L’emperador RafaFer te un hereu, en JordaJor que espera amb anhel algun dia ser el nou\r\n" + 
				"emperador Català. L’emperador RafaFer està malalt i vol deixar l’imperi a en CarloBon ja que\r\n" + 
				"serà el millor pel poble però.... En JordiJor s’assabenta de les seves intencions i assassina a\r\n" + 
				"en RafaFer quedant ell com a únic hereu de l’imperi. Tot seguit demana a les seves hostes\r\n" + 
				"eliminar sigil·losament a en CarloBon. Se t’emporten en mig d’un bosc i et malfereixen deixantte al llinda de la mort. Mentre l’emperador JordiJor entra a la capital de l’imperi Català gloriós i\r\n" + 
				"triomfal... comença la seva tirania!.\r\n" + 
				"Han passat uns mesos i ja estàs plenament recuperat de les ferides ocasionades i el teu cor\r\n" + 
				"demana venjança. Et dirigeixes a la capital amb la idea de fer justícia i aconseguir matar a\r\n" + 
				"l’emperador per explicar al poble tota la veritat i quin era el desig del malaurat RafaFer.\r\n" + 
				"Et davant del seu Palau, només portes una cuirassa i entres sigil·losament per la porta principal del\r\n" + 
				"palau........\n");
	}

	public Habitacion[] getZones() {		//getter y setter
		return zones;
	}

	public void setZones(Habitacion zones[]) {
		this.zones = zones;
	}

}
