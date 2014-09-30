public class linkedlist{

	public static void main(String[] args){

	}


	Node super;
	public void linkedList(){
		super = new Node(0);		
	}

	public void append(){

	}

	public void insert(int pos, int value){

	}

	public void delete (int pos){

	}


	class Node{
		public Node next;
		public Node prev;
		int value;
	
		public Node(int value){

		}

		public void setNext(Node n){
			next = n;
		}
		
		public void setPrev(Node p){
			prev = p; 
		}

	}

}