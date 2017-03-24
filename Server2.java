import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.Serializable;

public class Server2  implements Serializable{
	public static void main(String[] args) throws ClassNotFoundException{
		int clientCount = 0;
		try{
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println("Servidor arriba - Esperando conecciones...");
			
			while(true){
				
			try{
				Socket socket = serverSocket.accept();
				
				clientCount++;
				System.out.println("Coneccion #"+clientCount);
				Server(tree,clientSocket);
				
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				
				PassingObject in = (PassingObject) input.readObject();
			//	System.out.println("From SOcket : "+in.message);
				
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				out.writeObject(in);
				
				System.out.println("OK BYE: "+ socket.getLocalPort());
				socket.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			}
		}catch(IOException e){
			System.out.println("Server error!!");
			e.printStackTrace();
		}
	}
	private static void Server2(BST<Genre<Movie>>tree,Socket clientSocket){
		new Handler2(tree,clientSocket).start();
	}


}
