package com.akos.vamos.MyApplication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class RestApi {
    @GetMapping("/{id}")
    public Car getDataById(@PathVariable int id) {
        return new Car(id, "ABC123", "Sedan");
    }

    @PostMapping
    public void postData(@RequestBody Car car) {
        System.out.println("Received data: " + car);
    }
}
