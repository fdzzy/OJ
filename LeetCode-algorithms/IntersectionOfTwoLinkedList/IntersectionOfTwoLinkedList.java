/*
 * Intersection of Two Linked Lists
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * 
 * begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 */
public class IntersectionOfTwoLinkedList {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lengthA = 0, lengthB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA != null) {
        	lengthA++;
        	nodeA = nodeA.next;
        }
        while(nodeB != null) {
        	lengthB++;
        	nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if(lengthA > lengthB) {
        	for(int diff=lengthA-lengthB; diff > 0 ; diff--) {
        		nodeA = nodeA.next;
        	}
        } else if (lengthA < lengthB) {
        	for(int diff=lengthB-lengthA; diff > 0 ; diff--) {
        		nodeB = nodeB.next;
        	}
        }
        while(nodeA != nodeB) {
        	nodeA = nodeA.next;
        	nodeB = nodeB.next;
        }
        return nodeA;
    }
    
    public static void main(String[] args) {
    	ListNode c1 = new ListNode(1);
    	c1.next = new ListNode(2);
    	c1.next.next = new ListNode(3);
    	ListNode a1 = new ListNode(11);
    	a1.next = new ListNode(12);
    	a1.next.next = c1;
    	ListNode b1 = new ListNode(21);
    	b1.next = new ListNode(22);
    	b1.next.next = new ListNode(23);
    	b1.next.next.next = c1;
    	
    	IntersectionOfTwoLinkedList in = new IntersectionOfTwoLinkedList();
    	ListNode inter = in.getIntersectionNode(a1, b1);
    	System.out.println(inter.val);
    }

}
