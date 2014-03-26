import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class SpiralBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		SpiralBug bug = new SpiralBug(3);
		world.add(new Location(5,5), bug);
		world.show();
	}
}

