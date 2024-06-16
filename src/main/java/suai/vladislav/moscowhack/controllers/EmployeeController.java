package suai.vladislav.moscowhack.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.user.User;
import suai.vladislav.moscowhack.services.EmployeeService;

import java.util.ArrayList;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public ArrayList<User> getEmployee() {
        return employeeService.getEmployee();
    }
}
