import java.io.Serializable;
import java.util.Scanner;

public class test implements Serializable {
	 
		//BST<Movie> Tree = new BST<>();
 public	void Run(){
	 int select = 0;
		do{
			select = Menu();
				switch (select){
				//	case 1: 						
				/*		NewGen(Tree);  
						break;
					case 2:
						NewMov(Tree);
						break;
					case 3:
						ModMov(Tree);
						break;
					case 4:
						ListGen(Tree);
						break;
					case 5:
						ListMov(Tree);
						break;
					case 6:
						ListMovGen(Tree);
						break;
					case 7:
						SeaMov(Tree);
						break;
						*/
					case 8:
						Scanner input = new Scanner(System.in);
						String  answer = null;
						do{
							System.out.println("Seguro que desea salir?");
							System.out.print("SI [S] / NO[N] --> ");
							answer = input.nextLine();
							
							if(answer.toUpperCase().equals("S")){
							System.out.println("Gracias por utilizar Movie Database!!");
							answer = "EXIT";
							}
							else if(answer.toUpperCase().equals("N")){
								select=0;
								answer = "EXIT";
							}
						}
						while(!(answer.toUpperCase().equals("EXIT")));
					}
		}
		while(select!=8);
 }
 
 static int Menu(){
	 
	 int select =0;
	 
	 Scanner input = new Scanner(System.in);
	 
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
	 
	 System.out.println("Seleccion --> ");
	 select = input.nextInt();
	 
	 return select;
 }
}
