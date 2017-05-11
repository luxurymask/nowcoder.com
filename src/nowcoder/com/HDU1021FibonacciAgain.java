package nowcoder.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HDU 1021 Fibonacci Again
 * https://www.nowcoder.com/questionTerminal/9976f3bf77654b00904cb128bf0c87fe?orderByHotValue=1&questionTypes=000100&page=1&onlyReference=false
 * @author liuxl
 *
 */
//TODO 答案错误:您提交的程序没有通过所有的测试用例
public class HDU1021FibonacciAgain {
	private List<Integer> hduFibonacci = new ArrayList<Integer>();
	
	public HDU1021FibonacciAgain() {
		hduFibonacci.add(7);
		hduFibonacci.add(11);
		for(int i = 2;i < 1000000;i++){
			hduFibonacci.add(((hduFibonacci.get(i - 1) % 10) + (hduFibonacci.get(i - 2) % 10)) % 10);
		}
	}
	
	public boolean hduFibonacci(int n){
		if(hduFibonacci.get(n - 1) % 2 == 0) return true;
		return false;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			if(n == 0 || n == 1){
				System.out.println("no");
				continue;
			}
			HDU1021FibonacciAgain fn = new HDU1021FibonacciAgain();
			if(fn.hduFibonacci(n) == true){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}
}
