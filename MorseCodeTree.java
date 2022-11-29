package application;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root; 
	
	public MorseCodeTree() {
		buildTree();
	}
	
	
	@Override
	public TreeNode<String> getRoot() {
		
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = new TreeNode<String>(newNode);
		
	}

	@Override
	public void insert(String code, String letter) {
		addNode(root,code,letter);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.charAt(0)== '.') {
				root.leftChild = new TreeNode<String>(letter);
			}
			else if(code.charAt(0) == '-') {
				root.rightChild = new TreeNode<String>(letter);
			}
			
		}
		else {
			if(code.charAt(0) == '.') {
				addNode(root.leftChild, code.substring(1), letter);
			}
			else if(code.charAt(0) == '-') {
				addNode(root.rightChild,code.substring(1), letter);
			}
		}
		
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root,code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() ==1) {
			if(code.charAt(0) =='.') {
				return root.leftChild.data;
			}
			else if (code.charAt(0)=='-') {
				return root.rightChild.data;
			}
		}
		else { 
			if (code.charAt(0)=='.') {
				return fetchNode(root.leftChild, code.substring(1));
			}
			else if(code.charAt(0)== '-') {
				return fetchNode(root.rightChild, code.substring(1));
			}
		}
		return null;
	}

	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		
		throw new UnsupportedOperationException();
	}

	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		root= new TreeNode<String> ("");
		//level 1
		insert(".","e");
		insert("-","t");
		//level 2
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		//level 3
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");	
		//level 4
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
		
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null) {
			return;
		}
		if(root.leftChild != null) {
			LNRoutputTraversal(root.leftChild, list);
		
		}
		list.add(root.data);
		if(root.rightChild != null) {
			LNRoutputTraversal(root.rightChild, list);

		}
		
	}

}
