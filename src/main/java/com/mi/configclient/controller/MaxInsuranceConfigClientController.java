package com.mi.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Struct;
import java.util.List;

@RestController
@RequestMapping("/max-insurance-config-client")
@RefreshScope
public class MaxInsuranceConfigClientController {

    @Value("${insurance.provider.url}")
    private  String insuranceProviderUrl;

    @Value("${insurance.provider.getAllPlans}")
    private  String getAllPlans;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @GetMapping("/getPlans")
    public List<String> getPlans(){
        String url = insuranceProviderUrl + getAllPlans;
        List<String> plans = restTemplate.getForObject(url, List.class);
        return plans;
    }

//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

}
