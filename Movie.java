/* Proyecto #1 Movie database
   CPEN-457 Programming Languages  
   Clase Movie que crea un objeto el cual obtiene toda la información
   de una pelicula.
   @author Alexie R. Ortiz Falú
 */
public class Movie {
	//Variables para guardar información de una pelicula
		 private String title; //Variable titulo de pelicula 
		 private String genre; //Variable genero de pelicula
		 private String actors; //Variable actores de pelicula
		 private String director; //Variable director de pelicula
		 private String plot; //Variable plot de pelicula
		 private Integer year_release; //Variable año de pelicula
	/*Constructor de inicio que crea una pelicula vacia*/	 
		 Movie(){
			title = "NONE";
			genre = "NONE";
			actors = "NONE";
			plot = "NONE";
			director = "NONE";
			year_release = null;
		}
	/*Constructor que recibe la información de la pelicula creada*/
		Movie(String title, String genre, String actors, String director, String plot, Integer year_release){
			this.title = title;
			this.genre = genre;
			this.actors = actors;
			this.director = director;
			this.plot = plot;
			this.year_release = year_release;
		}
	/*Actualiza el titulo de pelicula*/	
		void set_title(String title){
			this.title = title;
		}
	/*Actualiza el genero de pelicula*/	
		void set_genre(String genre){
			this.genre = genre;
		}
	/*Actualiza el director de la pelicula*/	
		void set_director(String director){
			this.director = director;
		}
	/*Actualiza el plot de la pelicula*/
		void set_plot(String plot){
			this.plot = plot;
		}
	/*Actualiza el año de la pelicula*/	
		void set_year(Integer year_release){
			this.year_release = year_release;
		}
	/*Devuelve el titulo de pelicula*/	
		String get_title(){
			return this.title;
		}
	/*Devuelve el genero de le pelicula*/	
		String get_genre(){
			return this.genre;
		}
	/*Devuelve los actores de la pelicula*/	
		String get_actors(){
			return this.actors;
		}
	/*Devuelve el director de la pelicula*/	
		String get_director(){
			return this.director;
		}
	/*Devuelve el plot de la pelicula*/	
		String get_plot(){
			return this.plot;
		}
	/*Devuelve el año de la pelicula*/	
		Integer get_year(){
			return this.year_release;
		}

}
