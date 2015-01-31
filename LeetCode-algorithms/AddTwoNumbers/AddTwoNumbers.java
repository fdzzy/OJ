/*
 * Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	
    	int sum = l1.val + l2.val;
    	ListNode head = new ListNode(sum % 10);
    	int carry = sum/10;
    	ListNode current = head;
    	l1 = l1.next;
    	l2 = l2.next;
    	while(l1 != null && l2 != null) {
    		sum = l1.val + l2.val + carry;
    		carry = sum / 10;
    		current.next = new ListNode(sum % 10);
    		current = current.next;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
        while(l1 != null) {
    		sum = l1.val + carry;
    		carry = sum / 10;
    		current.next = new ListNode(sum % 10);
    		current = current.next;
    		l1 = l1.next;
        }
        while(l2 != null) {
    		sum = l2.val + carry;
    		carry = sum / 10;
    		current.next = new ListNode(sum % 10);
    		current = current.next;
    		l2 = l2.next;
        }
        if(carry != 0) {
        	current.next = new ListNode(carry);
        }
        return head;
    }
    
    public static void main(String[] args) {
    	AddTwoNumbers a = new AddTwoNumbers();
    	int[] nums1 = {1,3,4,5,9,9}; 
    	int[] nums2 = {2,6,7,9};
    	ListNode l1 = ListNode.readList(nums1);
    	ListNode l2 = ListNode.readList(nums2);
    	System.out.println(a.addTwoNumbers(l1, l2));
    }
}
