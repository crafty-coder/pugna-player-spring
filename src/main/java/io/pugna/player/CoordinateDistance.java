package io.pugna.player;

public class CoordinateDistance {
  private final Coordinate coordinate;
  private final Integer distance;

  public CoordinateDistance(Coordinate coordinate, Integer distance) {
    this.coordinate = coordinate;
    this.distance = distance;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public Integer getDistance() {
    return distance;
  }
}
