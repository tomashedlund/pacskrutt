package graphs;
import java.util.*;

public class GraphMethods {
	
	public static <TYPE> boolean pathExist(TYPE from, TYPE to, Graph<TYPE> graph){
		Set<TYPE> visited = new HashSet<TYPE>();
		dfs(from, visited, graph);
		return visited.contains(to);
	}
	private static <TYPE> void dfs(TYPE where, Set<TYPE> visited,  Graph<TYPE> graph){
		visited.add(where);
		for (Edge<TYPE> e : graph.getEdgesFrom(where)) 
			if (!visited.contains(e.getDestination()))
				dfs(e.getDestination(), visited,graph);
	}
	public static <TYPE> List<Edge<TYPE>> getPath(TYPE from, TYPE to,Graph<TYPE> graph) {
		if (!pathExist(to, from,graph))
			return null;
		Set<TYPE> visited = new HashSet<TYPE>();
		List<Edge<TYPE>> bestpath = new ArrayList<>();
		dfs(to, visited,graph);
		TYPE whereAmI = to;
		
		Map<TYPE, Integer> weight = new HashMap<TYPE, Integer>();
		Map<TYPE, Boolean> isBest = new HashMap<TYPE, Boolean>();
		Map<TYPE, TYPE> whereFrom = new HashMap<TYPE, TYPE>();
		for (TYPE t : visited) {
			weight.put(t, Integer.MAX_VALUE);
			isBest.put(t, false);
			whereFrom.put(t, null);
		}
		weight.put(to, 0);
		isBest.put(to, true);
		
		do {
			List<Edge<TYPE>> neighbour = graph.getEdgesFrom(whereAmI);
			for(Edge<TYPE> e : neighbour)
				if (e.getWeight() + weight.get(whereAmI) < weight.get(e.getDestination())){
					weight.put(e.getDestination(),e.getWeight() + weight.get(whereAmI));
					whereFrom.put(e.getDestination(), whereAmI);
				}
			int cheapest = Integer.MAX_VALUE;
			for(TYPE t : weight.keySet())
				if (weight.get(t) < cheapest && !isBest.get(t)){
					whereAmI = t;
					cheapest = weight.get(t);
				}
			isBest.put(whereAmI, true);
		}while (!isBest.get(from));
		
		whereAmI = from;
		
		while (whereAmI != to) {
			for (Edge<TYPE> e : graph.getEdgesFrom(whereAmI)) 
				if (e.getDestination().equals(whereFrom.get(whereAmI))) {
					bestpath.add(e);
					break;
				}
			whereAmI = whereFrom.get(whereAmI);
		}
		return bestpath;
	}
}