package org.acceptic.nba.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    private String fullName;
    private String phone;
    private String height;
    @ManyToOne
    private Team team;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId &&
                Objects.equals(fullName, player.fullName) &&
                Objects.equals(phone, player.phone) &&
                Objects.equals(height, player.height) &&
                Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, fullName, phone, height, team);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", height='" + height + '\'' +
                ", team=" + team +
                '}';
    }
}
