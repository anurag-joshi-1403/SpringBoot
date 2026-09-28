package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public static class UsersController {

        @GetMapping("/users")
        public List<UserResponse> getAllUsers() {
            return Arrays.asList(
                    new UserResponse("Anurag", "anurag@example.com"),
                    new UserResponse("Anu", "anu@example.com"),
                    new UserResponse("Hariom", "Hariom@example.com"));
        }
    }

    @RestController
    public static class HelloController {

        @GetMapping("/user")
        public UserResponse hello(@RequestParam String name, @RequestParam String email) {
            return new UserResponse(name, email);

        }

        @GetMapping("/user/{name}")
        public UserResponse getUserByName(@PathVariable String name) {
            return new UserResponse(name, "email@example.com");
        }
    }
}