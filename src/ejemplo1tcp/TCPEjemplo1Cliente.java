package ejemplo1tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Clase TCPEjemplo1Cliente
 * 
 * @author javie
 *
 */
public class TCPEjemplo1Cliente {

	/**
	 * Método main encargado de ejecutar la aplicación
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		/**
		 * Creación de un objeto de la clase Scanner para interactuar con el usuario
		 **/
		Scanner S = new Scanner(System.in);

		/** Creación de una variable de tipo String que recogerá el Host, será nuestra dirección IP**/
		String Host = "192.168.1.37";

		/** Creación de una variable de tipo Int que almacenará el puerto **/
		int Puerto = 6000;

		/** Mensaje al cliente **/
		System.out.print("El programa del cliente se ha iniciado \n");

		/**
		 * Creación de un objeto de la Clase Socket, pasando por parámetro el Host y el
		 * puerto
		 **/
		Socket Cliente = new Socket(Host, Puerto);

		/** CREACIÓN DE FLUJO DE SALIDA AL SERVIDOR **/
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

		/** INTERACCIÓN CON EL SERVIDOR **/
		System.out.println("Por favor, introduzca su nombre : ");
		String mensaje = S.nextLine();
		System.out.println("Bienvenido " + mensaje.toUpperCase());
		flujoSalida.writeUTF(mensaje.toUpperCase());

		/**
		 * Cierre de la variable DataOutPutStream y del objeto Cliente de la clase
		 * Socket
		 **/
		flujoSalida.close();
		Cliente.close();
		System.exit(0);

	}
}