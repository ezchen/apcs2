//Eric Chen
//pd 6
//HW1
//2014-02-12

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class CircleBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		CircleBug bug = new CircleBug(3);
		world.add(new Location(5,5), bug);
		world.show();
	}
}

