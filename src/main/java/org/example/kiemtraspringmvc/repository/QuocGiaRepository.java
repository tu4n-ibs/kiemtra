package org.example.kiemtraspringmvc.repository;

import org.example.kiemtraspringmvc.model.QuocGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuocGiaRepository extends JpaRepository<QuocGia,Long> {
}
