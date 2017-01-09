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
	final static int width = 50;
	final static int height = 50;
	
	public Button() {
		super(0, 0, width, height);
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
		this.x = i;
	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub
		this.y = i;
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		circle.setColor(color);
		circle.fillOval(x, y, 50, 50);
		circle.setColor(Color.BLACK);
		circle.drawOval(x, y, 50, 50);
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
		
	}




	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
