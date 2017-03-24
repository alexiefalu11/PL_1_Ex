/* Proyecto #1 Movie database
   CPEN-457 Programming Languages  
   Clase DL que crea una lista doble circular
   la cual obtine.
   @author Alexie R. Ortiz Falú
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class DL<R> {
   private Node<R> root; 
   private int listsize;
   
   public DL(){
	   this.root = null;
	   listsize = 0;
   }
   
   public DL(R info){
	   this.root = new Node<>(info,this.root,this.root);
	   this.listsize = 1;
   }
   
   public void insert(R info){
	   int compare=0;
	   /*Si la lista esta vacia, crea nuevo nodo y declara
	     nodo proximo y anterior*/
	   if(this.root == null){
		   this.root =  new Node<>(info,null,null);
		   				this.root.setnext(this.root);
		   				this.root.setprev(this.root);
		   				this.listsize++;
		   				return;
	   }
	   /*Si el nodo root esta apuntando a si mismo, crea un nodo segundario
	    * ingresando la data de info comparandola con la info de root
	    */
	   else if(this.root.getnext() == this.root){
		   Node<R> Node_2 = new Node<>(info,this.root,this.root);
		   this.root.setnext(Node_2);
		   this.root.setprev(Node_2);
		   		compare = info.toString().compareTo(this.root.getinfo().toString());
		   		
		   		if(compare < 0){
		   			this.root = Node_2;
		   			this.listsize++;
		   			return;
		   		}
		   		else{this.listsize++;}
	   }
	   
	   else{
		   int i = 0;
		   		for(Node<R> current = this.root; i < this.listsize; current = current.getnext(), i++){
		   			compare = info.toString().compareTo(this.root.getinfo().toString());
		   			if(compare < 0){
		   				Node<R> Node_2 = new Node<>(info,current,current.getprev());
		   				current.getprev().setnext(Node_2);
		   				current.setprev(Node_2);
		   				
		   				if(current == this.root){
		   					this.root = Node_2;
		   				}
		   				this.listsize++;
		   				return;
		   			}
		   		}
		   		if(i == this.listsize){
		   			Node<R> Node_2 = new Node<>(info,this.root,this.root.getprev());
		   			this.root.getprev().setnext(Node_2);
		   			this.root.setprev(Node_2);
		   			this.listsize++;
		   		}
	   }
	   
   }
   
   public void inOrder(){
	   System.out.println(this.root.getinfo().toString());
	   for(Node<R>iter = this.root.getnext();iter != this.root;iter = iter.getnext()){
		   System.out.println(iter.getinfo().toString());
	   }
   }
   
   public void remove(R info){
	   
	   if(this.root==null){throw new NoSuchElementException();}
	   int i = 0;
	   
	   for(Node<R> current = this.root;i<listsize;current = current.getnext() ){
		   if(current.getinfo().equals(info)){
			   current.getprev().setnext(current.getnext());
			   current.getnext().setprev(current.getprev());
			   
			   if(current==this.root){
				   this.root = current.getnext();
			   }
			   current = null;
			   listsize--;
			   return;
		   }
	   }
   }
   
   public ArrayList<R> Array(){
	   ArrayList<R> array = new ArrayList<R>();
	   int i = 0;
	   for(Node<R> current = this.root; i < this.listsize; current = current.getnext(), i++){
		   array.add(current.getinfo());
	   }
	   return array;
   }
   public boolean isEmpty(){
	   return this.root == null;
   }
   
   public Node<R> getRoot(){
	   return root;
   }
   
   public int getSize(){
	   return listsize;
   }
   
}
