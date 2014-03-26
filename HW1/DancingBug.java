import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
	private int[] turns;
	private int index;
	private int steps;
	private int numTurns;
	private int sideLength;


	public DancingBug(int sideLength, int[] turns) {
		this.turns = turns;
		this.sideLength = sideLength;
		steps = 0;
		index = 0;
		numTurns = 0;
	}

	public void act() {
		if (steps < sideLength && canMove()) {
			move();
			steps++;
		} else {
			if (index >= turns.length)
				index = 0;
			if (numTurns < turns[index]) {
				turn();
				numTurns++;
			}
			else {
				numTurns = 0;
				steps = 0;
				index++;
			}
		}
	}
}
