/*
 * Merge Two Sorted Lists 
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be
 * made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;

    	ListNode head;
    	if(l1.val < l2.val) {
    		head = l1;
    		l1 = l1.next;
    	} else {
    		head = l2;
    		l2 = l2.next;
    	}
    	ListNode current = head;
    	while(l1 != null && l2 != null) {
    		if(l1.val < l2.val) {
    			current.next = l1;
    			current = current.next;
    			l1 = l1.next;
    		} else {
    			current.next = l2;
    			current = current.next;
    			l2 = l2.next;
    		}
    	}
    	while(l1 != null) {
    		current.next = l1;
    		current = current.next;
    		l1 = l1.next;
    	}
    	while(l2 != null) {
    		current.next = l2;
    		current = current.next;
    		l2 = l2.next;
    	}
    	current.next = null;
    	return head;
    }
    
    public static void main(String[] args) {
    	MergeTwoSortedLists m = new MergeTwoSortedLists();
    	int[] nums1 = {1,3,4,5,9}; 
    	int[] nums2 = {2,6,7,10,12,15};
    	ListNode l1 = ListNode.readList(nums1);
    	ListNode l2 = ListNode.readList(nums2);
    	System.out.println(m.mergeTwoLists(l1, l2));
    }
}
