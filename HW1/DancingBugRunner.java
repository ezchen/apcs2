import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class DancingBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		DancingBug bug = new DancingBug(4, new int[]{1,2,3,4});
		world.add(bug);
		world.show();
	}
}
