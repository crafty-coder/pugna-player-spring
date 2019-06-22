package io.pugna.player.model;

import com.google.common.base.Objects;


public class MovementRequest {

    private String gameId;
    private BoardView board;
    private Position positionToMove;


    public MovementRequest() {
    }

    public MovementRequest(String gameId, BoardView board, Position positionToMove) {
        this.gameId = gameId;
        this.board = board;
        this.positionToMove = positionToMove;
    }

    public String getGameId() {
        return gameId;
    }

    public BoardView getBoard() {
        return board;
    }

    public Position getPositionToMove() {
        return positionToMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovementRequest that = (MovementRequest) o;
        return Objects.equal(gameId, that.gameId) &&
                Objects.equal(board, that.board) &&
                Objects.equal(positionToMove, that.positionToMove);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(gameId, board, positionToMove);
    }


    @Override
    public String toString() {
        return "MovementRequest{" +
                "gameId='" + gameId + '\'' +
                ", board=" + board +
                ", positionToMove=" + positionToMove +
                '}';
    }
}
