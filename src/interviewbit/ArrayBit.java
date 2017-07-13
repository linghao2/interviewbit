package interviewbit;

import java.util.*;

public class ArrayBit {
	
	public ArrayBit() {
		/*
		//String str = "A man, a plan, a canal: Panama";
		String str = "race a car";
		int isP = isPalindrome(str);
		System.out.println(str + " " + (isP == 0 ? " is NOT a palindrome" : "is a palindrome"));

		Random rand = new Random();
		int value = 2;
		while (value < 3999) {
			String roman = intToRoman(value);
			System.out.println(value + " -> " + roman);		
			value += rand.nextInt(20) + 1;
		}
		
		Integer[] list = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int max = maxSubArray(Arrays.asList(list));
		System.out.println("max: " + max);
		
		ArrayList<ArrayList<Integer>> perms = generatePascalTriangle(5);
		for (int i = 0; i < perms.size(); i++) {
			System.out.println(perms.get(i));	
		}
*/
		//Integer[] list2 = {2, 1, 3, 4, 1, 6, 1, 5, 4,9};
		Integer[] list2 = {1,2,3,4};
		ArrayList<Integer> waveList = wave(Arrays.asList(list2));
		System.out.println(waveList);
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

	public String intToRoman(int a) {
		int thousands = a / 1000;
		int hundreds = (a - (1000 * thousands)) / 100;
		int tens = (a - (1000 * thousands) - (100 * hundreds)) / 10;
		int singles = a - (1000 * thousands) - (100 * hundreds) - (tens * 10);
		
		StringBuffer buf = new StringBuffer();
		
		buf.append(digitToRoman(thousands, new String[]{"M", "?", "?"}));
		buf.append(digitToRoman(hundreds, new String[]{"C", "D", "M"}));
		buf.append(digitToRoman(tens, new String[]{"X", "L", "C"}));
		buf.append(digitToRoman(singles, new String[]{"I", "V", "X"}));
		
		return buf.toString();
	}
	
	public String digitToRoman(int digit, String map[]) {
		StringBuffer buf = new StringBuffer();
		if (digit <= 3) {
			for (int i = 0; i < digit; i++) {
				buf.append(map[0]);
			}
		} else if (digit == 4) {
			buf.append(map[0] + map[1]);
		} else if (digit == 5) {
			buf.append(map[1]);
		} else if (digit < 9) {
			buf.append(map[1]);
			for (int i = 5; i < digit; i++) {
				buf.append(map[0]);
			}
		} else if (digit == 9) {
			buf.append(map[0] + map[2]);			
		}
		return buf.toString();
	}
	
	public int isPalindrome(String a) {
		StringBuffer buf = new StringBuffer();
		for (char c : a.toCharArray()) {
			if (Character.isDigit(c) || Character.isAlphabetic(c)) {
				buf.append(Character.toLowerCase(c));
			}
		}
		
		String str = buf.toString();
		int start = 0;
		int end = str.length()-1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return 0;
			}
			start++;
			end--;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		new ArrayBit();
	}
}
