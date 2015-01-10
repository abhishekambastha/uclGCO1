package redBlackTrees;

public class Node {

	int key;
	boolean color;
	Node left;
	Node right;
	Node parent;
	
	public Node(int k){
		this.key =k;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.color = false;
		
	}
	
}
