package io.pugna.player;

public class MoveRequest {
  private BoardState boardState;
  private Position positionToMove;

  public MoveRequest() {
  }

  public MoveRequest(BoardState boardState, Position positionToMove) {
    this.boardState = boardState;
    this.positionToMove = positionToMove;
  }

  public BoardState getBoardState() {
    return boardState;
  }

  public Position getPositionToMove() {
    return positionToMove;
  }
}
