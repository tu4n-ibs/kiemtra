package org.example.kiemtraspringmvc.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class thanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "ban phai nhap ten")
    private String nameCity;
    @NotBlank(message = "ban phai chon quoc gia")
    private String country;
    @Min(value = 0, message = "ban phai nhap dien tich")
    private double area;
    @NotBlank(message = "ban phai nhap dan so")
    private String population;
    @NotBlank(message = "ban phai nhap GDP")
    private String GDP;
    @NotBlank(message = "Ban phai nhap mo ta")
    private String descri;

    public thanhPho() {
    }

    public thanhPho(Long id, String nameCity, String country, double area, String population, String GDP, String describe) {
        this.id = id;
        this.nameCity = nameCity;
        this.country = country;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.descri = describe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }


    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }


    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }


    public String getDescribe() {
        return descri;
    }

    public void setDescribe(String describe) {
        this.descri = describe;
    }
}
