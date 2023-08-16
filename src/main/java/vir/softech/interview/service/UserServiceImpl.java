package vir.softech.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vir.softech.interview.entity.User;
import vir.softech.interview.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(MultipartFile file, User user) {
        try {
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setName(user.getName());
            newUser.setMail(user.getMail());
            newUser.setMobile(user.getMobile());

            // Upload and store image
            String imagePath = storeImage(file);
            newUser.setProfile(imagePath);

            userRepository.save(newUser);
            return newUser;
        } catch (IOException e) {
            // Handle exception
            throw new RuntimeException("Error creating user with image", e);
        }
    }


    private String storeImage(MultipartFile file) throws IOException {

        String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        // Generate a unique filename for the image
        String filename = System.currentTimeMillis() + fileExtension;

        //  path where the image will be stored
        String uploadDirectory = "/home/obito/Desktop/Development/java_programs/interview/src/main/resources/static/images/" + filename;

        Path targetLocation = Path.of(uploadDirectory);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }
    @Override
    public List<User> getUser() {
        List<User> allUsers=new ArrayList<>();
        allUsers = userRepository.findAll();
        return allUsers;
    }
}
