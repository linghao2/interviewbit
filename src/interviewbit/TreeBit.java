package interviewbit;

import java.util.*;

public class TreeBit {
	public TreeBit() {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		one.right = two;
		two.left = three;
		
		TreeNode one2 = new TreeNode(1);
		TreeNode two2 = new TreeNode(4);
		TreeNode three2 = new TreeNode(3);
		one2.right = two2;
		two2.left = three2;

		/*
		ArrayList<Integer> list = inorderTraversalO1(one);
		System.out.println(list);
		*/
		int isSame = isSameTree(one, one2);
		System.out.println(isSame);
		
		Integer[] values = {1,2,3,4,5,6};
		TreeNode root = sortedArrayToBST(Arrays.asList(values));
		ArrayList<Integer> result = inorderTraversalO1(root);
		System.out.println(result);
		
		System.out.println(kthsmallest(root, 4));
	}
	
	public int kthsmallest(TreeNode root, int k) {
		return inorder(root, k, new ArrayList<Integer>());
    }
	
	Integer inorder(TreeNode root, int k, List<Integer> array) {
		if (root.left != null) {
			Integer val = inorder(root.left, k, array);
			if (val != null) {
				return val;
			}
		}
		
		System.out.println(root.val);
		if (array.size()+1 == k) {
			return root.val;
		} else {
			array.add(root.val);
		}

		if (root.right != null) {
			return inorder(root.right, k, array);
		}
		
		return null;
	}
	
	public TreeNode sortedArrayToBST(final List<Integer> a) {
		int size = a.size();
		if (size == 1) {
			return new TreeNode(a.get(0).intValue());
		} else if (size == 2) {
			TreeNode node = new TreeNode(a.get(0).intValue());
			node.right = new TreeNode(a.get(1).intValue());
			return node;
		}
		int mid = (int)Math.floor(size/2); 
		TreeNode node = new TreeNode(a.get(mid).intValue());
		node.left = sortedArrayToBST(a.subList(0, mid));
		node.right = sortedArrayToBST(a.subList(mid+1, a.size()));
		return node;
	}
	
	
	public int isSameTree(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return 1;
		}
		if (a == null || b == null) {
			return 0;
		}
		if (a.val != b.val) {
			return 0;
		}
		
		int isSameLeft = isSameTree(a.left, b.left);
		int isSameRight = isSameTree(a.right, b.right);
		return (isSameLeft == 1 && isSameRight == 1) ? 1 : 0;
	}

	// inorder iterative O(1)
	public ArrayList<Integer> inorderTraversalO1(TreeNode a) {
		TreeNode current, node;
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    current = a;
	    
	    while (current != null) {
	        
	        if (current.left == null) {
	            res.add(current.val);
	            current = current.right;
	        } else {
	            
	            node = current.left;
	            while (node.right != null && !current.equals(node.right))
	                node = node.right;
	            
	            if (node.right == null) {
	                node.right = current;
	                current = current.left;
	            } else {
	                current = node.right;
	                node.right = null;
	                res.add(current.val);
	                current = current.right;
	            }
	            
	        }
	        
	    }
	    
	    return res;
	    
	}
	
	// inorder iterative using Stack
	public  ArrayList<Integer> inorderTraversal(TreeNode a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = a;
		
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				list.add(node.val);
				node = node.right;
			}
		}
		
		return list;
	}
	
	// inorder recursive 
	public void inorderTraversal(TreeNode a, ArrayList<Integer> list) {
		if (a.left != null) {
			inorderTraversal(a.left, list);
		}
		list.add(a.val);
		if (a.right != null) {
			inorderTraversal(a.right, list);
		}
	}
	
	public static void main(String[] args) {
		new TreeBit();
	}

	class TreeNode {
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
