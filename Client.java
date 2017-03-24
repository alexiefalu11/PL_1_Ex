import java.io.*;
import java.net.*;

public class Client {

	private static int currentComand, serverPort=1024;
	 
	private ObjectInputStream inStream;
	private ObjectOutputStream onStream;
	private Socket socket = null;
	
	public static void main(String [] args){
		String serverAddressStr="127.0.0.1";
	    System.out.println(" Conectando al servidor "+serverAddressStr+" atravez de "+serverPort);
	    
	    Client client = new Client(serverAddressStr);
	    
	}
	
	public Client(String serverAddressStr){
		if(!connectToServer(serverAddressStr)){
			System.out.println("Error al abrir conneccion socket a: "
					+ serverAddressStr);
		}
	}
	
	private boolean connectToServer(String serverAddressStr){
		try{
		//	InetAddress serverAdd = InetAddress.getByName(serverAddressStr);
			System.out.println("Entre al connectTo");
			this.socket = new Socket(serverAddressStr,serverPort);
			System.out.println("Entre al connectTo2");
			this.onStream = new ObjectOutputStream(this.socket.getOutputStream());
			System.out.println("Entre al connectTo3");
			this.inStream = new ObjectInputStream(this.socket.getInputStream());
			System.out.println("Entre al connectTo4");
    		System.out.println("00. -> Connected to Server:" + this.socket.getInetAddress() 
    				+ " on port: " + this.socket.getPort()); 
		}catch (Exception e) {
        	System.out.println("XX. Failed to Connect to the Server at port: " + serverPort);
        	System.out.println("    Exception: " + e.toString());	
        	return false;}
		return true;
	}
	
	private void dataTransfer(){
		
	}
	
	
}