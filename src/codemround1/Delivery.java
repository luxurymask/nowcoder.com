package codemround1;

import java.util.HashSet;
import java.util.Set;

public class Delivery {
	class TrieNode{
		TrieNode root;
		TrieNode left;
		TrieNode right;
		String val;
		
		TrieNode(){
			
		}
		
		TrieNode(String val){
			this.val = val;
		}
	}
	
	private Set<Integer> setA = new HashSet<Integer>();
	private Set<Integer> setB = new HashSet<Integer>();
	
	public void setTrie(TrieNode root, int[] a, int[] b){
		int length = a.length;
		int index = Integer.parseInt(root.val);
		int leftIndex = index + a[index];
		int rightIndex = index + b[index];
		
		if(leftIndex >= length || leftIndex < 0){
			root.left = new TrieNode("N");
		}else if(setA.contains(leftIndex) || a[leftIndex] == 0){
			root.left = new TrieNode("I");
		}else{
			root.left = new TrieNode(leftIndex + "");
		}
		
		setA.add(leftIndex);
		setTrie(root.left, a, b);
		
		if(rightIndex >= length || rightIndex < 0){
			root.right = new TrieNode("N");
		}else if(setB.contains(rightIndex) || a[rightIndex] == 0){
			root.right = new TrieNode("I");
		}else{
			root.right = new TrieNode(rightIndex + "");
		}
		
		setB.add(rightIndex);
		setTrie(root.right, a, b);
	}
	
	
}
