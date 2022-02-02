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
	 * M�todo main encargado de ejecutar la aplicaci�n
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		/**
		 * Creaci�n de un objeto de la clase Scanner para interactuar con el usuario
		 **/
		Scanner S = new Scanner(System.in);

		/** Creaci�n de una variable de tipo String que recoger� el Host, ser� nuestra direcci�n IP**/
		String Host = "192.168.1.37";

		/** Creaci�n de una variable de tipo Int que almacenar� el puerto **/
		int Puerto = 6000;

		/** Mensaje al cliente **/
		System.out.print("El programa del cliente se ha iniciado \n");

		/**
		 * Creaci�n de un objeto de la Clase Socket, pasando por par�metro el Host y el
		 * puerto
		 **/
		Socket Cliente = new Socket(Host, Puerto);

		/** CREACI�N DE FLUJO DE SALIDA AL SERVIDOR **/
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

		/** INTERACCI�N CON EL SERVIDOR **/
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