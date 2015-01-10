package tree;

public class node {
	int key;
	public node parent;
	public node left;
	public node right;
	
	public node(int val){
		key = val;
		parent = null;
		left = null;
		right = null;
	}

}
