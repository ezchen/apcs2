import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class ZBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		ZBug bug = new ZBug(6);
		world.add(new Location(5,5), bug);
		world.show();
	}
}
