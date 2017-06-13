package codemround1;

import java.util.Scanner;

public class XiaoMei {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int target = in.nextInt();
		int count = 0;
		for(int i = 0;i < n - 1;i++){
			int current = in.nextInt();
			if(current <= target){
				count++;
			}
		}
		
		int resultRound = 0;
		
		while(count != 0){
			resultRound++;
			if((count & 1) == 0){
				count = (count - 1) / 2;
			}else{
				count = count / 2;
			}
		}
		
		System.out.println(resultRound);
	}
}
