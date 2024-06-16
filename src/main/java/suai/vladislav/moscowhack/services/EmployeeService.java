package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.user.User;
import suai.vladislav.moscowhack.ecohack.user.UserRepository;

import java.util.ArrayList;

import static suai.vladislav.moscowhack.ecohack.user.Role.MODERATOR;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    private final UserRepository userRepository;

    public ArrayList<User> getEmployee() {
        return (ArrayList<User>) userRepository.findAllByRoleEquals(MODERATOR);
    }
}
