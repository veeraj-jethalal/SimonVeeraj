package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.component.Component;

public class Progress extends Component implements ProgressInterfaceVeeraj {
	
	private static int w = 170;
	private static int h = 70;
	private String round;
	private boolean over;
	private String sequence;

	public Progress() {
		super(20, 50, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		over = true;
		update();
	}

	@Override
	public void setRound(int round) {
		// TODO Auto-generated method stub
		this.round = "Round: "+round;
		update();
	}

	@Override
	public void setSequenceSize(int size) {
		// TODO Auto-generated method stub
		this.sequence = "Sequence length: "+size;
		update();
	}


	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(over){
			g.setColor(new Color(255,55,90));
			g.fillRect(0, 0, w, h);
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, (w - fm.stringWidth(go))/2, 20);
			g.drawString(sequence, (w - fm.stringWidth(sequence))/2, 40);

		}else{
			g.setColor(new Color(220,255,230));
			g.fillRect(0, 0, w, h);
			g.setColor(Color.black);
			g.drawRect(0, 0, w-1, h-1);
			if(round !=null && sequence != null){

				g.drawString(round, (w - fm.stringWidth(round))/2, 20);
				g.drawString(sequence, (w - fm.stringWidth(sequence))/2, 40);
			}
		}
	}

}
