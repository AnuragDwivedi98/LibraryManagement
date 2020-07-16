package com.example.libraryManagementProject.Controller;

import com.example.libraryManagementProject.DataAccessLayer.User;
import com.example.libraryManagementProject.DataAccessLayer.UserRepository;
import com.example.libraryManagementProject.Util.UserValidator;
import com.example.libraryManagementProject.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserResource {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepository repository;

    //find
    @GetMapping("/users")
    List<User> findAll(){
        return repository.findAll();
    }

    @PostMapping("/users")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) throws Exception{
        if(UserValidator.isValidUser(newUser))
            return repository.save(newUser);
        else
            throw new Exception();
    }

    //find a given user
    @GetMapping("/users/{id}")
    User findOne(@PathVariable int id) {
        LOGGER.info("/users/{id} called withy id" + id);
        //Optional<User> user = repository.findById(id);
        //return user.get();
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
