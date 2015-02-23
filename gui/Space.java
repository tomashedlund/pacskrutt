package gui;
import java.awt.Point;

public interface Space {
	public boolean occupied();
	public boolean perceivedOccupied();
	public Point getOrigo();
	public Point getPoint();
	public boolean isAdjacent(Space space);
}
