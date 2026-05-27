package com.dormFindrBackend.dormfindr.controller;

import com.dormFindrBackend.dormfindr.model.Dorm;
import com.dormFindrBackend.dormfindr.repository.DormRepository;
import com.dormFindrBackend.dormfindr.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/dorms")

public class DormController {
    @Autowired
    private DormService service;

    @GetMapping
    public ResponseEntity<List<Dorm>> getAllProducts()
    {
        return new ResponseEntity<>(service.getAllDorm(), HttpStatus.OK);
    }
    @PostMapping
    public Dorm create(@RequestBody Dorm dorm) {
        return service.createDorm(dorm);
    }
    @PutMapping("{id}")
    public Dorm update(@PathVariable Long id,@RequestBody Dorm dorm)
    {
        return service.updateDorm(id,dorm);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
         service.deleteDorm(id);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Dorm>> searchByCity(@RequestParam String city)
    {
        return new ResponseEntity<>(service.getDormsByCity(city),HttpStatus.OK);
    }
    @GetMapping("/type")
    public ResponseEntity<List<Dorm>> searchByType(@RequestParam String type) {
        return new ResponseEntity<>(service.getDormsByType(type), HttpStatus.OK);
    }
    @GetMapping("/price")
    public ResponseEntity<List<Dorm>> searchByPrice(@RequestParam Double min,
                                                    @RequestParam Double max) {
        return new ResponseEntity<>(service.getDormsByPriceRange(min, max), HttpStatus.OK);
    }
    public ResponseEntity<List<Dorm>>searchByName(@RequestParam String name)
    {
        return new ResponseEntity<>(service.searchByName(name),HttpStatus.OK);

    }
}
