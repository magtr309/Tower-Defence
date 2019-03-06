import java.awt.Color;

import javax.swing.JPanel;

public class GameSurface extends JPanel {
	private Modell modell = new Modell();

	public GameSurface() {
		this.setBackground(Color.BLUE);
		this.addMouseListener(new MyListener(modell));
		this.setVisible(true);
	}


	public Modell getModell() {
		return modell;
	}
}
