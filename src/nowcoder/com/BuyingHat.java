package nowcoder.com;

import java.util.Arrays;
import java.util.Scanner;

public class BuyingHat {
	public static int price(int[] prices, int k){
		Arrays.sort(prices);
		int count = 1;
		for(int i = 0,j = 0;j < prices.length;){
			if(prices[i] == prices[j]){
				j++;
			}else{
				count++;
				i = j;
				if(count == k) return prices[j];
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] prices = new int[N];
		for(int i = 0;i < N;i++){
			prices[i] = in.nextInt();
		}
		System.out.println(price(prices, 3));
	}
}
