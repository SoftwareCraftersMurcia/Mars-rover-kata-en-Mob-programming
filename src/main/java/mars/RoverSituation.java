package mars;

import mars.command.move.MovementCommand;
import mars.command.rotation.RotationCommand;
import mars.orientation.Orientation;

public class RoverSituation {
    private final Orientation orientation;

    private final Position position;

    public RoverSituation(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public RoverSituation rotate(RotationCommand rotation) {
        return new RoverSituation(position, rotation.rotate(orientation));
    }

    public RoverSituation moveForward(MovementCommand movementCommand) {
        Movement movement = movementCommand.move(orientation);
        return new RoverSituation(position.move(movement), orientation);
    }

    @Override
    public String toString() {
        return position.toString() + ":" + orientation.toString();
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}