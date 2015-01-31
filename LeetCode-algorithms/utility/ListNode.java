
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	    val = x;
	    next = null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		ListNode node = this;
		while(node != null) {
			sb.append(node.val + " ");
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}

    public static ListNode addNodeAhead(ListNode node, int val) {
    	ListNode head = new ListNode(val);
    	head.next = node;
    	return head;
    }
    
	public static ListNode readList(int[] nums) {
		if(nums.length <=0) return null;
		ListNode head = null;
		for(int i=nums.length-1; i>=0 ; i--) {
			ListNode node = new ListNode(nums[i]);
			node.next = head;
			head = node;
		}
		return head;
	}
}
