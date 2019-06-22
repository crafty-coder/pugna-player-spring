package io.pugna.player.model;

import com.google.common.base.Objects;

import java.util.Set;

public class CityView {

    private Coordinate cityCenter;
    private Set<Coordinate> coordinates;
    private String owner;


    public CityView() {
    }

    public CityView(Coordinate cityCenter, Set<Coordinate> coordinates, String owner) {
        this.cityCenter = cityCenter;
        this.coordinates = coordinates;
        this.owner = owner;
    }

    public Coordinate getCityCenter() {
        return cityCenter;
    }

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityView cityView = (CityView) o;
        return Objects.equal(cityCenter, cityView.cityCenter) &&
                Objects.equal(coordinates, cityView.coordinates) &&
                Objects.equal(owner, cityView.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cityCenter, coordinates, owner);
    }
}
