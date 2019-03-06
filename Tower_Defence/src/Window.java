import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window extends JFrame {
private GameMap gameMap;

	public Window(GameMap gameMap) {
		super("Tower Defence 7.0");
        this.gameMap = gameMap;
		this.setSize(1000, 800);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
       
        this.setVisible(true);
	}
}