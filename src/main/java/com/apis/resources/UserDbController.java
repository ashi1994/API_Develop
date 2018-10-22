package com.apis.resources;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apis.model.UserDBMapping;
import com.apis.rabbitmqsender.RabbitMQSender;
import com.apis.repository.UserRepositry;

@RestController
public class UserDbController {

    @Autowired
    UserRepositry userRespository;
    

    @GetMapping("/user")
    public List<UserDBMapping> index(){
        return userRespository.findAll();
    }
    
    @PostMapping(value = "/createandviewwholelist")
    public List<UserDBMapping> persist(@RequestBody final UserDBMapping users) {
    	userRespository.save(users);
    	List<UserDBMapping> li=userRespository.findAll();
        return li;
    }
    
    @PostMapping(value = "/createuser")
    public String persistuser(@RequestBody final UserDBMapping users) {
    	userRespository.save(users);
    	int id=users.getId();
    	return "Id " +id+" Created for user";
    }
    @GetMapping("/user/{id}")
    public Optional<UserDBMapping> show(@PathVariable Integer id){
        //int userId = Integer.parseInt(id);
        return userRespository.findById(id);
    }
    /**
     * Upadate existing User
     * @param id
     * @param users
     * @return
     */

    @PutMapping("/user/{id}")
    public UserDBMapping update(@PathVariable Integer id, @RequestBody UserDBMapping users){
        UserDBMapping blog = userRespository.getOne(id);
        blog.setName(users.getName());
        blog.setAge(users.getAge());
        return userRespository.save(blog);
    }

    @DeleteMapping("user/{id}")
    public String delete(@PathVariable Integer id){
        //int userId = Integer.parseInt(id);
        if(userRespository.existsById(id)) {
        userRespository.deleteById(id);
        return "User deleted successfully";}
        else {
        	return "User Not Present";
        }
    }


}



