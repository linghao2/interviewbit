package interviewbit;

import java.util.*;

public class ArrayBit {
	
	public ArrayBit() {
		/*
		Integer[] list = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int max = maxSubArray(Arrays.asList(list));
		System.out.println("max: " + max);
		
		ArrayList<ArrayList<Integer>> perms = generatePascalTriangle(5);
		for (int i = 0; i < perms.size(); i++) {
			System.out.println(perms.get(i));	
		}
		//Integer[] list2 = {2, 1, 3, 4, 1, 6, 1, 5, 4,9};
		Integer[] list2 = {1,2,3,4};
		ArrayList<Integer> waveList = wave(Arrays.asList(list2));
		System.out.println(waveList);
*/
	}
	
	/*
	 * Add One To Number
	 * Given a non-negative number represented as an array of digits,
	 * add 1 to the number ( increment the number represented by the digits ).
	 * The digits are stored such that the most significant digit is at the head of the list.
	 * [1,2,3] -> returns [1,2,4]
	 * [9,9,9,9,9] -> returns [1,0,0,0,0,0]
	 * 
	 */
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList<Integer> list = new ArrayList<Integer>(a.size() + 1);

		// remove leading zero's 
		int index = 0;
		if (a.size() > 1) {
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) == 0) {
					index = i + 1;
				} else {
					break;
				}
			}
		}
		Integer carry = 1;
		for (int i = a.size() - 1; i >= index; i--) {
			Integer num = a.get(i) + carry;
			if (num >= 10) {
				carry = 1;
				num = 0;
			} else {
				carry = 0;
			}
			list.add(0, num);
		}
		if (carry > 0) {
			list.add(0, carry);
		}
		return list;
	}
	
	/*
	 * Wave Array
	 * Given an array of integers, sort the array into a wave like array and return it, 
	 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
	 */
	
	public ArrayList<Integer> wave(List<Integer> a) {
		// selection sort the list first
		ArrayList<Integer> list = new ArrayList<Integer>(a);
//		for (int i = 0; i < list.size(); i++) {
//			int min = list.get(i);
//			for (int j = i; j < list.size(); j++) {
//				int value = list.get(j);
//				if (value < min) {
//					list.set(j, min);
//					list.set(i,  value);
//					min = value;
//				}
//			}
//		}
		Collections.sort(list);
		
		// swap to create the wave
		for (int i = 1; i < list.size(); i = i+2) {
			Integer temp = list.get(i);
			list.set(i, list.get(i-1));
			list.set(i-1, temp);
		}
		return list;
	}
	
	/*
	 * Pascal Triangle Rows
	 */
	public ArrayList<ArrayList<Integer>> generatePascalTriangle(int a) {
		ArrayList<ArrayList<Integer>> triangles = new ArrayList<ArrayList<Integer>>(a);
		if (a == 0) {
			return triangles;
		}
		
		// first one
		ArrayList<Integer> previous = new ArrayList<Integer>(1);
		previous.add(1);
		triangles.add(previous);
		for (int i = 1; i < a; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>(i+1);
			list.add(1);
			for (int j = 1; j < i; j++) {
				int sum = previous.get(j) + previous.get(j-1);
				list.add(sum);
			}
			list.add(1);
			triangles.add(list);
			previous = list;
		}
		return triangles;
	}
	
	/*
	 * Max Sum Contiguous SubarrayBookmark Suggest Edit
	 * Correct, but time limit exceeded.
	 * TODO: try recursion
	 */
	public int maxSubArray(final List<Integer> a) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < a.size(); i++) {
			int sum = a.get(i);
			if (sum > max) {
				max = sum;
			}
			
			for (int j = i + 1; j < a.size(); j++) {
				sum += a.get(j);
				if (sum > max) {
					max = sum;
				}
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		new ArrayBit();
	}
}
