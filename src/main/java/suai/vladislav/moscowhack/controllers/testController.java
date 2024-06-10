package suai.vladislav.moscowhack.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class testController {
    @GetMapping("/")
    public String test() {
        return "test page";
    }
}
