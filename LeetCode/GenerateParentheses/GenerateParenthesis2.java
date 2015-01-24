import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class GenerateParenthesis2 {
	
	static class Item {
		public int leftStackCount = 0;
		public int leftUsed = 0;
		public int totalUsed = 0;
		public String prefix = null;
		public Item(int leftStackCount, int leftUsed, int totalUsed,
				String prefix) {
			this.leftStackCount = leftStackCount;
			this.leftUsed = leftUsed;
			this.totalUsed = totalUsed;
			this.prefix = prefix;
		}
	}

    public List<String> generateParenthesis(int n) {
    	if(n <= 0) return null;
    	List<String> result = new ArrayList<>();
    	Queue<Item> itemQueue = new LinkedList<>();
    	itemQueue.add(new Item(1, 1, 1, "("));
    	while(!itemQueue.isEmpty()) {
    		Item item = itemQueue.remove();
    		if(item.totalUsed == n*2) {
    			result.add(item.prefix);
    			continue;
    		}
    		if(item.leftStackCount == 0) {
    			// only allowed to use left parenth
    			itemQueue.add(new Item(1, item.leftUsed+1, item.totalUsed+1, item.prefix + "("));
    		} else if (item.leftUsed == n) {
    			// only allowed to use right parenth
    			itemQueue.add(new Item(item.leftStackCount-1, item.leftUsed, item.totalUsed+1, item.prefix + ")"));
    		} else {
    			// Choose left
    			itemQueue.add(new Item(item.leftStackCount+1, item.leftUsed+1, item.totalUsed+1, item.prefix + "("));
    			// Choose right
    			itemQueue.add(new Item(item.leftStackCount-1, item.leftUsed, item.totalUsed+1, item.prefix + ")"));
    		}
    	}
    	
    	return result;
    }

	public static void main(String[] args) {
		GenerateParenthesis2 g = new GenerateParenthesis2();
		List<String> result = g.generateParenthesis(4);
		System.out.println("size: " + result.size());
		System.out.println(result);
	}

}
