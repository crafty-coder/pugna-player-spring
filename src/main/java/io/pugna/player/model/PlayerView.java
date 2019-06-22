package io.pugna.player.model;


import java.util.Objects;

public class PlayerView {

    private String name;
    private String color;

    public PlayerView() {
    }

    public PlayerView(String name, String color) {
        this.name = name;
        this.color = color;
    }
    

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
    

    @Override
    public String toString() {
        return "PlayerView{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
