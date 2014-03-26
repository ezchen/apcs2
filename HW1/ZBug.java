import info.gridworld.actor.Bug;

public class ZBug extends Bug {
	private int size;
	private int steps;
	private int sideCount;

	public ZBug(int size) {
		this.size = size;
		sideCount = 0;
		steps = 0;
		setDirection(90);
	}

	public void act() {
		if (steps < size && sideCount < 4) {
			if (canMove()) {
				move();
				steps++;
			}
		} else {
			steps = 0;
			if (sideCount == 0) {
				sideCount = 1;
				setDirection(225);
			} else if (sideCount == 1) {
				sideCount = 2;
				setDirection(90);
			} else {
				sideCount = 4;
			}
		}
	}
}
