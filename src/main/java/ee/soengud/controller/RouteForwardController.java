package ee.soengud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteForwardController {
    @GetMapping("/**/{path:[^\\.]*}")
    public String redirect(@PathVariable String path) {
        return "forward:/";
    }

    @GetMapping("/")
    public String rootRedirect() {
        return "forward:/";
    }
}
