
public class BST<R> {
	Node<Genre<R>> root;
	
	public BST(){
		this.root = null;
	}
	
	public BST(String genre){
		this.root = new Node<Genre<R>>(new Genre<R>(genre));
	}
	public void add(String genre){
		if(this.root == null){
			this.root = new Node<Genre<R>>(new Genre<R>(genre));
		}
		else{this.add(genre,this.root);}
		
	}
	
	public void add(String genre,Node<Genre<R>>node){
		
		int compare = genre.compareTo(node.getInfoStr());
		
		if(compare>0){
			
			if(node.getnext()==null){
				node.setnext(new Node<Genre<R>>(new Genre<R>(genre)));
			}
			else{add(genre,node.getnext());}
		}
		else{
			if(node.getprev()==null){
				node.setprev(new Node<Genre<R>>(new Genre<R>(genre)));
			}
			else{add(genre,node.getprev());}
		}
	}
	public void inOrder(Node<Genre<R>>node,DL<Genre<R>>list){
		if(node!=null){
			inOrder(node.getprev(),list);
			list.insert(node.getinfo());
			inOrder(node.getnext(),list);
		}
		else if(this.root==null){
			System.out.println("Categroia Genero esta vacia: Favor ingresar tipos de Genero");
			;
		}
	}
	public void inOrder(){
		DL list = new DL<Genre<R>>();
		inOrder(this.root,list);
		list.inOrder();
	}
	
	public Node<Genre<R>> getroot(){
		return this.root;
	}
}
