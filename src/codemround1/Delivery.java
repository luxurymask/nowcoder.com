package codemround1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Delivery {
	static class TrieNode{
		TrieNode root;
		TrieNode left;
		TrieNode right;
		int val;
		
		TrieNode(){
			
		}
		
		TrieNode(int val){
			this.val = val;
		}
	}
	
	private static Set<Integer> setA = new HashSet<Integer>();
	private static Set<Integer> setB = new HashSet<Integer>();
	private static List<Integer> indexList = new ArrayList<Integer>();
	
	private static String resultPath = null;
	private static Set<Integer> infinity = new HashSet<Integer>();
	
	static{
		setA.add(0);
		setB.add(0);
		indexList.add(0);
	}
	
	
	public static boolean setTrie(TrieNode root, int[] a, int[] b, String path, List<Integer> indexList){
		int length = a.length;
		int index = root.val;
		boolean leftInfinity = false;
		boolean rightInfinity = false;
		int leftIndex = index + a[index];
		if(leftIndex == (length - 1)){
			resultPath = path + "a";
			return true;
		}
		
		if(leftIndex >= length || leftIndex < 0){
			root.left = null;
		}else if(setA.contains(leftIndex)){
			root.left = null;
			infinity.add(index);
			infinity.add(leftIndex);
			leftInfinity = true;
		}else{
			root.left = new TrieNode(leftIndex);
			setA.add(leftIndex);
			indexList.add(leftIndex);
		}
		
		boolean result = false;
		if(root.left != null && leftInfinity == false){
			result = setTrie(root.left, a, b, path + "a", indexList);
		}
		if(result == true){
			return result;
		}else if(setA.contains(leftIndex)){
			setA.remove(leftIndex);
		}
		

		int rightIndex = index + b[index];
		if(rightIndex == (length - 1)){
			resultPath = path + "b";
			return true;
		}
		
		if(rightIndex >= length || rightIndex < 0){
			root.right = null;
		}else if(setB.contains(rightIndex)){
			root.right = null;
			infinity.add(index);
			infinity.add(rightIndex);
			rightInfinity = true;
		}else{
			root.right = new TrieNode(rightIndex);
			indexList.add(rightIndex);
			setB.add(rightIndex);
		}
		
		if(root.right != null && rightInfinity == false){
			result = setTrie(root.right, a, b, path + "b", indexList);
		}
		if(result == false){
			if(indexList.size() != 0) indexList.remove(indexList.size() - 1);
			if(setB.contains(rightIndex)) setB.remove(rightIndex);
		}
		return result;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		
		for(int i = 0;i < n;i++){
			a[i] = in.nextInt();
		}
		
		for(int i = 0;i < n;i++){
			b[i] = in.nextInt();
		}
		
		Delivery.TrieNode root = new Delivery.TrieNode(0);
		setTrie(root, a, b, "", indexList);
		
		if(resultPath == null){
			System.out.println("No solution!");
			return;
		}
		for(int i : indexList){
			if(infinity.contains(i)){
				System.out.println("Infinity!");
				return;
			}
		}
		System.out.println(resultPath);
	}
}
