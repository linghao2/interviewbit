package interviewbit;

import java.util.*;

public class Test {
	
	public Test() {
		//testSubtract();
		ArrayList<Integer> a = new ArrayList<Integer>(3);
		a.add(1);
		a.add(2);
		a.add(3);
		
		ArrayList<ArrayList<Integer>> perms = testPermutation(a);
		for (int i = 0; i < perms.size(); i++) {
			System.out.println(perms.get(i));	
		}
	}
	
	ArrayList<ArrayList<Integer>> testPermutation(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        int[] perm = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			perm[i] = i;
		}
		ArrayList<Integer> one = new ArrayList<Integer>(a);
		list.add(one);
		
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		set.add(one);

		while (perm != null) {
			int[] nextPerm = nextPermutation(perm);
			
			if (nextPerm != null) {
				ArrayList<Integer> next = new ArrayList<Integer>();
				for (int i = 0; i < nextPerm.length; i++) {
					next.add(a.get(nextPerm[i]));
				}
				
				if (!set.contains(next)) {
					list.add(next);
					set.add(next);
				}
			}
			
			perm = nextPerm;
		}
		return list;
	}
	
	int[] nextPermutation(int[] current) {
		int[] perm = new int[current.length];
		System.arraycopy(current, 0, perm, 0, current.length);
		
		int point = perm.length - 2;
		while (point >= 0 && perm[point] >= perm[point+1]) {
			point--;
		}
		if (point < 0) {
			return null;
		}
		
		for (int i = perm.length - 1; i > point; --i) {
			if (perm[i] > perm[point]) {
				int temp = perm[point];
				perm[point] = perm[i];
				perm[i] = temp;
				break;
			}
		}
		
		int start = point + 1;
		int end = perm.length - 1;
		while (start <= end) {
			int temp = perm[start];
			perm[start] = perm[end];
			perm[end] = temp;
			start++;
			end--;
		}
		
		return perm;
	}
	
	void testSubtract() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		subtract(node1);		
	}
	
	public ListNode subtract(ListNode A) {
		ListNode node = A;
		ListNode nextNode = new ListNode(node.val);
		int count = 1;
		while (node.next != null) {
			ListNode newNode = new ListNode(node.next.val);
			newNode.next = nextNode;
			nextNode = newNode;
			node = node.next;
			count++;
		}

		count = (int) Math.floor(count/2);
		node = A;
		for (int i = 0; i < count; i++) {
			node.val = nextNode.val - node.val;
			node = node.next;
			nextNode = nextNode.next;
		}
		return A;
	}
	
	public void printNode(ListNode A) {
		ListNode node = A;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println("");
	}
	

	
	public static int[][] prettyPrint(int a) {
		int count = a + a - 1;
        int[][] list = new int[count][count];
        int current = a;
        for (int i = 0; i < a; i++) {
        		System.out.println("Loop " + i);
            int num = current + current - 1;
            for (int x = i; x < num + i; x++) {
            		System.out.println("x " + x);
                list[i][x] = current;
                list[i+num-1][x] = current;
                list[x][i] = current;
                list[x][i+num-1] = current;
            }
            current -= 1;
        }
        return list;
	}
	
	public static int numRange(int[] A, int B, int C) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			int value = A[i];
			if (value < C) {
				int sum = value;
				if (B <= sum && sum <= C) {
					count++;
				}
				for (int j = i+1; j < A.length; j++) {
					sum += A[j];
					if (B <= sum && sum <= C) {
						count++;
					}
					if (sum > C) {
						break;
					}
				}
			}
		}
		return count;
	}

	// TODO answer correct, but didn't pass time test. 
	// instead of selection sort use heap sort instead
	public static int kthsmallest(final int[] A, int B) {
		int[] arr = new int[A.length];
		System.arraycopy(A, 0, arr, 0, A.length);
		System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i < B; i++) {
			int minVal = arr[i];
			int minIndex = i;
			for (int j = i+1; j < A.length; j++) {
				if (arr[j] < minVal) {
					minVal = arr[j];
					minIndex = j;
				}
			}
			int tempVal = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tempVal;
			
			System.out.println(Arrays.toString(arr));
		}
		
		return arr[B-1];
	}
	

	public static void main(String[] args) {
//		int[][] list = prettyPrint(3);
//		for (int i = 0; i < list.length; i++) {
//			for (int j = 0; j < list.length; j++) {
//				System.out.print(list[i][j]);				
//			}
//			System.out.println();
//		}
		// answer should be 84
//		int[] A = {76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66};
//		int B = 98;
//		int C = 290;
//		int range = numRange(A, B, C);
//		System.out.println(range);
		
//		int[] A = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
//		int B = 9;
//		int kth = kthsmallest(A, B);
//		System.out.println(kth);
		
		new Test();
	}
	
	class ListNode {
		public int val;
		public ListNode next;
		
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
}
