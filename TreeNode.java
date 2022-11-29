package application;
/*
 * Author: Johnathan Duong
 */
public class TreeNode<T> {
	
	
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
	public T data;
	/*
	 * param
	 */
	public TreeNode(T dataNode) {
		
	this.data=dataNode;
	this.leftChild = null;
	this.rightChild= null;
	}
	
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}
	
	public T getData() {
		return this.data;	
	}
}
