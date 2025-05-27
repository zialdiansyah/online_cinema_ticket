package com.zialdiansyah.online_cinema_ticket.dto;

import jakarta.validation.constraints.NotBlank;

public class CityDTO {
    private int cityId;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    public int getCityId() { return cityId; }
    public void setCityId(int cityId) { this.cityId = cityId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}