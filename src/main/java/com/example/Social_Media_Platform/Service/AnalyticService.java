package com.example.Social_Media_Platform.Service;


import com.example.Social_Media_Platform.Respository.AnalyticRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticService {

    @Autowired
    private AnalyticRespository analyticRespository;
}
