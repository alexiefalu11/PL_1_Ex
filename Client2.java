import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client2 {
 public static void main(String[] args) throws ClassNotFoundException{
	 try{
		 Socket socket = new Socket("localhost",7777);
		 PassingObject po = new PassingObject();
		 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		 out.writeObject(po);
		 
		 ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		 PassingObject in = (PassingObject) input.readObject();
		 in.Run();
		 System.out.println("Conexion con servidor: "+ socket.getInetAddress()+" Perdida.......!");
	 }catch(IOException e){
		 System.out.println("Socket Error!!!");
		 e.printStackTrace();
	 }
	 
 }
}
