package com.base.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiClientExample", url = "https://ca8e50c6847f49a7a7ac909a037af2b1.api.mockbin.io/")
public interface ApiClientExample {

    @GetMapping("")
    ResponseEntity<String> apiExample();
}
