package gui;
import java.awt.*;

public class Block extends GameObject {
	/**
	 * Autogenerated serialVersionUID
	 */
	private static final long serialVersionUID = -9176126706165708219L;

	Block(int x, int y, boolean occupied, boolean perceivedOccupied, int size) {
		super(x, y, occupied, perceivedOccupied, size);
		setBackground(Color.BLUE);
	}
}
