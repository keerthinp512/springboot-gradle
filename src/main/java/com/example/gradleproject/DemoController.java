package com.example.gradleproject;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    private final Map<String,String> personStore = new HashMap<>();

//    @GetMapping("/")
//    public String sayHello(){
//        return "Hello,Spring boot";
//    }
//    @GetMapping("/greet")
//    public String greetUser(@RequestParam String name){
//        return "Hello "+name +"!";
//    }
//    @PostMapping("/user")
//    public String createUser(@RequestBody User user){
//        return "User "+user.getName()+" is "+user.getAge()+" years old";
//    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody Person person){
        if(personStore.containsKey(person.getName())){
            return (person.getName()+" already exists");
        }
        personStore.put(person.getName(),person.getCompany());
        return "User data added";
    }

    @GetMapping("/getcompany")
    public String getUsers(@RequestParam String name){
        if(personStore.containsKey(name)){
            return(name+ " works in "+personStore.get(name));
        }
        return ("User not found");
    }

    @PutMapping("/updatecompany")
    public String updateCompany(@RequestBody Person person){
        if(!personStore.containsKey(person.getName())){
            return("User not found");
        }
        personStore.put(person.getName(),person.getCompany());
        return ("Updated "+person.getName()+" to company: "+person.getCompany());
    }
    @DeleteMapping("/removeuser")
    public String deleteUser(@RequestParam String name){
        if(!personStore.containsKey(name)){
            return("User not found");
        }
        personStore.remove(name);
        return ("Removed user: "+ name);
    }
}
