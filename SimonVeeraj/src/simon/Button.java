package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.component.Action;

public abstract class Button implements ButtonInterfaceVeeraj,Runnable {
	int x;
	int y;
	Color color;
	Action a;
	private Graphics2D circle;
	
	
	
	public Button() {
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
	
}
