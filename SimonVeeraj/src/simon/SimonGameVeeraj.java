package simon;

import guiPractice.GUIApplication;

public class SimonGameVeeraj extends GUIApplication {

	public SimonGameVeeraj() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void initScreen() {
		SimonScreenVeeraj ss = new SimonScreenVeeraj(getWidth(), getHeight());
		setScreen(ss);	
	}

	public static void main(String[] args) {
		SimonGameVeeraj game = new SimonGameVeeraj();
		Thread app = new Thread(game);
		app.start();
	}

}
