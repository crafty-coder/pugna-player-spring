package io.pugna.player;

import java.util.List;

public class BoardState {
  private List<Position> positions;
  private Integer boardSize;
  private Integer turn;

  public List<Position> getPositions() {
    return positions;
  }

  public Integer getBoardSize() {
    return boardSize;
  }

  public Integer getTurn() {
    return turn;
  }
}
