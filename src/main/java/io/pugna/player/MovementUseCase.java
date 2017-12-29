package io.pugna.player;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovementUseCase {

  public enum MOVEMENT {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    UP_LEFT,
    UP_RIGHT,
    DOWN_LEFT,
    DOWN_RIGHT,
    STAY
  }

  public String execute(MoveRequest moveRequest) {
    Coordinate coordinateToMove = moveRequest.getPositionToMove().getCoordinate();
    String player = moveRequest.getPositionToMove().getPlayerName();

    Optional<Coordinate> nearestEnemy = getNearestEnemy(player, coordinateToMove, moveRequest.getBoardState()
            .getPositions());

    return nearestEnemy
            .map(e -> calculateMovement(coordinateToMove, e))
            .orElse(MOVEMENT.STAY).name();

  }

  private MOVEMENT calculateMovement(Coordinate from, Coordinate to) {
    if(from.getX() < to.getX()) {
      return MOVEMENT.RIGHT;
    } else if(from.getX() > to.getX()) {
      return MOVEMENT.LEFT;
    } else if(from.getY() < to.getY()) {
      return MOVEMENT.UP;
    } else if(from.getY() > to.getY()) {
      return MOVEMENT.DOWN;
    }
    return MOVEMENT.STAY;
  }

  private Optional<Coordinate> getNearestEnemy(String player, Coordinate coordinate, List<Position> positions) {
    return positions.stream()
            .filter(position -> !position.getPlayerName().equals(player))
            .map(position -> new CoordinateDistance(position.getCoordinate(), distance(position.getCoordinate(), coordinate)))
            .filter(coordinateDistance -> coordinateDistance.getDistance() > 0)
            .min(Comparator.comparingInt(CoordinateDistance::getDistance))
            .map(CoordinateDistance::getCoordinate);
  }

  private Integer distance(Coordinate a, Coordinate b) {
    return (int) Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
  }

  private List<Coordinate> giveSurroundingCoordinate(Coordinate coordinateToMove) {
    return Stream.of(MOVEMENT.values()).map(direction -> move(coordinateToMove, direction)).collect(Collectors.toList());
  }

  public static Coordinate move(Coordinate coordinate, MOVEMENT movement) {
    switch (movement) {
      case UP:
        return new Coordinate(coordinate.getX(), coordinate.getY() + 1);
      case DOWN:
        return new Coordinate(coordinate.getX(), coordinate.getY() - 1);
      case LEFT:
        return new Coordinate(coordinate.getX() - 1, coordinate.getY());
      case RIGHT:
        return new Coordinate(coordinate.getX() + 1, coordinate.getY());
      case UP_LEFT:
        return new Coordinate(coordinate.getX() + 1, coordinate.getY() - 1);
      case UP_RIGHT:
        return new Coordinate(coordinate.getX() + 1, coordinate.getY() + 1);
      case DOWN_LEFT:
        return new Coordinate(coordinate.getX() - 1, coordinate.getY() - 1);
      case DOWN_RIGHT:
        return new Coordinate(coordinate.getX() - 1, coordinate.getY() + 1);
      case STAY:
      default:
        return coordinate;
    }

  }

}
