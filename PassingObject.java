import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class PassingObject implements Serializable{

	
	PassingObject(){	
		
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
	public	void Run(){
		BST<Movie> Tree = new BST<>();
		 int select = 0;
			do{
				select = Menu();
					switch (select){
						case 1: 						
							NewGen(Tree);  
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
	static void NewGen(BST Tree){
		 String Genre = null;
		 Scanner input= new Scanner(System.in);
		 
		 System.out.println("********Añadiendo nuevo Genero********");
		 System.out.println("Nuevo Genero --> ");
		 Genre = input.nextLine();
		 Tree.add(Genre);
		 System.out.println("EL Genero "+Genre+" ha sido Añadido!"); 
	 }
	
	static void NewMov(BST Tree){
		Scanner input = new Scanner(System.in);
		Movie movie = new Movie();
		
		System.out.println("********Añadiendo nueva Pelicula***********");
		System.out.println("Favor de ingresar la siguiente información");
		System.out.println("Titulo --> ");
		movie.set_title(input.nextLine());
		System.out.println("Director --> ");
		movie.set_director(input.nextLine());
		System.out.println(" Plot --> ");
		movie.set_plot(input.nextLine());
		System.out.println("Año --> ");
		movie.set_year(input.nextInt());
		
		ArrayList<Genre<Movie>> List = new ArrayList<Genre<Movie>>();
		List = GenList(Tree.getroot(),List);
		
		System.out.println("Seleccione la categoria de genero de la pelicula: "+movie.get_title());
		int a = List.size();
		System.out.println();
		for(int i=0;i<a;i++){
			System.out.println("["+(i+1)+"] "+List.get(i).toString());
		}
		int gen = 0;
		do{
			System.out.println("Genero --> ");
			gen = input.nextInt();
		}while(gen<1 || gen>a);
		List.get(gen-1).getGen().insert(movie);
		
		System.out.println("\t** "+movie.get_title()+" "+movie.get_director()+" "+movie.get_plot()+ 
				" ha sido añadido al genero "+List.get(gen-1).toString()+" **");
	}
	
	static void GenList(BST Tree){
		ArrayList<Genre<Movie>> List = new ArrayList<Genre<Movie>>();
		List = GenList(Tree.getroot(),List);
		int a = List.size();
		System.out.println("-----------Categoria de Generos-----------");
		for(int i=0;i<a;i++){
			System.out.println("["+(i+1)+"] "+List.get(i).toString());
		}
	}
	
	static ArrayList<Genre<Movie>> GenList(Node<Genre<Movie>> Tree,ArrayList<Genre<Movie>> List){
		if(Tree.getprev()!=null){
			GenList(Tree.getprev(),List);
		}
		List.add(Tree.getinfo());
		
		if(Tree.getnext()!=null){
			GenList(Tree.getnext(),List);
		}
		return List;
	}
	
	static void ListGen(BST Tree){
		Tree.inOrder();
	}
	
	static void ListMovGen(BST Tree){
		Scanner input = new Scanner(System.in);
		ArrayList<Genre<Movie>> List = new ArrayList<Genre<Movie>>();
		List = GenList(Tree.getroot(),List);
			int a = List.size();
			System.out.println("-----------Categoria de Generos-----------");
			for(int i=0;i<a;i++){
				System.out.println("["+(i+1)+"] "+List.get(i).toString());
			}
			
			int Genre = 0;
			do{
				System.out.println("Seleccione la categoria de genero de la pelicula --> ");
				Genre = input.nextInt();
			}while(Genre<0 || Genre>a);
			ArrayList<Movie> Movie = List.get(Genre-1).getGen().Array(); //*******VERIFICAR******
			
			System.out.println(" # |       Title     |  Release Year | Director's name ");
			for(int b=0;b<Movie.size();b++){
				System.out.println("("+(b+1)+")"+Movie.get(b).get_title()+" | "+
				Movie.get(b).get_year()+" | "+Movie.get(b).get_director());
			}
			 
	}
	
	static void ModMov(BST Tree){
		
	}
	
	static void ListMov(BST Tree){
		
	}
	
	static void SeaMov(BST Tree){
		
	}
	
}
	 

