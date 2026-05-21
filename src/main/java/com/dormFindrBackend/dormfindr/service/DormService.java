package com.dormFindrBackend.dormfindr.service;

import com.dormFindrBackend.dormfindr.model.Dorm;
import com.dormFindrBackend.dormfindr.repository.DormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DormService {
    @Autowired
    private DormRepository repo;

    public List<Dorm> getAllDorm() {
        return repo.findAll();
    }

    public Dorm createDorm(Dorm dorm) {
        return repo.save(dorm);
    }

    public Dorm updateDorm(Long id, Dorm dorm) {
        dorm.setId(id);
        return repo.save(dorm);
    }

    public void deleteDorm(Long id) {
        repo.deleteById(id);
    }
    public List<Dorm> getDormsByCity(String city) {
        return repo.findByCity(city);
    }

    public List<Dorm> getDormsByType(String type) {
        return repo.findByType(type);
    }

    public List<Dorm> getDormsByPriceRange(Double min, Double max) {
        return repo.findByPriceBetween(min, max);
    }
}
