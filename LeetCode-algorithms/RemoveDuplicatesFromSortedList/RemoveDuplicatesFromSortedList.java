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
    
    public ListNode deleteDuplicatesII(ListNode head) {
    	boolean duplicate = false;
    	while(true) {
    		duplicate = false;
			while (head != null && head.next != null
					&& head.next.val == head.val) {
				duplicate = true;
				head = head.next;
			}
			if(duplicate) head = head.next;
			else break; 
    	}
    	if(duplicate) head = head.next;
    	if(head == null) return null;

    	ListNode node = head;
    	while(node != null && node.next != null && node.next.next != null) {
    		if(node.next.val == node.next.next.val) {
				ListNode iter = node.next.next;
				while (iter.next != null && iter.next.val == iter.val)
					iter = iter.next;
				node.next = iter.next;
    		} else {
    			node = node.next;
    		}
    	}
    	
    	return head;
    }

    public static void main(String[] args) {
		ListNode node = new ListNode(5);
		node = ListNode.addNodeAhead(node, 4);
		node = ListNode.addNodeAhead(node, 4);
		node = ListNode.addNodeAhead(node, 3);
		node = ListNode.addNodeAhead(node, 3);
		node = ListNode.addNodeAhead(node, 2);
		//node = ListNode.addNodeAhead(node, 1);
		node = ListNode.addNodeAhead(node, 1);
	
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		//ListNode head = r.deleteDuplicates(node);
		ListNode head = r.deleteDuplicatesII(node);
		System.out.println(head);
    }

}
