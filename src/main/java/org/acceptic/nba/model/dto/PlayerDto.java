package org.acceptic.nba.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDto {
    @JsonProperty("full_name")
    private String fullName;
    private String phone;
    private String height;
    @JsonProperty(value = "team_id", required = true)
    private String teamId;

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

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
