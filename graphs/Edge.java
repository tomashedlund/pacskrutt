package graphs;
import java.io.*;

public class Edge<TYPE> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5832613799129544985L;
	private TYPE destination;
	private String transport;
	private int weight;
	
	public Edge(TYPE destination, String transport, int weight){
		this.destination = destination;
		this.transport = transport;
		this.weight = weight;
	}
	public TYPE getDestination(){
		return destination;
	}
	public String getName(){
		return this.transport;
	}
	public int getWeight(){
		return this.weight;
	}
	public void setWeight(int weight){
		if (weight < 0)
			throw new IllegalArgumentException();
		this.weight = weight;
	}
	@Override
	public String toString(){
		return this.transport + " till " + this.destination + " (" + this.weight + ")";
	}
}