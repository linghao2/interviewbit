package interviewbit;

public class LinkedListBit {
	
	public LinkedListBit() {
		ListNode node1 = new ListNode(1);
		ListNode node1too = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node3too = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node1too;
		node1too.next = node2;
		node2.next = node3;
		node3.next = node3too;
		node3too.next = node4;

		//printNode(reverseList(node1, 2));
		//printNode(deleteDuplicates(node1));
		
		/*
		ListNode rootNode = null;
		ListNode prevNode = null;
		for (int i = 0; i < 6; i++) {
			ListNode node = new ListNode(i+1);
			if (prevNode == null) {
				rootNode = node;
				prevNode = node;
			} else {
				prevNode.next = node;				
				prevNode = node;
			}
		}
		printNode(rootNode);
		printNode(reverseListCount(rootNode,3));
		*/
		
		/*
		int[] val1 = {2,4,3};
		int[] val2 = {5,6,4,0,1};
		ListNode a = convertToListNode(val1);
		ListNode b = convertToListNode(val2);
		printNode(a);
		printNode(b);
		printNode(addTwoNumbers(a,b));
		*/
		
		int[] val = {668,90,22,33,1,222,333,5};
		ListNode a = convertToListNode(val);
		printNode(partition(a, 1));
	}
	
	public ListNode partition(ListNode a, int b) {
		ListNode smaller = null;
		ListNode smallerLast = null;
		ListNode larger = null;
		ListNode largerLast = null;
		ListNode node = a;
		while (node != null) {
			ListNode nextNode = node.next;
			if (node.val >= b) {
				if (larger == null) {
					larger = node;
					largerLast = node;
					node.next = null;
				} else {
					largerLast.next = node;
					largerLast = node;
					node.next = null;
				}
			} else if (node.val < b) {
				if (smaller == null) {
					smaller = node;
					smallerLast = node;
					node.next = null;
				} else {
					smallerLast.next = node;
					smallerLast = node; 
					node.next = null;
				}
			}
			
			node = nextNode;
		}
		
		if (smallerLast != null) {
			smallerLast.next = larger;
		}
		
		return (smaller != null) ? smaller : larger;
	}
	
	public ListNode convertToListNode(int[] vals) {
		ListNode root = null;
		ListNode next = null;
		for (int i = 0; i < vals.length; i++) {
			ListNode node = new ListNode(vals[i]);
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
	public void printNode(ListNode a) {
		if (a == null) {
			return;
		}
		
		ListNode node = a;
		while (node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}
		
		System.out.println("");

	}

	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode sumNode = null;
		ListNode headNode = null;
		int carry = 0;
		
		while (a != null || b!= null) {
			int valA = 0;
			int valB = 0;
			if (a != null) {
				valA = a.val;
				a = a.next;
			}
			if (b != null) {
				valB = b.val;
				b = b.next;				
			}
			int sum = valA + valB + carry;
			carry = 0;
			if (sum >= 10) {
				sum = sum - 10;
				carry = 1;
			}
			ListNode valNode = new ListNode(sum);
			if (headNode == null) {
				headNode = valNode;
				sumNode = valNode;
			} else {
				sumNode.next = valNode;
				sumNode = valNode;
			}
		}
		if (carry > 0) {
			ListNode valNode = new ListNode(carry);
			sumNode.next = valNode;			
		}
		return headNode;
	}
	
	
	public ListNode reverseListCount(ListNode A, int B) {
		ListNode node = A;
		ListNode previous = null;
		int count = 1;
		while (node != null & count <= B) {
			ListNode nextNode = node.next;
			node.next = previous;
			previous = node;
			node = nextNode;
			count++;
		}
		
		if (node != null) {
			A.next = reverseListCount(node, B);
		}
		return previous;
	}
	
	public ListNode reverseList2(ListNode A, int B) {
		ListNode headNode = null;
		ListNode nextHeadNode = A;
		ListNode prevNode = null;
		ListNode prevTailNode = null;
		ListNode node = A;
		int count = 1;
		while (node != null) {
			ListNode nextNode = node.next;
			node.next = prevNode;
			if (count == B) {
				count = 1;
				prevNode = null;
				if (prevTailNode != null) {
					prevTailNode.next = node;
				}
				prevTailNode = nextHeadNode;
				nextHeadNode = nextNode;
				if (headNode == null) {
					headNode = node;					
				}
			} else {
				prevNode = node;
				count++;
			}
			node = nextNode;
		}
		return headNode;
	}
	
	public ListNode deleteDuplicates(ListNode a) {
		
		if (a == null) {
			return a;
		}
		
		ListNode currentNode = a;
		while (currentNode != null) {
			if (currentNode.next != null) {
				if (currentNode.val == currentNode.next.val) {
					currentNode.next = currentNode.next.next;
				} else {
					currentNode = currentNode.next;				
				}
			} else {
				currentNode = currentNode.next;				
			}
		} 
		
		return a;
	}
	
	public static void main(String[] args) {
		new LinkedListBit();
	}
	
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
