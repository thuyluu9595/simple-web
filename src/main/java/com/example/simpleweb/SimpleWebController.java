package com.example.simpleweb;

import org.hibernate.ObjectNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SimpleWebController {

    private UserRepository userRepository;

    public SimpleWebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> FindAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> FindUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new ObjectNotFoundException(user,"Oject not found");
        }
        return user;
    }

    @PostMapping("/users")
    public Message CreateUser(@RequestBody User user){
        userRepository.save(user);
        return new Message("User created successfully");
    }

    @DeleteMapping("/users/{id}")
    public Message DeleteUser(@PathVariable int id){
        userRepository.deleteById(id);
        return new Message("User deleted successfully");
    }


}
