package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.component.Action;
import guiPractice.component.Component;

public class Button extends Component implements ButtonInterfaceVeeraj {

	private Color color;
	private Color currentColor;
	private boolean highlight;
	private Action action;
	private static int width = 50;
	private static int height = 50;
	
	public Button() {
		super(0, 0, 50,50);
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
	}

	@Override
	public void highlight() {
		highlight = true;
		currentColor = color;
		update();
	}

	@Override
	public void dim() {
		currentColor = Color.lightGray;
		highlight = false;
		update();
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+width/2), 2)+Math.pow(y-(getY()+height/2), 2));
		return distance < width/2;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(currentColor != null){
			g.setColor(currentColor);
		}
		else{
			g.setColor(Color.lightGray);
		}
		g.fillOval(0, 0, width, height);
		g.setColor(Color.black);
		g.drawOval(0, 0, width-1, height-1);
		
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
	}

}
