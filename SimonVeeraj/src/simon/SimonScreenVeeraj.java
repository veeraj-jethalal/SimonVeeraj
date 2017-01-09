package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.component.Action;
import guiPractice.component.TextLabel;
import guiPractice.component.Visible;

public class SimonScreenVeeraj extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceVeeraj[] buttonI;
	private ProgressInterfaceVeeraj progress;
	private ArrayList<MoveInterfaceVeeraj> move;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	private ArrayList<Visible> temp;
	
	public SimonScreenVeeraj(int width, int height) {
		super(width, height);
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
	}

	public void nextRound() {
		acceptingInput = false;
		roundNumber++;
		move.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(move.size());
		changeText("Simon's Turn");
		playSequence();
		changeText("Your turn");
		label.setText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}
	
	public void playSequence(){
		ButtonInterfaceVeeraj b;
		b = null;
		for(int i = 0; i < move.size(); i++){
			if(b != null){
				b.dim();
			}
			b = move.get(i).getButton();
			b.highlight();
			int sleepTime = 5000/(roundNumber+1);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}
	
	private MoveInterfaceVeeraj getMove(Button b) {
		return null;
	}

	
	public void changeText(String s){
		try{
			label.setText(s);
			Thread.sleep(1000);
			label.setText("");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		move = new ArrayList<MoveInterfaceVeeraj>();
		//add 2 moves to start
		lastSelectedButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceVeeraj randomMove() {
		Button b;
		int random = (int)(Math.random()*buttonI.length);
		while(random == lastSelectedButton){
			random = (int)(Math.random()*buttonI.length);
		}
		b = (Button) buttonI[random];
		return getMove(b);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	**/
	private ProgressInterfaceVeeraj getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 6;
		Color[] colors = {Color.red, Color.green, Color.blue, Color.yellow, Color.pink, Color.orange};
		for(int i = 0; i < numberOfButtons; i++){
			final ButtonInterfaceVeeraj b = getAButton();
			b.setColor(colors[i]);
			b.setX(30*i + 30);
			b.setY(50);
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try{
									Thread.sleep(800);
								}
								catch(InterruptedException e){
									e.printStackTrace();
								}
								b.dim();
							}
						});
					blink.start();
					if(b == move.get(sequenceIndex).getButton()){
						sequenceIndex++;
					}
					else{
						progress.gameOver();
					}
					if(sequenceIndex == move.size()){
						Thread nextRound = new Thread(SimonScreenVeeraj.this);
						nextRound.start();
					}
					}
				}
			});
			viewObjects.add(b);
		}
	}
	
	private ButtonInterfaceVeeraj getAButton() {
		// TODO Auto-generated method stub
		return new Button();
	}

	@Override
	public void initObjects(ArrayList<guiPractice.component.Visible> arg0) {
		// TODO Auto-generated method stub
		
	}
}
