package com.example.Social_Media_Platform.Respository;

import com.example.Social_Media_Platform.Models.Analytic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticRespository extends MongoRepository<Analytic ,Integer> {
}
