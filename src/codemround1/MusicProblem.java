package codemround1;

import java.util.Scanner;

public class MusicProblem {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int[] first = new int[m];
		for(int i = 0;i < m;i++){
			first[i] = in.nextInt();
		}
		int n = in.nextInt();
		int[] second = new int[n];
		for(int i = 0;i < n;i++){
			second[i] = in.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		for(int j = 0;j < n - m + 1;j++){
			int current = 0;
			for(int i = 0;i < m;i++){
				current += Math.pow(Math.abs(first[i] - second[i + j]), 2);
			}
			if(current < min) min = current;
		}
		System.out.println(min);
	}
}
