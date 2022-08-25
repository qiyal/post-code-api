package kz.dar.postcoreapi.controller;

import kz.dar.postcoreapi.model.Content;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";

    @GetMapping
    public Content greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Content(String.format(template, name));
    }
}
