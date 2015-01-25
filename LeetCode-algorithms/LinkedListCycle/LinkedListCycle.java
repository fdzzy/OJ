/*
 * Linked List Cycle
 * 
 * I.
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * 
 * Can you solve it without using extra space?
 * 
 * II.
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * 
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	while(true) {
    		if(fast == null || fast.next == null || fast.next.next == null)
    			return false;
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast == slow) return true;
    	}
    }
    
    public ListNode detectCycle(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	while(true) {
    		if(fast == null || fast.next == null || fast.next.next == null)
    			return null;
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast == slow) break;
    	}
    	slow = head;
    	while(slow != fast) {
    		slow = slow.next;
    		fast = fast.next;
    	}
    	return slow;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(5);
    	head.next = new ListNode(3);
    	head.next.next = new ListNode(9);
    	head.next.next.next = head;
        LinkedListCycle l = new LinkedListCycle();
        System.out.println(l.hasCycle(head));
        System.out.println(l.detectCycle(head).val);
    }
}
