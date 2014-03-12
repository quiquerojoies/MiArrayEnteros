/**
 * 
 */
package miarrayenteros;

/**
 * @author quiquerojo
 *
 */
public class PruebaMiArrayEnteros {

	

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("probamos crear un array sin parámetro");
			MiArrayEnteros mal = new MiArrayEnteros();
		} catch (Exception e) {
			System.out.println("Hemos intentado crear un array sin tamaño");
			System.out.println("MiArrayEnteros mal = new MiArrayEnteros();");
		}
		try {
			System.out.println("probamos crear un array de tamaño negativo");
			MiArrayEnteros malneg = new MiArrayEnteros(-5);
		} catch (Exception e) {
			System.out.println("Hemos intentado crear un array de tamaño negativo");
			System.out.println("MiArrayEnteros malneg = new MiArrayEnteros(-5);");
		}
		System.out.println("probamos crear un array de tamaño 10");
		MiArrayEnteros a = new MiArrayEnteros(10);
		a.add(3);
		a.add(5,1);
		a.add(25);
		a.add(8);
		a.listar();
		System.out.println("Lo mostramos ordenado: ");
		a.ordena();
		a.listar();
		System.out.println("Borramos un elemento (el 3): ");
		a.elimina(3);
		System.out.println("Ahora tenemos "+a.getValidos()+" elementos válidos en el array");
		System.out.println("Y volvemos a listar el array: ");
		a.listar();
		System.out.println("Ahora borramos un elemento pasando la posición (la 2 empezando desde 0): ");
		a.eliminaPorIndice(2);
		System.out.println("Ahora tenemos "+a.getValidos()+" elementos válidos en el array");
		System.out.println("Y volvemos a listar el array: ");
		a.listar();
		//ahora nos quedan 2 números. Vamos a meter 8 para que no se pase el límite
		a.add(4); 	a.add(33);  a.add(18);
		a.add(13);  a.add(55);  a.add(-4);
		a.add(0);   a.add(156);
		System.out.println("Ahora tenemos "+a.getValidos()+" elementos válidos en el array");
		System.out.println("Volvemos a listar el array: ");
		a.listar();
		System.out.println("intentamos meter uno más del máximo: ");
		a.add(44);
		System.out.println("Ahora tenemos "+a.getValidos()+" elementos válidos en el array");
		a.listar();
		System.out.println("ampliamos el array a 15 enteros como máximo e intentamos meter otros dos números, el 20 y el 30: ");
		a.redimensionar(15);
		a.add(20);
		a.add(30);
		System.out.println("Ahora tenemos "+a.getValidos()+" elementos válidos en el array");
		a.listar();
		System.out.println("compactamos el array e intentamos meter otro número, el 100: ");
		a.compactar();
		System.out.println("Ahora tenemos "+a.getValidos()+" elementos válidos en el array");
		a.add(100);
		a.listar();
		System.out.println("Ahora vamos a redimensionar el array pero a un tamaño menor de los enteros que ya contiene (lo ponemos de tamaño 5)");
		a.redimensionar(5);
		System.out.println("Ahora tenemos "+a.getValidos()+" elementos válidos en el array");
		a.listar();
		
		
		

	}

}
