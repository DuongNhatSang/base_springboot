package com.base.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiClientExample", url = "https://34d9cd11f42f49c8870015ac188ae8ef.api.mockbin.io/")
public interface ApiClientExample {

    @GetMapping("")
    ResponseEntity<String> apiExample();
}
