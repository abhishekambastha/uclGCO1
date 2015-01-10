package binaryTrees;

public class BST {
	TreeNode root;
	
	public BST(int k){
		root = new TreeNode(k);
	}
	
	public BST(){
		root = new TreeNode(-1);
	}
	
	public void treeInsert(TreeNode z){
		TreeNode y = null;
		TreeNode x = root;
		
		while(x != null){
			y =x;
			if(z.key < x.key){
				x = x.left;
			}else{
				x = x.right;
			}
		}
		
		z.setParent(y);
		if(y==null){
			root = z;
		}else if(z.key< y.key){
			y.left = z;
		}else{
			y.right = z;
		}
		
	}
	
	public TreeNode treeMin(TreeNode x){
		while(x.left != null){
			x = x.left;
		}
		return x;
	}
	
	public void transplant(TreeNode u, TreeNode v){
		if(u.parent == null){
			this.root = v;
		}else if(u == u.parent.left){
			u.parent.left = v;
		}else{
			u.parent.right = v;
		}
		
		if(v != null){
			v.parent = u.parent;
		}
	}
	
	public void delete(TreeNode z){
		if(z.left == null){
			transplant(z,z.right);
		}else if(z.right == null){
			transplant(z, z.left);
		}else{
			TreeNode y = treeMin(z.right);
			if(y.parent !=z){
				transplant(y,y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z,y);
			y.left = z.left;
			y.left.parent = y;
			
		}
	}
	
	public void inOrder(TreeNode x){
		if(x != null){
			inOrder(x.left);
			System.out.print(x.getValue() + ", ");
			inOrder(x.right);
		}
	}
	
	public TreeNode searchTree(int k, TreeNode x){
		if(x==null){
			x = root;
		}
		if(x == null || x.key==k ){
			return x;
		}else if(k<x.key){
			return searchTree(k, x.left);
		}else{
			return searchTree(k, x.right);
		}
	}
	
	public static void main(String[] args){
		BST T = new BST(6);
		T.treeInsert(new TreeNode(5));
		T.treeInsert(new TreeNode(2));
		T.treeInsert(new TreeNode(5));
		
		T.treeInsert(new TreeNode(7));
		T.treeInsert(new TreeNode(8));
		
		T.inOrder(T.root);
		System.out.println(" end");
		
		
		TreeNode r = T.searchTree(5, null);
		T.delete(r);
		T.inOrder(T.root);
		
		
		
	}

}
