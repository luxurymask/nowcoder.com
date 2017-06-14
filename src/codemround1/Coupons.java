package codemround1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Coupons {
	public static int check(int n, String[] log) {
		Map<String, Integer> couponsIn = new HashMap<String, Integer>();
		Map<String, Integer> couponsOut = new HashMap<String, Integer>();
		TreeSet<Integer> wildmark = new TreeSet<Integer>();

		for (int i = 0; i < n; i++) {
			String item = log[i];
			if (item.equals("?")) {
				wildmark.add(i);
				continue;
			}

			String[] array = item.split(" ");
			String type = array[0];
			String id = array[1];
			if (type.equals("I")) {
				if (couponsIn.containsKey(id)) {
					Integer j;
					Integer inIndex = couponsIn.get(id);
					if ((j = wildmark.higher((inIndex == null) ? -1 : inIndex)) == null) {
						return (i + 1);
					} else {
						wildmark.remove(j);
					}
				}
				couponsIn.put(id, i);
				if(couponsOut.containsKey(id)){
					couponsOut.remove(id);
				}
			} else if (type.equals("O")) {
				if (!couponsIn.containsKey(id)) {
					Integer j;
					Integer outIndex = couponsOut.get(id);
					if ((j = wildmark.higher((outIndex == null) ? -1 : outIndex)) == null) {
						return (i + 1);
					} else {
						wildmark.remove(j);
					}
				} else {
					couponsIn.remove(id);
				}
				couponsOut.put(id, i);
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			in.nextLine();
			String[] log = new String[n];
			for (int i = 0; i < n; i++) {
				log[i] = in.nextLine();
			}
			System.out.println(check(n, log));
		}
	}
}
