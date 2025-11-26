package com.dormFindrBackend.dormfindr.repository;

import com.dormFindrBackend.dormfindr.model.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DormRepository extends JpaRepository<Dorm,Long> {
}
