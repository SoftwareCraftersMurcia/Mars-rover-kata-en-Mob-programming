import java.util.Objects;

public class MarsRover {

    private final Grid grid;

    public MarsRover(Grid grid){
        Objects.requireNonNull(grid);
        this.grid = grid;
    }

    public String execute(String commands) {
        RoverStatus status = new RoverStatus(Orientation.NORTH, 0, 0);

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                status = new RoverStatus(status.getOrientation(), grid.advanceOne(status.getPosition(), status.getOrientation()));
            }
            else if (command == 'R') {
                status = status.rotateRight();
            }
            else if (command == 'L') {
                status = status.rotateLeft();
            }
        }

        return status.toString();
    }
}
