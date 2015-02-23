package gui;
import javax.swing.*;
import java.awt.*;

public class DrawKeyImage extends JPanel {
	private static final long serialVersionUID = 7307111817233940155L;
	private ImageIcon picture;
	public DrawKeyImage(String filename) {
		this.picture = new ImageIcon(filename);
		setBackground(Color.BLACK);
		setLayout(null);
	}
	public Dimension getPreferredSize(){
		return new Dimension(picture.getIconWidth(),picture.getIconHeight());
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.picture.getImage(), 0, 0, this);
	}
}