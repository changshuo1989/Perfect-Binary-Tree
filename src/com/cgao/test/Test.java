package com.cgao.test;

public class Test {

	public static void main(String[] args) {
		int[] array={12,2,234,6,1,9};
		Tree tree=new Tree(array);
		 Node aNode=tree.find(412);
		 if(aNode!=null){
			System.out.println("===="+aNode.value);
		 }
		 else{
			 System.out.println("Not find");
		 }
		 tree.inOrderTraverse2();

	}

}
