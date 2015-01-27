/*
 * Remove Duplicates from Sorted List 
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
    	ListNode node = head;
    	while(node != null && node.next != null) {
    		ListNode next = node.next;
    		while(next != null && next.val == node.val) next = next.next;
    		node.next = next;
    		node = next;
    	}
    	return head;
    }

    public static void main(String[] args) {
		ListNode node = new ListNode(5);
		node = ListNode.addNodeAhead(node, 2);
		node = ListNode.addNodeAhead(node, 2);
		node = ListNode.addNodeAhead(node, 1);
		node = ListNode.addNodeAhead(node, 1);
	
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		ListNode head = r.deleteDuplicates(node);
		System.out.println(head);
		
    }

}
