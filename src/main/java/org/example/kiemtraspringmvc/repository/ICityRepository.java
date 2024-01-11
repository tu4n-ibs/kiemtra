package org.example.kiemtraspringmvc.repository;

import org.example.kiemtraspringmvc.model.thanhPho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<thanhPho,Long> {
}
