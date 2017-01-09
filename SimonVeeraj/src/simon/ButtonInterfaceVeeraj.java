package simon;

import java.awt.Color;

import guiPractice.component.Action;
import guiPractice.component.Clickable;

public interface ButtonInterfaceVeeraj extends Clickable {

	void setColor(Color color);

	void setX(int i);

	void setY(int i);
	
	void setAction(Action a);

	void highlight();

	void dim();



}
