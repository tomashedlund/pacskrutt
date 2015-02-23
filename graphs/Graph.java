package graphs;
import java.util.List;

public interface Graph<TYPE> {
	public abstract void add(TYPE city);
	public abstract void connect(TYPE from, TYPE to, String name, int weight);
	public abstract void setConnectionWeight(TYPE from, TYPE to, int weight);
	public abstract List<TYPE> getNodes();
	public abstract List<Edge<TYPE>> getEdgesFrom(TYPE city); 
	public abstract Edge<TYPE> getEdgeBetween(TYPE from, TYPE to);
	public abstract void remove(TYPE node);
	public abstract void disconnect(TYPE from, TYPE to);
}