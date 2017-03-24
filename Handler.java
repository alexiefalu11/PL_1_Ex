
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Handler extends Thread{

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
	
	public void run(){
		transfer();
	}
	public void transfer(){
		try{
		int readCommand;
		
			do{
				System.out.println("Entre al do");
				readCommand = inStream.readInt();
				onStream.writeUTF("Hola como estas ?");
				readCommand = inStream.readInt();
				System.out.println("Escogio opcion #"+readCommand);
				
				switch(readCommand){
				case Codes.ADD_GENRE: 
					NewGen(tree);  
					break;
			/*	case Codes.ADD_MOVIE:
					NewMov(tree);
					break;
				case Codes.MOD_GENRE:
					ModMov(tree);
					break;
				case Codes.LIST_GENRE:
					ListGen(tree);
					break;
				case Codes.LIST_MOV_GEN:
					ListMov(tree);
					break;
				case Codes.LIST_MOV_PAR:
					ListMovGen(tree);
					break;
				case Codes.SEARCH_MOV:
					SeaMov(tree);
					break;
				*/	
				case Codes.CLOSECONN:
					Scanner input = new Scanner(System.in);
					String  answer = null;
					do{
						System.out.println("Seguro que desea salir?");
						System.out.print("SI [S] / NO[N] --> ");
						answer = input.nextLine();
						
						if(answer.toUpperCase().equals("S")){
							onStream.flush();
							System.out.println("Gracias por utilizar Movie Database!!");
							answer = "EXIT";
						}
						else if(answer.toUpperCase().equals("N")){
							readCommand=0;
							answer = "EXIT";
						}
					}
					while(!(answer.toUpperCase().equals("EXIT")));
				}
				
			}while(readCommand!= Codes.CLOSECONN);
			inStream.close();
			onStream.close();
			socketClient.close();
			
		}catch(IOException e){
			
		}
	}
	
	
	public void Menu(){
		
		 System.out.println("=============== Movie Database =================");
		 System.out.println("Favor de escojer la opción a utilizar de la siguiente lista de pelicula");
		 System.out.println("(1) Añadir un genero de pelicula");
		 System.out.println("(2) Añadir una pelicula");
		 System.out.println("(3) Modificar una pelicula");
		 System.out.println("(4) Enlistar todos los generos");
		 System.out.println("(5) Enlistar pelicula por genero");
		 System.out.println("(6) Enlistar una pelicula especifica");
		 System.out.println("(7) Buscar por pelicula");
		 System.out.println("(8) Salir");
		 
		 System.out.print("Seleccion --> ");
		}	
	
	static void NewGen(BST Tree){
		 String Genre = null;
		 Scanner input= new Scanner(System.in);
		 
		 System.out.println("********Añadiendo nuevo Genero********");
		 System.out.println("Nuevo Genero --> ");
		 Genre = input.nextLine();
		 Tree.add(Genre);
		 System.out.println("EL Genero "+Genre+" ha sido Añadido!"); 
	 }
}
