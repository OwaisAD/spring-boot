package com.example.demo.owais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

/*    @GetMapping("/")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse("Hello World!", List.of("Java", "TypeScript"), new Person("Elon", 24, 1_000, true));
        return response;
    }

    record Person(String name, int age, double savings, boolean isTall) {}
    record GreetResponse(String greet, List<String> favProgrammingLanguages, Person person) {}*/

}
