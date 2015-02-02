import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Definition for undirected graph.
public class UndirectedGraphNode {
	
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x;
		neighbors = new ArrayList<>(); 
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Set<UndirectedGraphNode> printed = new HashSet<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(this);
		while(!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.remove();
			if(!printed.contains(cur)) {
				sb.append("node " + cur.label + ": ");
				for(UndirectedGraphNode neighbor : cur.neighbors) {
					sb.append(neighbor.label + " ");
					queue.add(neighbor);
				}
				sb.append("\n");
				printed.add(cur);
			}
		}
		return sb.toString();
	}
	
	public static UndirectedGraphNode readGraph(String str) {
		if(str == null) return null;
		str = str.trim();
		if(str.isEmpty()) return null;
		str = str.substring(1, str.length()-1);
		String[] nodes = str.split("#");
		UndirectedGraphNode first = null;
		Map<Integer, UndirectedGraphNode> graphNodes = new HashMap<>();
		// set up nodes
		for(String nodeStr : nodes) {
			//System.out.println(nodeStr);
			String[] neighborStrs = nodeStr.split(",");
			//System.out.println(Arrays.toString(neighborStrs));
			int label = Integer.parseInt(neighborStrs[0]);
			UndirectedGraphNode node = new UndirectedGraphNode(label);
			graphNodes.put(label, node);
			if(first == null) first = node;
		}
		// set up neighbors
		for(String nodeStr : nodes) {
			String[] neighborStrs = nodeStr.split(",");
			int label = Integer.parseInt(neighborStrs[0]);
			UndirectedGraphNode node = graphNodes.get(label);
			for(int i=1; i<neighborStrs.length ; i++) {
				int neighborLabel = Integer.parseInt(neighborStrs[i]);
				node.neighbors.add(graphNodes.get(neighborLabel));
			}
		}
		return first;
	}
	
	public static void main(String[] args) {
		String str = "{0,1,2#1,2#2,2}";
		UndirectedGraphNode node = readGraph(str);
		System.out.println(node);
	}
}
