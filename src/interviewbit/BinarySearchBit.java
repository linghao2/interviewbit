package interviewbit;

import java.util.*;

public class BinarySearchBit {
	public BinarySearchBit() {
		//int sqrt = sqrt(930675566);
		// answer 30506
		//int sqrt = sqrt(898);
		//int sqrt = sqrt(44334371);
		//System.out.println("sqrt:" + sqrt);
		//Integer[] boards = {1,2,3,4,5};
		//int time = paint(2, 5, Arrays.asList(boards));
		
		//Integer[] line1 = {1,3,5,11,12};
		//Integer[] line2 = {2,6,9,13,14};
		//Integer[] line3 = {3,6,9,15,16};
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		/*
		list.add(createArrayList(1,1,3,3,3,3,3));
		*/
		list.add(createArrayList(9,10,10,13,14,15,16,16,16,17,18));
		list.add(createArrayList(1,4,9,14,16,18,19,22,26,26,27));
		list.add(createArrayList(4,5,7,10,14,20,21,23,24,27,28));
		
		int median = findMedian(list);
		System.out.println(median);
	}

	ArrayList<Integer> createArrayList(Integer... values) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
		return list;
	}

	ArrayList<Integer> createArrayList3(Integer[] values) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
		return list;
	}
	
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		for (int i = 0; i < A.size(); i++) {
			ArrayList<Integer> row = A.get(i);
			int val = row.get(0);
			if (val < low) {
				low = val;
			}
			val = row.get(row.size()-1);
			if (val > high) {
				high = val;
			}
		}
		while (low <= high) {
			int mid = ((high-low)/2) + low;
			int compared = compareMedian(A, mid);
			if (compared == 0) {
				return mid;
			} else if (compared > 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
	
	public int compareMedian(ArrayList<ArrayList<Integer>> A, int num) {
		System.out.println("   num===="+ num);
		int greater = 0;
		int lesser = 0;
		int equals = 0;
		for (int i = 0; i < A.size(); i++) {
			ArrayList<Integer> row = A.get(i);
			int lo = 0;
			int rowSize = row.size()-1;
			int hi = rowSize;
			while (lo < hi) {
				int mid = ((hi-lo) / 2) + lo;
				int val = row.get(mid);
				if (val > num) {
					hi = mid - 1;
				} else if (val < num) {
					lo = mid + 1;
				} else {
					hi = mid;
					lo = mid;
					break;
				}
			}
			greater += rowSize - lo;
			lesser += lo;
			int val = row.get(lo);
			if (val > num) {
				greater ++;
			} else if (val < num) {
				lesser ++;
			} else {
				equals++;
			}
			System.out.println("lo: " + lo + " hi: " + hi);
		}
		System.out.println("greater: " + greater + " lesser: " + lesser + " equals: " + equals);
		int diff = equals <= 0 ? -1 : equals - 1 - Math.abs(greater-lesser);
		if ((greater == lesser) || diff >= 0) {
			return 0;
		} else {
			return (greater > lesser) ? 1 : -1;
		}
	}
	
	/*
	public int paint(int a, int b, List<Integer> c) {
		int max = 0;
		for (int val : c) {
			max += val;
		}
		int low = 0;
		int high = max;
		while (low <= high) {
			
		}
	}
	
	boolean isPossible(int num, List<Integer> c, int time) {
		
	}
	*/
	/* exceeded time limits */
	public int sqrt(int a) {
		int left = 0;
		int right = a;
		while (right > left) {
			int mid = right + ((left - right) / 2);
			int product = Integer.MAX_VALUE;
			try {
				product = Math.multiplyExact(mid, mid);
			} catch (ArithmeticException e) {
			}
			if (product > a) {
				right = mid - 1;
			} else {
				left = mid;
			}
			System.out.println(right + ", " + left);
			if ((right - left) <= 1) {
				return left;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		new BinarySearchBit();
	}

}
