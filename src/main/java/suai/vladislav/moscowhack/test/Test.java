package suai.vladislav.moscowhack.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suai.vladislav.moscowhack.ecohack.auth.AuthenticationResponse;
import suai.vladislav.moscowhack.ecohack.auth.AuthenticationService;
import suai.vladislav.moscowhack.ecohack.config.JwtService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/api/v1/test")
@RestController
@RequiredArgsConstructor

public class Test {
    private final AuthenticationService service;
    @GetMapping
    public ResponseEntity<String> returnTest(@RequestParam String id) {
        return ResponseEntity.ok("Hello World " + id);
    }

    @PostMapping("/authenticateWithToken")
    public ResponseEntity<AuthenticationResponse> authenticateWithToken(HttpServletRequest request) {
        return ResponseEntity.ok(service.authenticateWithToken(request));
    }
}