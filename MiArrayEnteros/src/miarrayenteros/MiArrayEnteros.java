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
	int nElementos;//el número de elementos válidos en el array
	
	//constructores
	/**Levantará una excepción si intentamos crear un array y no le pasamos el número
	 * de elementos inicial.
	 * @throws Exception 
	 */
	public MiArrayEnteros() throws Exception {
		throw new Exception("Debe dar un tamaño inicial al array de enteros.");
		//podríamos haber creado un array por defecto de 10 elementos, por ejemplo
	}
	
	/**Constructor para crear un array con el número de enteros que de pasemos como parámetro.
	 * @param n número de elementos del array que queremos crear.
	 * @throws Exception si el número de enteros que pasamos como parámetro es menor o igual que cero.
	 */
	public MiArrayEnteros (int n) throws Exception{
		if (n <= 0 ){
			throw new Exception("El tamaño inicial al array de enteros debe ser positivo.");
		}
		else {
			tabla = new int[n];//al ser un objeto, sus elementos se inicializan a 0
			nElementos = 0;
		}
	}
	
	/**Método para saber si el array está vacío, o sea, si no tiene ningún elemento válido.
	 * @return true si está vacío y false si tiene algún elemento.
	 */
	public boolean estaVacio(){
		return nElementos ==0;
	}
	
	
	/**Método para saber si el array está lleno. Para ello comprobaremos si el número
	 * de elementos válidos coincide con el tamaño del array.
	 * @return true si está lleno
	 */
	public boolean estaLleno(){
		return nElementos == tabla.length;
	}
	
	/**Devuelve el número de elementos válidos en el array en ese momento
	 * @return el número de enteros válidos en el array
	 */
	public int getValidos(){
		return nElementos;
	}
	
	/**Recibe un entero como parámetro y lo añade al final 
	 * de los elementos que ya están en el array. Si el array está lleno, mostrará 
	 * un mensaje que lo indique y devolverá false.
	 * @param numero número que queremos añadir
	 * @return true si hemos podido añadirle al array
	 */
	public boolean add(int numero){
		boolean resultado = false;
		if (estaLleno()){
			System.err.println("El array está lleno. No se ha podido insertar el elemento.");
			//dejamos resultado a false
		}
		else {
			tabla[nElementos] = numero;
			nElementos++;
			resultado = true;
		}
		return resultado;
		
	}
	
	/**Recibe dos enteros: el número que queremos insertar y la posición donde queremos meterle. 
	 * Añadirá el entero en la posición que le digamos y moverá los que estén a la derecha 
	 * una posición  a la derecha para que no se pierda ninguno. si el array está lleno o si
	 * la posición que le indicamos no es válida, dará un mensaje de error y devolverá false.
	 * No será válida una posición mayor que el número de elementos válidos en la tabla porque
	 * dejaría huecos en el array.
	 * @param numero el entero que queremos insertar
	 * @param pos la posición en que queremos insertarlo
	 * @return true si conseguimos introducirle en el array.
	 */
	public boolean add(int numero, int pos){
		boolean resultado = false;
		if (estaLleno()){
			System.err.println("El array está lleno. No se ha podido insertar el elemento.");
			//dejamos resultado a false
		}
		else {//no está lleno
			if (pos < 0 || pos > nElementos){
				System.err.println("La posición indicada no es válida."+
						" Debe estar entre 0 y "+nElementos);
				resultado = false;
			}
			else {//vamos a insertar el elemento
				for (int i = nElementos; i >= pos; i--){//movemos los elementos a la derecha para hacer sitio
					tabla [i+1] = tabla[i];
				}
				//insertamos el número
				tabla[pos] = numero;
				nElementos++;//incrementamos el número de elementos
				resultado = true;
			}
		}
		return resultado;
			
	}
	
	/**Recibirá como parámetro un entero y nos dirá en qué posición del array está 
	 * la primera ocurrencia de ese número o -1 si no lo encuentra.
	 * @param n el entero a buscar
	 * @return la posición donde lo encuentra o -1 si no lo encuentra
	 */
	public int buscar(int n){
		boolean encontrado = false;
		int pos = -1;//para almacenar dónde lo ha encontrado
		int i = 0;//para recorrer el array
		while (i < nElementos && !encontrado){
			if(tabla[i]== n){//lo ha encontrado
				encontrado = true;
				pos = i;
			}
		}//fin del while
		//si no lo encuentra, pos estará a -1
		return pos;
		
	}
	
	/**Recibe un entero y elimina el elemento que ocupa 
	 * el lugar que le digamos si tiene un valor.
	 * @param pos la posición del elemento que queremos eliminar que debe estar entre 0 y el número de elementos válidos -1
	 * @return true si lo elimina o false si no es una posición válida y no lo elimina
	 */
	public boolean eliminaPorIndice(int pos){
		boolean resultado = false;
		if (pos < 0 || pos >= nElementos){//está fuera de los límites del array
			System.err.println("Índice fuera de rango");
		}
		else {//es un valor válido para eliminar
			for (int i = pos; i < nElementos-1; i++){
				//llegamos hasta nElementos-2, que se copiará de nElementos-1, que es el último
				tabla[i] = tabla[i+1];
			}
			nElementos--;//decrementamos el número de elementos.
			resultado = true;
		}
		return resultado;
	}
	
	/**Recibe un entero y lo elimina si está en el array. 
	 * @param n el valor a eliminar del array
	 * @return  true si lo ha eliminado y false si no lo ha encontrado y, por tanto, no ha podido eliminarlo.
	 */
	public boolean elimina(int n){
		//vamos a utilizar el método buscar para saber si está o no en el array y 
		//si está, lo eliminaremos con eliminaPorIndice()
		boolean resultado = false; 
		int posicion = -1;
		posicion = buscar(n);
		if (posicion != -1){//lo ha encontrado
			resultado = eliminaPorIndice(posicion);
			//devolverá true o false si ha podido eliminarlo o no
		}
		//si no, resultado sigue a false
		return resultado;
	}
	
	
	/**Lista los elementos válidos del array.
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
			System.out.println("El array está vacío");
		}
		//podríamos quitar el if y funcionaría igual, pero entonces no escribiría nada
		//porque no entraría en el bucle. Así, nos dice que está vacío y no parece 
		//que no hace nada.
	}
	
	/**Recibirá dos enteros, la posición que queremos modificar y el nuevo valor. 
	 * @param posicion la posición que queremos cambiar
	 * @param nuevoValor el nuevo valor que queremos poner en esa posición
	 * @return true si cambiamos el valor y false si en la posición que le pasamos 
	 * no hay ningún valor o es una posición no válida
	 */
	public boolean modificar(int posicion, int nuevoValor){
		boolean resultado = false;
		if (posicion >= 0 && posicion < nElementos){// será una posición válida
			tabla[posicion] = nuevoValor;
			resultado = true;
		}
		else {
			System.err.println("La posición proporcionada no es correcta.");
			//no hace falta poner resultado a false porque ya está inicializado a ese valor
		}
		return resultado;
		
	}
	
	/* (non-Javadoc)Devuelve el array con el aspecto [3,4,5,2] 
	 * o la cadena vacía si el array está vacío
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
			//añadimos el último elemento sin coma y cerramos el corchete
			cadena.append(tabla[nElementos - 1] + "]");
			salida = cadena.toString();//convertimos el StringBuilder a String
		}
		else {//el array está vacío
			//no hacemos nada, el String ya está con ""
		}
		return salida;
	}
	
	/**Reduce el tamaño del array al tamaño exacto para los elementos válidos 
	 * que hay en él, eliminando las posiciones finales vacías.
	 * 
	 */
	public void compactar(){
		int[] tAux = new int[nElementos];
		for (int i = 0; i < nElementos; i++){
			tAux[i] = tabla[i];
		}
		tabla = tAux;
		//hacemos que tabla apunte al nuevo array. El otro lo eliminará el recolector de basura
	}
	
	/**Redimensiona el array a un nuevo tamaño que le pasamos por parámetro. 
	 * Si el nuevo tamaño es menor que el número de elementos almacendados en el array
	 *  nos pregunta si queremos perder el resto de los elementos.  
	 * @param nuevoTamanio nuevo tamaño del array
	 * @return true si lo redimensiona o false si no lo hace.
	 */
	public boolean redimensionar (int nuevoTamanio){
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		boolean resultado = false;//para saber si lo hemos redimensionado
		char opcion ;
		boolean seguir = true;
		if (nuevoTamanio < nElementos){//nuevo tamaño menor del número de elementos
			System.err.println("Cuidado, el nuevo tamaño es menor que el número de elementos en el array.");
			do {
				System.out
						.println("Si continúa, se eliminarán los que sobren. ");
				System.out.print("Está seguro de que desea continuar(s/n): ");
				opcion = entrada.nextLine().toLowerCase().charAt(0);
				//tomamos el primer caracter en minúscula de la cadena
			} while (opcion != 's' && opcion != 'n');
			if (opcion == 'n'){//no queremos cortar el array
				seguir = false;
			}
			else {//queremos redimensionar
				seguir = true;//ya lo estaba al inicializarlo
			}
		}
		if (seguir == true){//el nuevo tamaño es válido o queremos recortar
			int[] tAux = new int[nuevoTamanio];
			int hasta = Math.min(nuevoTamanio, nElementos);//el menor de los dos
			for (int i = 0; i < hasta; i++){
				tAux[i] = tabla[i];//copiamos los elementos
			}
			tabla = tAux;//tabla queda apuntando al nuevo array
			nElementos = hasta;//el nuevo número de elementos del array
			//no será el antiguo ni el nuevoTamanio, sino el menor de ambos, hasta.
			resultado = true; //lo hemos redimensionado
		}
		return resultado;
		
	}
	
	/**Ordena el array. Utilizamos el método sort de la clase Arrays que nos permite ordenar 
	 * un trozo del array que le pasemos como parámetro. Esto es útil porque el array puede no estar
	 * lleno.
	 * 
	 */
	public void ordena(){
		Arrays.sort(tabla,0, nElementos);
	}
	
	
}
