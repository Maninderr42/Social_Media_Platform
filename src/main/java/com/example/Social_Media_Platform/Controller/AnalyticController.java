package com.example.Social_Media_Platform.Controller;


import com.example.Social_Media_Platform.Service.AnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analytic")
public class AnalyticController {

    @Autowired
    private AnalyticService analyticService;



}
