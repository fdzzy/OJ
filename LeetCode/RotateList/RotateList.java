/*
 * Rotate List 
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
import java.util.Stack;


class ListNode {
	int val;
	ListNode next;
	
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode head = this;
		while(head != null) {
			sb.append(head.val + " ");
			head = head.next;
		}
		return sb.toString();
	}
}

public class RotateList {
	
	/* Using stack
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null || n <= 0) return null;
    	// Put into stack
    	Stack<ListNode> stack = new Stack<>();
    	ListNode node = head;
    	while(node != null){
    		stack.push(node);
    		node = node.next;
    	}
    	n %= stack.size();
    	if(n == 0) return head;
    	// Link last to first
    	ListNode last = stack.peek();
    	last.next = head;
    	// Set last n to head 
    	for(int i=0; i<n ; ++i) {
    		node = stack.pop();
    	}
    	head = node;
    	// Set last (n+1)'s next to null
    	node = stack.pop();
    	node.next = null;
    	return head;
    }*/
	
	/*
	 * Better version
	 */
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n <= 0) return head;		
		
		ListNode node1 = head;
		ListNode node2 = head;
		for(int i=0; i<n ; ++i) {
			if(node2.next != null) {
				node2 = node2.next;
			} else {
				// round back
				node2 = head;
			}
		}
		
		while(node2.next != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		node2.next = head;
		node2 = node1.next;
		node1.next = null;
		return node2;
	}
    
    public static ListNode makeList(int[] array) {
    	ListNode head = null;
    	for(int i=array.length-1; i>=0 ; --i) {
    		ListNode node = new ListNode(array[i]);
    		node.next = head;
    		head = node;
    	}
    	return head;
    }
    
    public static void main(String[] args) {
    	RotateList r = new RotateList();
    	int[] array = {1,2,3,4,5};
    	ListNode head = makeList(array);
    	head = r.rotateRight(head, 2);
    	System.out.println(head);
    }

}
