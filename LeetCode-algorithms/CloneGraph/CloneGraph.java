/*
 * Clone Graph 
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list 
 * of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label and 
 * each neighbor of the node.
 * 
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as 
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a 
 * self-cycle.
 * Visually, the graph looks like the following:
 * 
 *     1
 *    / \
 *   /   \
 *  0 --- 2
 *       / \
 *       \_/
 */
import java.util.HashMap;
import java.util.Map;


public class CloneGraph {
	
	private UndirectedGraphNode cloneSub(UndirectedGraphNode node, 
			Map<Integer, UndirectedGraphNode> newNodes) {
		UndirectedGraphNode newNode = newNodes.get(node.label);
		if(newNode != null) return newNode;

		newNode = new UndirectedGraphNode(node.label);
		newNodes.put(node.label, newNode);
		for(UndirectedGraphNode neighbor : node.neighbors) {
			newNode.neighbors.add(cloneSub(neighbor, newNodes));
		}
		return newNode;
	}

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) return null;
      
    	Map<Integer, UndirectedGraphNode> newNodes = new HashMap<>();
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		newNodes.put(node.label, newNode);
		for(UndirectedGraphNode neighbor : node.neighbors) {
			newNode.neighbors.add(cloneSub(neighbor, newNodes));
		}
		return newNode;
    }
    
    public static void main(String[] args) {
		//String str = "{0,1,2#1,2#2,2}";
		//String str = "{0,1,2,3#1,2#2,2#3}";
		String str = "{1,1}";
		UndirectedGraphNode node = UndirectedGraphNode.readGraph(str);
		System.out.println(node);
		CloneGraph c = new CloneGraph();
		UndirectedGraphNode clone = c.cloneGraph(node);
		System.out.println(clone);
    }
}
