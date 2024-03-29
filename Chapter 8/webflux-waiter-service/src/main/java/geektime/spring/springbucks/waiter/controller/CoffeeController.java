package geektime.spring.springbucks.waiter.controller;

import geektime.spring.springbucks.waiter.model.Coffee;
import geektime.spring.springbucks.waiter.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/coffee")
@Slf4j
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping(path = "/", params = "!name")
    @ResponseBody
    public Flux<Coffee> getAll() {
        return coffeeService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Mono<Coffee> getById(@PathVariable Long id) {
        return coffeeService.findById(id);
    }

    @GetMapping(path = "/", params = "name")
    @ResponseBody
    public Mono<Coffee> getByName(@RequestParam String name) {
        return coffeeService.findByName(name);
    }
}
