/* Proyecto #1 Movie database
   CPEN-457 Programming Languages  
   Clase Nodo que provee un nodo generico para 
   un linked list.
   @author Alexie R. Ortiz Falú
 */

public class Node<R>{
	
	static int node_num = 0; 
	private R info;
	private Node<R> next;
	private Node<R> prev; 
	
	/*Constructor de incio que crea un nodo vacio*/
	public Node(){
		this.info = null;
		this.next = null;
		this.prev = null;
	}
	/*Constructor que recibe una informacion de tipo generico
      y dos nodos para entrelazar.*/
	public Node(R info, Node<R> next, Node<R> prev){
		this.info = info;
		this.next = next;
		this.prev = prev;
		node_num++;
	}
	/*Constructor que recibe dos nodos para entrelazar*/
	public Node(Node<R> next, Node<R> prev){
		this.info = null;
		this.next = next;
		this.prev = prev;
		node_num++;
	}
	/*Constructor que solo recibe informacion tipo generico*/
	public Node(R info){
		this.info = info;
		this.next = null;
		this.prev = null;
		node_num++;
	}
	/*Actualiza la informacion recibida*/
	public void setinfo(R info){
		this.info  = info;
	}
	
	/*Actualiza proximo nodo en el entrelazamiento*/
	public void setnext(Node<R> next){
		this.next = next;
	}
	/*Actualiza nodo anterior en el entrelazamiento*/
	public void setprev(Node<R> prev){
		this.prev = prev;
	}
	/*Retorna la informacion*/
	public R getinfo(){
		return info;
	}
	/*Retorna nodo proximo*/
	public Node<R> getnext(){
		return next;
	}
	/*Retorna nodo anterior*/
	public Node<R> getprev(){
		return prev;
	}
	/*Retorna informacion en tipo String*/
	public String getInfoStr(){
		return info.toString(); 
	}
}
