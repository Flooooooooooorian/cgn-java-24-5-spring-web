package de.neuefische.java.cgnjava245springweb;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public Product hello() {
        System.out.println("Hello World");
        return new Product("1", "Apfel", 1.5);
    }

    @PostMapping
    public Product post(@RequestBody Product body) {
        System.out.println(body.name());
        System.out.println(body.id());
        return body.withPrice(2.5);
    }

    @GetMapping("/{name}")
    public String sayName(@PathVariable String name, @RequestParam String search) {
        System.out.println(name);
        System.out.println(search);
        return "Hallo: " + name + " search: " + search;
    }
}
