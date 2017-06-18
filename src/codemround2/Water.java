package codemround2;

import java.util.Scanner;
/**
 * 没通过全部。
 * @author liuxl
 *
 */
public class Water {	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		float T = in.nextInt();
		float C = in.nextInt();
		float[] t = new float[n];
		float[] c = new float[n];
		float target;
		int flag = 0;
		
		int i = -1;
		do{
			i++;
			t[i] = in.nextInt();
			c[i] = in.nextInt();
		}while(t[i] == T);
		
		target = ((i == 0) ? t[i] : t[i - 1]);

		i++;
		
		if(T < target){
			flag = -1;
			for(;i < n;i++){
				t[i] = in.nextInt();
				c[i] = in.nextInt();
				if(T > t[i]){
					System.out.println("Impossible");
					return;
				}
				if(t[i] < target){
					target = t[i];
				}
			}
		}else if(T > target){
			flag = 1;
			for(;i < n;i++){
				t[i] = in.nextInt();
				c[i] = in.nextInt();
				if(T < t[i]){
					System.out.println("Impossible");
					return;
				}
				if(t[i] > target){
					target = t[i];
				}
			}
		}
		
		float sumC = 0;
		
		if(flag == 0){
			System.out.println("Possible");
			System.out.printf("%.4f", T);
			return;
		}else{
			for(int j = 0;j < n;j++){
				float transfer = ((t[j] - target) * c[j] / (target - T));
				C -= transfer;
				sumC += transfer;
				sumC += c[j];
				if(C < 0){
					System.out.println("Impossible");
					return;
				}
			}
			if(flag == 1){
				target = (C * T + target * sumC)/(C + sumC);
			}
			System.out.println("Possible");
			System.out.printf("%.4f", target);
			return;
		}
	}
}
