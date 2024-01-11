package org.example.kiemtraspringmvc.model;

import javax.persistence.*;

@Entity
public class thanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCity;
    private String country;
    private double area;
    private String population;
    private String GDP;

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

    @Column(length = 100, nullable = false)
    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Column(length = 100, nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(nullable = false)
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Column(length = 50, nullable = false)
    public String getPopulation() {
        return population;
    }
    public void setPopulation(String population) {
        this.population = population;
    }

    @Column(length = 10, nullable = false)
    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    @Column(length = 255, nullable = false)
    public String getDescribe() {
        return descri;
    }

    public void setDescribe(String describe) {
        this.descri = describe;
    }
}
