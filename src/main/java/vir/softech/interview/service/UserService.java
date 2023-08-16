package vir.softech.interview.service;

import org.springframework.web.multipart.MultipartFile;
import vir.softech.interview.entity.User;

import java.util.List;

public interface UserService {

    User createUser(MultipartFile file, User user);

    List<User> getUser();
}
