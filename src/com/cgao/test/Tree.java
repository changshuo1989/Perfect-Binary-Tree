package com.cgao.test;

import java.util.Stack;

public class Tree {
	private Node root;
	
	public Tree() {
		root=null;
	}
	
	public Tree(Node node){
		root=node;
	}
	
	
	public Tree(int[] array){
		int len=array.length;
		for(int i=0; i<len; i++){
			this.insert(array[i]);
		}
	}
	
	public void insert(int value){
		Node newNode =new Node();
		newNode.value=value;
		if(root==null){
			System.out.println("inserted!");
			root=newNode;
		}
		else{
			Node current=root;
			Node parent=null;
			while(true){
				parent=current;
				//go left
				if(value<current.value){
					System.out.println("go left");
					current=current.leftChild;
					if(current==null){
						parent.leftChild=newNode;
						System.out.println("inserted!");
						return;
					}
				}
				else{
					System.out.println("go right");
					current=current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						System.out.println("inserted!");
						return;
					}
				}				
			}
		}
	}
	
	//find node with given key
	public Node find(int key){
		Node current=this.root;
		while(current != null && current.value!=key){

				if(current.value > key){
					current=current.leftChild;
					
				}
				else{
					current=current.rightChild;
				}
		}
		return current;
	}
	
	//recursive
	public void inOrderTraverse(Node localRoot){
		if(localRoot == null){
			return;
		}
		else{
			inOrderTraverse(localRoot.leftChild);
			System.out.println(localRoot.value);
			inOrderTraverse(localRoot.rightChild);
		}
	}
	
	//using stack to store all the nodes, but need to pay attention to the time when to push and pop
	//non-recursive(iterative)
	//思想是一直沿着树的左子树遍历，直到最左边，然后慢慢出栈， 出栈时看右子树情况(必定从小到大)
	public void inOrderTraverse2(){
		Stack<Node> inOrderStack=new Stack<Node>();
		Node node=this.root;
		inOrderStack.push(node);
		while(node.leftChild!=null){
			inOrderStack.push(node.leftChild);
			node=node.leftChild;
		}
		while(!inOrderStack.isEmpty()){
			System.out.println(inOrderStack.peek().value);
			Node popNode=inOrderStack.pop();
			if(popNode.rightChild!=null){
				Node node1=popNode.rightChild;
				inOrderStack.push(node1);
				while(node1.leftChild!=null){
					inOrderStack.push(node1.leftChild);
					node1=node1.leftChild;
				}
			}
		}		
	}
	
	
	//recursive
	public void preOrderTraverse(Node localRoot){
		if(localRoot ==null){
			return;
		}
		else{
			System.out.println(localRoot.value);
			preOrderTraverse(localRoot.leftChild);
			preOrderTraverse(localRoot.rightChild);
		}
	}
	//non-recursive(iterative)
	public void preOrderTraverse2(){
		Node node=this.root;
		Stack<Node> stack = new Stack<Node>();
		while(node.leftChild!=null){
			
		}
	}
	
	//recursive
	public void postOrderTraverse(Node localRoot){
		if(localRoot ==null){
			return;
		}
		else{			
			preOrderTraverse(localRoot.leftChild);
			preOrderTraverse(localRoot.rightChild);
			System.out.println(localRoot.value);
		}
	}
	
	//non-recursive
	public void postOrderTraverse2(){
		
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	 
	
}
