package org.example.kiemtraspringmvc.repository;

import org.example.kiemtraspringmvc.model.thanhPho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICityRepository extends JpaRepository<thanhPho,Long> {
    List<thanhPho> findAllByNameCityContains(String msg);
}
