package interviewbit;

public class LinkedListHacker {
	public LinkedListHacker() {
		int[] vals = {5,2,1,6,7};
		LinkedListNode nodes = convertToLinkedListNode(vals);
		printNode(removeNodes(nodes, 0));
	}
	
	public LinkedListNode removeNodes(LinkedListNode list, int x) {
		LinkedListNode head = list;
		LinkedListNode prev = null;
		LinkedListNode current = list;
		
		while (current != null) {
			if (current.val > x) {
				if (head == current) {
					head = current.next;
				} 
				if (prev != null) {
					prev.next = null;
				}
			} else {
				if (prev != null) {
					prev.next = current;
				}
				prev = current;
			}
			current = current.next;
		}
		return head;
	}
	
	public LinkedListNode convertToLinkedListNode(int[] vals) {
		LinkedListNode root = null;
		LinkedListNode next = null;
		for (int i = 0; i < vals.length; i++) {
			LinkedListNode node = new LinkedListNode(vals[i]);
			if (next == null) {
				root = node;
				next = node;
			} else {
				next.next = node; 
				next = node;
			}
		}
		return root;
	}
	public void printNode(LinkedListNode a) {
		if (a == null) {
			return;
		}
		
		LinkedListNode node = a;
		while (node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}
		
		System.out.println("");

	}
	
	public static class LinkedListNode {
		public int val;
		public LinkedListNode next;
		LinkedListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		new LinkedListHacker();
	}


}
