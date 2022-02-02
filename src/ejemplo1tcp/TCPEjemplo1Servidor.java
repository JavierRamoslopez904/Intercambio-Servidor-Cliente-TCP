package ejemplo1tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Clase TCPEjemplo1Servidor
 * @author javie
 *
 */
public class TCPEjemplo1Servidor {
	
	/**
	 * Método main encargado de ejecutar la aplicación
	 * @param arg
	 * @throws IOException
	 */
	public static void main(String[] arg) throws IOException {
		
		/** Objeto de la clase Scanner para interaccionar con el usuario **/
		Scanner S = new Scanner(System.in);

		/** Creacion de una variable de tipo int para almacenar el puerto **/
		int numeroPuerto = 6000;
		
		/** Creación de una variable de la clase Socket que recibe por parámetros el puerto creado anteriormente **/
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		
		/** Creación de una variable de la clase Socket inicializada a null **/
		Socket clienteConectado = null;
		System.out.print("Esperando al Cliente \n");
		clienteConectado = servidor.accept();

		/** CREACIÓN DE FLUJO PARA EL CLIENTE **/
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);

		/** MENSAJE DEL CLIENTE **/
		System.out.print("Mensaje recibido del Cliente: \n\t" + flujoEntrada.readUTF());

		/** CREACIÓN DEL FLUJO DE SALIDA **/
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);
		String opcion = "";
		do {
			// CERRAR STREAMS Y SOCKETS
			try {
				System.out.println("\n Escriba un * para salir del programa");
				opcion = S.next();
				if (opcion.equals("*")) {
					entrada.close();
					flujoEntrada.close();
					salida.close();
					flujoSalida.close();
					clienteConectado.close();
					servidor.close();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("Debes de introducir numeros");
				S.nextLine();
			}
		} while (opcion != "*");
	}

}// main
	// fin