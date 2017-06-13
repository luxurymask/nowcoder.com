package codemround1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Coupons {
	public static int getIndex(Set<Integer> wildmark, int start, int end) {
		int min = Integer.MAX_VALUE;
		for (int i : wildmark) {
			if (i > start && i < end && i < min) {
				min = i;
			}
		}

		if (min != Integer.MAX_VALUE) {
			return min;
		}

		return -1;
	}

	public static int check(int n, String[] log) {
		Map<String, Integer> coupons = new HashMap<String, Integer>();
		Set<Integer> wildmark = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			String item = log[i];
			if (item.equals("?")) {
				wildmark.add(i);
				continue;
			}

			String[] array = item.split(" ");
			if (array[0].equals("I")) {
				if (coupons.containsKey(array[1])) {
					int j;
					if ((j = getIndex(wildmark, coupons.get(array[1]), i)) == -1) {
						return (i + 1);
					} else {
						wildmark.remove(j);
					}
				}
				coupons.put(array[1], i);
			}else if(array[0].equals("O")){
				if(!coupons.containsKey(array[1])){
					int j;
					if((j = getIndex(wildmark, -1, i)) == -1){
						return (i + 1);
					}else{
						wildmark.remove(j);
					}
				}else{
					coupons.remove(array[1]);
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			String[] log = new String[n];
			for(int i = 0;i < n;i++){
				String next = in.next();
				log[i] = next.equals("?") ? next : (next + " " + in.next());
			}
			System.out.println(check(n, log));
		}
	}
}
