package vir.softech.interview.controller;

import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vir.softech.interview.entity.User;
import vir.softech.interview.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(path = "/create")
    public User createUser( @RequestParam("file")MultipartFile file,@RequestParam("user") String userJson){
        System.out.println(file.getName());
        Gson gson = new Gson();

        // converting jsonString into object
        User user = gson.fromJson(userJson, User.class);

        return userService.createUser(file,user);

    }

    @GetMapping(path = "/get-user")
    public List<User> getUsers(){
        return userService.getUser();
    }


}
