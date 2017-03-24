import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	
	public static void main(String [] args){
	
	BST tree = new BST<Genre<Movie>>();
		
	int port = 1024;
	int clientCount = 0;
		
		try{
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Servidor arriba - Esperando conecciones...");
		
			while(true){
				
				try{
				Socket clientSocket = serverSocket.accept();
				clientCount++;
				System.out.println("Coneccion #"+clientCount);
				Server(tree,clientSocket);
		 		}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static void Server(BST<Genre<Movie>>tree,Socket clientSocket){
		new Handler(tree,clientSocket).start();
	}
}
	