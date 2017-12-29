package io.pugna.player;

public class Position {
  private Coordinate coordinate;
  private String playerName;

  public Position() {
  }

  public Position(Coordinate coordinate, String playerName) {
    this.coordinate = coordinate;
    this.playerName = playerName;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public String getPlayerName() {
    return playerName;
  }
}
