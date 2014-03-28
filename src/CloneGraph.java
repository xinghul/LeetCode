import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class CloneGraph {
	static Map<UndirectedGraphNode, UndirectedGraphNode> nodes;
	public static void main(String[] args) {
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		
		n0.neighbors.add(n1);
		n0.neighbors.add(n2);
		
		n1.neighbors.add(n2);
		
		n2.neighbors.add(n2);
		
		cloneGraph(n0);
		
		System.out.println(n2.neighbors.size());
	}
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		nodes = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		ExploreNeighbors(node);

		for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : nodes.entrySet())
		{
			UndirectedGraphNode orig = entry.getKey();
			UndirectedGraphNode dest = entry.getValue();
			for (UndirectedGraphNode tmp : orig.neighbors) 
			{
				dest.neighbors.add(nodes.get(tmp));
			}
		}
		
		UndirectedGraphNode newRoot = nodes.get(node);
		return newRoot;
		
	}
	private static void ExploreNeighbors(UndirectedGraphNode node) {
		System.out.println("Exploring : " + node.label);
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		nodes.put(node, newNode);
		ArrayList<UndirectedGraphNode> neighbors = node.neighbors;
		for (int i = 0; i < neighbors.size(); i ++) 
		{
			if (nodes.containsKey(neighbors.get(i)))
				continue;
			ExploreNeighbors(neighbors.get(i));
		}
	}
	
	static class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		public UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
}
