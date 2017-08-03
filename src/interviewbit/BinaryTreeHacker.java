package interviewbit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinaryTreeHacker {
	public BinaryTreeHacker() {
		int[] nums = {2, 10, 5, 4, 8};
		int[] maxes = {3,1,7,8};
		int[] counts = counts(nums, maxes);
		
		for (int count : counts) {
			System.out.println(count);
		}
		/*
		int[] values = {1,3,2};
		boolean is1 = isPreorder(values);
		int[] values2 = {3,4,5,1,2};
		boolean is2 = isPreorder(values2);
		System.out.println("is1: " + is1 + " is2: " + is2);
		*/
	}
	int[] counts(int[] nums, int[] maxes) {
		int[] results = new int[maxes.length];
		Arrays.sort(nums);
		for (int i = 0; i < maxes.length; i++) {
			results[i] = getCounts(nums, maxes[i]);
		}
		return results;
	}
	
	int getCounts(int[] nums, int max) {
		int lo = 0;
		int hi = nums.length - 1;
		while (lo <= hi) {
			int mid = ((hi-lo)/2) + lo;
			if (nums[mid] > max) {
				hi = mid-1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	
	static void createBST(int[] keys) {
		int counter = 0;
		TreeNode root = null;
		
		for (int key : keys) {
			if (root != null) {
				counter = insert(root, key, counter);
			} else {
				root = new TreeNode(key);
			}
			System.out.println(counter);
		}
	}
	
	static int insert(TreeNode root, int key, int counter) {
		counter++;
		
		if (key < root.val) {
			if (root.left == null) {
				root.left = new TreeNode(key);
			} else {
				counter = insert(root.left, key, counter);
			}
		} else {
			if (root.right == null) {
				root.right = new TreeNode(key);
			} else {
				counter = insert(root.right, key, counter);
			}
		}
		return counter;
	}
	
	static boolean isPreorder(int[] order) {
		boolean isPre = true;
		if (order == null || order.length == 1) {
			return true;
		}
		int val = order[0];
		int left = -1;
		int right = -1;
		for (int i = 1; i < order.length; i++) {
			if (order[i] < val) {
				left = i;
			} else {
				break;
			}
		}
		int start = left == -1 ? 1 : left + 1;
		for (int i = start; i < order.length; i++) {
			if (order[i] > val) {
				right = i;
			} else {
				break;
			}
		}
		int lastIndex = order.length-1;
		if (left != lastIndex && right != lastIndex) {
			return false;
		}
		
		if (left != -1) {
			boolean isLeft = isPreorder(Arrays.copyOfRange(order, 1, left+1));
			if (!isLeft) {
				return false;
			}
		}
		if (right != -1) {
			boolean isRight = isPreorder(Arrays.copyOfRange(order, start, right+1));
			if (!isRight) {
				return false;
			}
		}
		return isPre;
	}
	
	static int[] parseLine(String line) {
		String[] tokens = line.split(" ");
		int[] nums = new int[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			nums[i] = Integer.parseInt(tokens[i]);
		}
		return nums;
	}
	public static void main(String[] args) {
		new BinaryTreeHacker();
		/*
		int[] keys = {1,2,3};
		createBST(keys);
		try {
			BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
			int numLines = Integer.parseInt(br.readLine());
			for (int i = 0; i < numLines; i++) {
				int numNodes = Integer.parseInt(br.readLine());
				String line = br.readLine();
				int[] values = parseLine(line);
				boolean preorder = isPreorder(values);
				System.out.println(preorder ? "YES" : "NO");
			}
		} catch (Exception e) {
			
		}
		*/

	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}


}
