package binaryTrees;

public class TreeNode {
	int key;
	TreeNode right;
	TreeNode left;
	TreeNode parent;
	
	public TreeNode(int k){
		key = k;
		parent = null;
		left = null;
		right = null;
	}
	
	public void setKey(int k){
		key = k;
	}
	
	public void setLeft(TreeNode node){
		left = node;
	}
	
	public void setRight(TreeNode node){
		right = node;
	}
	
	public void setParent(TreeNode node){
		parent = node;
	}
	
	public TreeNode getLeft(){
		return left;
	}
	
	public TreeNode getRight(){
		return right;
	}
	
	public TreeNode getParent(){
		return parent;
	}
	
	public int getValue(){
		return key;
	}
	

}
