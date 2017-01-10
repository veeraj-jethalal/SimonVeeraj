package simon;

public class Move implements MoveInterfaceVeeraj {

private ButtonInterfaceVeeraj b; 
	
	public Move(ButtonInterfaceVeeraj b) {
		this.b = b;
	}

	public ButtonInterfaceVeeraj getButton() {
		return b;
	}

}
