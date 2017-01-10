package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.component.Action;
import guiPractice.component.Component;

public class Button extends Component implements ButtonInterfaceVeeraj {

	static int x;
	static int y;
	Color color;
	Action a;
	private Graphics2D circle;
	final static int WIDTH = 25;
	final static int HEIGHT = 25;
	
	public Button() {
		super(0, 0, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}
	
	
	

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color = color;
	}

	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub
		x = i;
	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub
		y = i;
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		circle.setColor(color);
		circle.fillOval(x, y, 50, 50);
		circle.setColor(Color.BLACK);
		circle.drawOval(x, y, 50, 50);
		update();
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		circle.setColor(Color.WHITE);
		circle.fillOval(x, y, 50, 50);
		circle.setColor(Color.BLACK);
		circle.drawOval(x, y, 50, 50);
	}

	@Override
	public void setAction(Action a) {
		// TODO Auto-generated method stub
		this.a = a;
	}




	@Override
	public void act() {
		// TODO Auto-generated method stub
		a.act();
	}




	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+WIDTH/2), 2)+Math.pow(y-(getY()+HEIGHT/2), 2));
		return distance < WIDTH/2;
	}




	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
