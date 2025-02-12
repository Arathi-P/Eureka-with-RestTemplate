package com.demo.eurekaClient.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaClientController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/callServiceA")
    public String callServiceA() {

        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("serviceA", false);

        String serviceAUrl = instanceInfo.getHomePageUrl() + "/service/one";  // Update endpoint as needed

        return restTemplate.getForObject(serviceAUrl, String.class);
    }
}
