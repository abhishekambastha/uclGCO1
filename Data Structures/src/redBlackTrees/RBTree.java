package redBlackTrees;

public class RBTree {

	Node root;
	public RBTree(int k){
		root = new Node(k);
	}

	public static void main(String[] arg){

		RBTree T =new RBTree(10);

		T.root.left = new Node(6);
		T.root.right = new Node(12);
		
		T.RBInsert(T, new Node(3));

		System.out.println("Red Black Tree Before rotation");
		T.inOrder(T.root);

		System.out.println();
		System.out.println("Red Black Tree After rotation");
		T.LeftRotate(T, T.root);
		T.inOrder(T.root);
		
		T.printTree(T.root);
		System.out.println("Hello " + T.root.key);

	}

	public void LeftRotate(RBTree T, Node x){
		Node y = x.right;
		x.right = y.left;
		if(y.left != null){
			y.left.parent = x; 
		}
		y.parent = x.parent;

		if(x.parent == null){
			T.root = y;
		}else if(x == x.parent.left){
			x.parent.left = y;
		}else if(x == x.parent.right){
			x.parent.right =y;
		}
		y.left = x;
		x.parent = y;		
	}

	public void inOrder(Node x){
		if(x != null){
			inOrder(x.left);
			System.out.print(x.key + ", ");
			inOrder(x.right);
		}
	}

	public void RBInsert(RBTree T, Node z){
		Node y = null;
		Node x = T.root;
		while(x!=null){
			y = x;
			if(z.key<x.key){
				x = x.left;
			}else{
				x = x.right;
			}
		}
		
		z.parent = y;
		if(y==null){
			T.root = z;
		}else if(z.key<y.key){
			y.left = z;
		}else{
			y.right = z;
		}
		z.left= null;
		z.right = null;
		z.color = true;
		//RBFixUP
	}
	
	
	public void printTree(Node x){
		
	}
}


