import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Handler2 extends Thread{

	private ObjectInputStream inStream;
	private ObjectOutputStream onStream;
	
	private BST<Genre<Movie>> tree;
	private Socket socketClient;
	
	public Handler(BST<Genre<Movie>> tree, Socket socketClient){
		try{
			this.socketClient = socketClient;
			this.inStream = new ObjectInputStream(new BufferedInputStream(socketClient.getInputStream()));
			this.onStream = new ObjectOutputStream(new BufferedOutputStream(socketClient.getOutputStream()));
			this.tree = tree;
		}catch(IOException e){
			
		}
	}
	
}
