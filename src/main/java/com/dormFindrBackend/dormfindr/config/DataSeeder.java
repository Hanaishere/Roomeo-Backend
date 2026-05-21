package com.dormFindrBackend.dormfindr.config;

import com.dormFindrBackend.dormfindr.model.Dorm;
import com.dormFindrBackend.dormfindr.repository.DormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private DormRepository dormRepository;

    @Override
    public void run(String... args) throws Exception {
        if (dormRepository.count() >= 1000) {
            System.out.println("Data already seeded, skipping...");
            return;
        }

        String[] cities = {"Delhi", "Mumbai", "Bangalore", "Pune", "Hyderabad",
                "Chennai", "Kolkata", "Jaipur", "Agra", "Lucknow"};
        String[] types = {"PG", "Hostel", "Dormitory", "Shared Apartment"};
        String[] names = {"Sunshine", "Green Valley", "City View", "Royal",
                "Paradise", "Comfort", "Budget Stay", "Student Hub"};

        Random random = new Random();
        List<Dorm> dorms = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            Dorm dorm = new Dorm();
            dorm.setName(names[random.nextInt(names.length)] + " " + types[random.nextInt(types.length)] + " " + i);
            dorm.setCity(cities[random.nextInt(cities.length)]);
            dorm.setType(types[random.nextInt(types.length)]);
            dorm.setPrice(3000.0 + (random.nextInt(17000)));
            dorm.setImageUrl("https://example.com/dorm" + i + ".jpg");
            dorms.add(dorm);
        }

        dormRepository.saveAll(dorms);
        System.out.println("Seeded 1000 dorm records successfully!");
    }
}