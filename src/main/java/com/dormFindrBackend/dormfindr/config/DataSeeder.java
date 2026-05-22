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
        String[] imageUrls = {
                "https://images.unsplash.com/photo-1555854877-bab0e564b8d5?w=400",
                "https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=400",
                "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=400",
                "https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?w=400",
                "https://images.unsplash.com/photo-1493809842364-78817add7ffb?w=400",
                "https://images.unsplash.com/photo-1484154218962-a197022b5858?w=400",
                "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=400",
                "https://images.unsplash.com/photo-1536376072261-38c75010e6c9?w=400"
        };

        Random random = new Random();
        List<Dorm> dorms = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            Dorm dorm = new Dorm();
            dorm.setName(names[random.nextInt(names.length)] + " " + types[random.nextInt(types.length)] + " " + i);
            dorm.setCity(cities[random.nextInt(cities.length)]);
            dorm.setType(types[random.nextInt(types.length)]);
            dorm.setPrice(3000.0 + (random.nextInt(17000)));
            dorm.setImageUrl(imageUrls[random.nextInt(imageUrls.length)]);
            dorms.add(dorm);
        }

        dormRepository.saveAll(dorms);
        System.out.println("Seeded 1000 dorm records successfully!");
    }
}