import java.awt.Color;
import java.awt.Rectangle;

public abstract class Area extends Rectangle {
private Color color;
	
	public Area(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;
	}


	

}
