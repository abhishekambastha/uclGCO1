package tree;

public class BST {

	private static node root;

	public static void main(String [] args){
		root = new node(6);

		root.left = new node(5);
		root.left.left = new node(2);
		root.left.right = new node(5);

		root.right = new node(7);
		root.right.right = new node(8);

		inOrder(root);
		
		System.out.println("inorder Morris");
		inOrderMorris(root);
		
		System.out.println("lets see if tree changed?");
		inOrder(root);

		deleteNode(root, 5);
		System.out.println("Deleted");
		inOrder(root);
	}

	public static void inOrder(node x){
		if(x != null){
			inOrder(x.left);
			System.out.println(x.key);
			inOrder(x.right);
		}
	}
	
	public static void inOrderMorris(node x){
		node current = x;
		node pre;
		while(current != null){
			if(current.left == null){
				System.out.println(current.key);
				current = current.right;
			}
			else{
				//Find the inorder predecessor of current 
				pre = current.left;  
				while(pre.right != null && pre.right != current){
					pre = pre.right;
				}
				//Make current as right child of its inorder predecessor
				if(pre.right == null){
					pre.right = current;
					current = current.left;
				}
				//Revert the changes made in if part to restore the original 
		        //tree i.e., fix the right child of predecssor
				else{
					pre.right = null;
					System.out.println(current.key);
					current = current.right;
				}
			}
		}
	}

	public static node treeSearch(node x, int k){
		if(x == null || x.key == k){
			return x;
		}else if(x.key<k){
			return treeSearch(x.right, k);
		}else{
			return treeSearch(x.left, k);
		}
	}
	
	public static node getParent(node r, node x){
		if(r == null){
			return null;
		}else if(r.left != null && r.left.key == x.key){
			return r;
		}else if(r.right != null && r.right.key == x.key){
			return r;
		}else if(x.key > r.key){
			return getParent(r.right, x);
		}else{
			return getParent(r.left, x);
		}
	}
	
	public static void deleteNode(node root, int k){
		node x = treeSearch(root, k);
		node x_parent = getParent(root, x);
		
		if(x.left == null){
			if(x == x_parent.left){
				x_parent.left = x.right;
			}else{
				x_parent.right = x.right;
			}
		}else if(x.right == null){
			if(x == x_parent.left){
				x_parent.left = x.left;
			}else{
				x_parent.right = x.left;
			}
		}else{
			
			
		}
		
	}
}

