package com.dormFindrBackend.dormfindr.repository;

import com.dormFindrBackend.dormfindr.model.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DormRepository extends JpaRepository<Dorm,Long> {
    List<Dorm> findByCity(String city);
    List<Dorm> findByType(String type);
    List<Dorm> findByPriceBetween(Double min,Double max);

}
