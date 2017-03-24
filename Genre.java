/* Proyecto #1 Movie database
   CPEN-457 Programming Languages  
   Clase Genre el cual contiene el titulo y lista de peliculas del genero.
   @author Alexie R. Ortiz Falú
 */
public class Genre<R> {
	private String genre;
	private DL<R> movies;
	
	/*Constructor que recibe titulo de nuevo genero y 
	  crea un Double List vacio*/
	public Genre(String genre){
		this.genre = genre;
		this.movies = new DL<R>();
	}
	/*Constructor que crea nuevo genero al recibir titulo
	 * y peliculas 
	 */
	public Genre(String genre,R movies){
		this.genre = genre;
		this.movies = new DL<R>(movies);
	}
	/*Retorna lista de peliculas*/
	public DL<R> getGen(){
		return this.movies;
	}
	
	@Override
	public String toString(){
		return genre.toString();
	}
	
}
