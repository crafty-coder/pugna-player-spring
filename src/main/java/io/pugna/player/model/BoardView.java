package io.pugna.player.model;

import java.util.List;

//Its the state send to players
public class BoardView {

    private List<Position> knights;
    private List<CityView> cities;
    private List<Coordinate> rivers;
    private Integer boardSize;
    private Integer round;
    private List<PlayerView> players;

    public BoardView() {
    }

    public BoardView(List<Position> knights, List<CityView> cities, List<Coordinate> rivers, Integer boardSize, Integer round, List<PlayerView> players) {
        this.knights = knights;
        this.cities = cities;
        this.rivers = rivers;
        this.boardSize = boardSize;
        this.round = round;
        this.players = players;
    }

    public List<Position> getKnights() {
        return knights;
    }

    public void setKnights(List<Position> knights) {
        this.knights = knights;
    }

    public List<CityView> getCities() {
        return cities;
    }

    public void setCities(List<CityView> cities) {
        this.cities = cities;
    }

    public List<Coordinate> getRivers() {
        return rivers;
    }

    public void setRivers(List<Coordinate> rivers) {
        this.rivers = rivers;
    }

    public Integer getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public List<PlayerView> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerView> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "GameStateView{" +
                "knights=" + knights +
                ", cities=" + cities +
                ", rivers=" + rivers +
                ", boardSize=" + boardSize +
                ", round=" + round +
                ", players=" + players +
                '}';
    }
}
