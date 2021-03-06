import java.util.ArrayList;
import java.util.Random;

public class FoldInteger {

	public static int fold(ArrayList<Integer> list, boolean isSum, int acc, int pos) {
		return (pos >= list.size()) ? acc : fold(list,isSum,isSum ? acc+list.get(pos) : acc*list.get(pos), pos+1);
	}

	public static int summate(ArrayList<Integer> list) {
		return fold(list,true,0,0);
	}

	public static int product(ArrayList<Integer> list) {
		return fold(list,false,1,0);
	}

	public static void main(String args[]) {
		Random r = new Random();
		double max = 10000000.0;
		double countSummateAll = 1.0;
		double countProductAll = 1.0;
		double countSummateCorrect = 1.0;
		double countProductCorrect = 1.0;
		ArrayList<Integer> ls = new ArrayList();
		for (int i = 0; i<max; i++) {
			ls.clear();
			int acc;
			boolean isSum = r.nextBoolean();
			if (isSum) {
				countSummateAll++;
				acc = 0;
			} else {
				countProductAll++;
				acc = 1;
			}
			int n = r.nextInt(10);
			for (int j = 0; j<n; j++) {
				int curr = r.nextInt(20);
				ls.add(curr);
				acc = isSum ? (acc+curr) : acc*curr;
			}
			if (isSum) {
				if (summate(ls) == acc) countSummateCorrect++;
			} else {
				if (product(ls) == acc) countProductCorrect++;
			}
		}
		System.out.println(((countSummateCorrect/countSummateAll)+(countProductCorrect/countProductAll))/2.0*30.0);
	}

}
