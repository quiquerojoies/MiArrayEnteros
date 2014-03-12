package miarrayenteros;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author quiquerojo
 *
 */
public class MiArrayEnteros {

	//atributos
	int [] tabla; // para almacenar los enteros
	int nElementos;//el n�mero de elementos v�lidos en el array
	
	//constructores
	/**Levantar� una excepci�n si intentamos crear un array y no le pasamos el n�mero
	 * de elementos inicial.
	 * @throws Exception 
	 */
	public MiArrayEnteros() throws Exception {
		throw new Exception("Debe dar un tama�o inicial al array de enteros.");
		//podr�amos haber creado un array por defecto de 10 elementos, por ejemplo
	}
	
	/**Constructor para crear un array con el n�mero de enteros que de pasemos como par�metro.
	 * @param n n�mero de elementos del array que queremos crear.
	 * @throws Exception si el n�mero de enteros que pasamos como par�metro es menor o igual que cero.
	 */
	public MiArrayEnteros (int n) throws Exception{
		if (n <= 0 ){
			throw new Exception("El tama�o inicial al array de enteros debe ser positivo.");
		}
		else {
			tabla = new int[n];//al ser un objeto, sus elementos se inicializan a 0
			nElementos = 0;
		}
	}
	
	/**M�todo para saber si el array est� vac�o, o sea, si no tiene ning�n elemento v�lido.
	 * @return true si est� vac�o y false si tiene alg�n elemento.
	 */
	public boolean estaVacio(){
		return nElementos ==0;
	}
	
	
	/**M�todo para saber si el array est� lleno. Para ello comprobaremos si el n�mero
	 * de elementos v�lidos coincide con el tama�o del array.
	 * @return true si est� lleno
	 */
	public boolean estaLleno(){
		return nElementos == tabla.length;
	}
	
	/**Devuelve el n�mero de elementos v�lidos en el array en ese momento
	 * @return el n�mero de enteros v�lidos en el array
	 */
	public int getValidos(){
		return nElementos;
	}
	
	/**Recibe un entero como par�metro y lo a�ade al final 
	 * de los elementos que ya est�n en el array. Si el array est� lleno, mostrar� 
	 * un mensaje que lo indique y devolver� false.
	 * @param numero n�mero que queremos a�adir
	 * @return true si hemos podido a�adirle al array
	 */
	public boolean add(int numero){
		boolean resultado = false;
		if (estaLleno()){
			System.err.println("El array est� lleno. No se ha podido insertar el elemento.");
			//dejamos resultado a false
		}
		else {
			tabla[nElementos] = numero;
			nElementos++;
			resultado = true;
		}
		return resultado;
		
	}
	
	/**Recibe dos enteros: el n�mero que queremos insertar y la posici�n donde queremos meterle. 
	 * A�adir� el entero en la posici�n que le digamos y mover� los que est�n a la derecha 
	 * una posici�n  a la derecha para que no se pierda ninguno. si el array est� lleno o si
	 * la posici�n que le indicamos no es v�lida, dar� un mensaje de error y devolver� false.
	 * No ser� v�lida una posici�n mayor que el n�mero de elementos v�lidos en la tabla porque
	 * dejar�a huecos en el array.
	 * @param numero el entero que queremos insertar
	 * @param pos la posici�n en que queremos insertarlo
	 * @return true si conseguimos introducirle en el array.
	 */
	public boolean add(int numero, int pos){
		boolean resultado = false;
		if (estaLleno()){
			System.err.println("El array est� lleno. No se ha podido insertar el elemento.");
			//dejamos resultado a false
		}
		else {//no est� lleno
			if (pos < 0 || pos > nElementos){
				System.err.println("La posici�n indicada no es v�lida."+
						" Debe estar entre 0 y "+nElementos);
				resultado = false;
			}
			else {//vamos a insertar el elemento
				for (int i = nElementos; i >= pos; i--){//movemos los elementos a la derecha para hacer sitio
					tabla [i+1] = tabla[i];
				}
				//insertamos el n�mero
				tabla[pos] = numero;
				nElementos++;//incrementamos el n�mero de elementos
				resultado = true;
			}
		}
		return resultado;
			
	}
	
	/**Recibir� como par�metro un entero y nos dir� en qu� posici�n del array est� 
	 * la primera ocurrencia de ese n�mero o -1 si no lo encuentra.
	 * @param n el entero a buscar
	 * @return la posici�n donde lo encuentra o -1 si no lo encuentra
	 */
	public int buscar(int n){
		boolean encontrado = false;
		int pos = -1;//para almacenar d�nde lo ha encontrado
		int i = 0;//para recorrer el array
		while (i < nElementos && !encontrado){
			if(tabla[i]== n){//lo ha encontrado
				encontrado = true;
				pos = i;
			}
		}//fin del while
		//si no lo encuentra, pos estar� a -1
		return pos;
		
	}
	
	/**Recibe un entero y elimina el elemento que ocupa 
	 * el lugar que le digamos si tiene un valor.
	 * @param pos la posici�n del elemento que queremos eliminar que debe estar entre 0 y el n�mero de elementos v�lidos -1
	 * @return true si lo elimina o false si no es una posici�n v�lida y no lo elimina
	 */
	public boolean eliminaPorIndice(int pos){
		boolean resultado = false;
		if (pos < 0 || pos >= nElementos){//est� fuera de los l�mites del array
			System.err.println("�ndice fuera de rango");
		}
		else {//es un valor v�lido para eliminar
			for (int i = pos; i < nElementos-1; i++){
				//llegamos hasta nElementos-2, que se copiar� de nElementos-1, que es el �ltimo
				tabla[i] = tabla[i+1];
			}
			nElementos--;//decrementamos el n�mero de elementos.
			resultado = true;
		}
		return resultado;
	}
	
	/**Recibe un entero y lo elimina si est� en el array. 
	 * @param n el valor a eliminar del array
	 * @return  true si lo ha eliminado y false si no lo ha encontrado y, por tanto, no ha podido eliminarlo.
	 */
	public boolean elimina(int n){
		//vamos a utilizar el m�todo buscar para saber si est� o no en el array y 
		//si est�, lo eliminaremos con eliminaPorIndice()
		boolean resultado = false; 
		int posicion = -1;
		posicion = buscar(n);
		if (posicion != -1){//lo ha encontrado
			resultado = eliminaPorIndice(posicion);
			//devolver� true o false si ha podido eliminarlo o no
		}
		//si no, resultado sigue a false
		return resultado;
	}
	
	
	/**Lista los elementos v�lidos del array.
	 * 
	 */
	public void listar(){
		if (!estaVacio()){
			System.out.println("Listado de los elementos del array: ");
			for (int i = 0; i < nElementos; i++){
				System.out.print(tabla[i]+"  ");//o como queramos mostrarlos.
			}
			System.out.println();
		}
		else {
			System.out.println("El array est� vac�o");
		}
		//podr�amos quitar el if y funcionar�a igual, pero entonces no escribir�a nada
		//porque no entrar�a en el bucle. As�, nos dice que est� vac�o y no parece 
		//que no hace nada.
	}
	
	/**Recibir� dos enteros, la posici�n que queremos modificar y el nuevo valor. 
	 * @param posicion la posici�n que queremos cambiar
	 * @param nuevoValor el nuevo valor que queremos poner en esa posici�n
	 * @return true si cambiamos el valor y false si en la posici�n que le pasamos 
	 * no hay ning�n valor o es una posici�n no v�lida
	 */
	public boolean modificar(int posicion, int nuevoValor){
		boolean resultado = false;
		if (posicion >= 0 && posicion < nElementos){// ser� una posici�n v�lida
			tabla[posicion] = nuevoValor;
			resultado = true;
		}
		else {
			System.err.println("La posici�n proporcionada no es correcta.");
			//no hace falta poner resultado a false porque ya est� inicializado a ese valor
		}
		return resultado;
		
	}
	
	/* (non-Javadoc)Devuelve el array con el aspecto [3,4,5,2] 
	 * o la cadena vac�a si el array est� vac�o
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String salida = "";
		StringBuilder cadena;
		if (!estaVacio()) {
			cadena = new StringBuilder("[");
			for (int i = 0; i < nElementos - 1; i++) {
				cadena.append(tabla[i] + ",");
			}
			//a�adimos el �ltimo elemento sin coma y cerramos el corchete
			cadena.append(tabla[nElementos - 1] + "]");
			salida = cadena.toString();//convertimos el StringBuilder a String
		}
		else {//el array est� vac�o
			//no hacemos nada, el String ya est� con ""
		}
		return salida;
	}
	
	/**Reduce el tama�o del array al tama�o exacto para los elementos v�lidos 
	 * que hay en �l, eliminando las posiciones finales vac�as.
	 * 
	 */
	public void compactar(){
		int[] tAux = new int[nElementos];
		for (int i = 0; i < nElementos; i++){
			tAux[i] = tabla[i];
		}
		tabla = tAux;
		//hacemos que tabla apunte al nuevo array. El otro lo eliminar� el recolector de basura
	}
	
	/**Redimensiona el array a un nuevo tama�o que le pasamos por par�metro. 
	 * Si el nuevo tama�o es menor que el n�mero de elementos almacendados en el array
	 *  nos pregunta si queremos perder el resto de los elementos.  
	 * @param nuevoTamanio nuevo tama�o del array
	 * @return true si lo redimensiona o false si no lo hace.
	 */
	public boolean redimensionar (int nuevoTamanio){
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		boolean resultado = false;//para saber si lo hemos redimensionado
		char opcion ;
		boolean seguir = true;
		if (nuevoTamanio < nElementos){//nuevo tama�o menor del n�mero de elementos
			System.err.println("Cuidado, el nuevo tama�o es menor que el n�mero de elementos en el array.");
			do {
				System.out
						.println("Si contin�a, se eliminar�n los que sobren. ");
				System.out.print("Est� seguro de que desea continuar(s/n): ");
				opcion = entrada.nextLine().toLowerCase().charAt(0);
				//tomamos el primer caracter en min�scula de la cadena
			} while (opcion != 's' && opcion != 'n');
			if (opcion == 'n'){//no queremos cortar el array
				seguir = false;
			}
			else {//queremos redimensionar
				seguir = true;//ya lo estaba al inicializarlo
			}
		}
		if (seguir == true){//el nuevo tama�o es v�lido o queremos recortar
			int[] tAux = new int[nuevoTamanio];
			int hasta = Math.min(nuevoTamanio, nElementos);//el menor de los dos
			for (int i = 0; i < hasta; i++){
				tAux[i] = tabla[i];//copiamos los elementos
			}
			tabla = tAux;//tabla queda apuntando al nuevo array
			nElementos = hasta;//el nuevo n�mero de elementos del array
			//no ser� el antiguo ni el nuevoTamanio, sino el menor de ambos, hasta.
			resultado = true; //lo hemos redimensionado
		}
		return resultado;
		
	}
	
	/**Ordena el array. Utilizamos el m�todo sort de la clase Arrays que nos permite ordenar 
	 * un trozo del array que le pasemos como par�metro. Esto es �til porque el array puede no estar
	 * lleno.
	 * 
	 */
	public void ordena(){
		Arrays.sort(tabla,0, nElementos);
	}
	
	
}
