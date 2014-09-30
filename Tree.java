import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class Tree{
	int [] treeHeap = {1,2,3,4,5,6,7,8};
	Node rootNode; 
	public static void main(String [] args){
	Tree tree = new Tree();
	tree.start();	
	}
	
	void start (){
		rootNode = new Node(null, null, null, 1);		
		makeTree(rootNode, 0);
		
		// visit(rootNode,"post");
		ArrayList <Node> toPass = new ArrayList <Node>();
		toPass.add(rootNode);
		printLevel(toPass);
	}


	// Level printing
	
	void printLevel(ArrayList<Node> n){
		ArrayList<Node> next = new ArrayList<Node>();		
		for (Node t: n) {
			System.out.print(t.value+" "); 
			if (t.left!= null)
				next.add(t.left);
			if (t.right!=null)
				next.add(t.right);
		}
		System.out.println();
		if (next.size()!=0)
			printLevel(next);
	}

	// Trying to do bfs with an arraylist 
	void doBfs(){		
		arrayListIndex = 0 ;
		bfs(rootNode);
	}

	ArrayList <Node> q = new ArrayList<Node>(); 
	int arrayListIndex;

	void bfs(Node n){		
		for (int i=0;i< q.size(); i++){
			System.out.print(i+" "+q.get(i).value+", ");
		}
		System.out.println();
		System.out.println(n.value);
		if (n.left!=null){
			q.add(n.left);
			System.out.println("Adding left"+ n.left.value);
		}
		if (n.right!=null){
			q.add(n.right);
			System.out.println("Adding right"+ n.right.value);
		}
		
		arrayListIndex++;

		if (arrayListIndex<q.size()){
			System.out.println("BFS on "+arrayListIndex);
			bfs(q.get(arrayListIndex));
		}
	}
	// Traversal 	
	void visit(Node n, String type ){
		if (type.equals("pre"))
			System.out.println(n.value);
		if (n.left!=null)
			visit(n.left, type);
		if (type.equals("in"))
			System.out.println(n.value);
		if (n.right!=null)
			visit(n.right, type);
		if (type.equals("post"))
			System.out.println(n.value);
	}

	// Tree Construction stuff
	void makeTree(Node node, int i){
		int lChild = 2*i+1;		
		int rChild = 2*i+2;
		if (lChild <  treeHeap.length){
			Node lChildNode = new Node (node, null, null, treeHeap[lChild]);
			node.left = lChildNode;
			makeTree(lChildNode, lChild);
		}
		if (rChild< treeHeap.length){
			Node rChildNode = new Node(node, null, null, treeHeap[rChild]);
			node.right = rChildNode;
			makeTree(rChildNode, rChild);
		}
	}

	class Node{
		public Node parent;
		public Node left;
		public Node right;
		public int value;		
		
		public Node(Node p, Node l, Node r, int v){
			parent = p;
			left  = l;
			right = r ;			
			value = v;
		}
	}

	static void testHash(){
		Map <Integer, String> map = new HashMap <Integer, String>();		
		map.put(1, "Aashish");
		System.out.println(map.get(1));
	}

}