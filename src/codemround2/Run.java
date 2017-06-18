package codemround2;

import java.util.Scanner;

public class Run {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double v = in.nextDouble();
		double u = in.nextDouble();
		
		double[] c = new double[n];
		double[] d = new double[n];
		for(int i = 0;i < n;i++){
			c[i] = in.nextDouble();
		}
		
		for(int i = 0;i < n;i++){
			d[i] = in.nextDouble();
		}
		
		double result = 0;
		for(int i = 0;i < n;i++){
			for(int j = 1;j <= n;j++){
				result += u/(c[i] - (j - 1) * d[i] - v);
			}
		}
		System.out.printf("%.3f", result);
	}
}
