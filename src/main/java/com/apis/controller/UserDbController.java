package com.apis.controller;

import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apis.kafka.KafkaSender;
import com.apis.model.UserDBMapping;
import com.apis.rabbitmqsender.RabbitMQReceiver;
import com.apis.rabbitmqsender.RabbitMQSender;
import com.apis.repository.UserRepositry;

@RestController
public class UserDbController {
	Integer io;
	UserDBMapping blog;

	@Autowired
	UserRepositry userRespository;
	@Autowired
	RabbitMQSender rabbitMQSender;
	@Autowired
	RabbitMQReceiver rec;
	@Autowired
	KafkaSender kafkaSender;

	@GetMapping("/user")
	public List<UserDBMapping> index() {
		return userRespository.findAll();
	}

	@PostMapping(value = "/createandviewwholelist")
	public List<UserDBMapping> persist(@RequestBody final UserDBMapping users) {
		userRespository.save(users);
		List<UserDBMapping> li = userRespository.findAll();
		return li;
	}

	@PostMapping(value = "/user")
	public String persistuser(@RequestBody final UserDBMapping users) {
		userRespository.save(users);
		rabbitMQSender.send(users);
		int id = users.getId();
		return "Id " + id + " Created for user";

	}

	@GetMapping("/user/{id}")
	public Optional<UserDBMapping> show(@PathVariable Integer id) {
		// int userId = Integer.parseInt(id);
		return userRespository.findById(id);
	}

	/**
	 * Upadate existing User
	 * 
	 * @param id
	 * @param users
	 * @return
	 */

	@PutMapping("/user/{id}")
	public UserDBMapping update(@PathVariable Integer id, @RequestBody UserDBMapping users) {
		if (userRespository.existsById(id)) {
			blog = userRespository.getOne(id);
			blog.setName(users.getName());
			blog.setAge(users.getAge());
		} else {
		}

		return userRespository.save(blog);
	}

	@DeleteMapping("user/{id}")
	public String delete(@PathVariable Integer id) {
		// int userId = Integer.parseInt(id);
		if (userRespository.existsById(id)) {
			userRespository.deleteById(id);
			return "User deleted successfully";
		} else {
			return "User Not Present";
		}
	}

	/***
	 * /RestAPI/user/?ids=80,81,82
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("user/")
	public String delete(@RequestParam("ids") List<Integer> id) {
		for (Integer it : id) {
			if (userRespository.existsById(it)) {
				userRespository.deleteById(it);
			} else
				return "User Not Present";
		}

		return "User deleted";
	}

	@GetMapping("kafka/{msg}")
	public String get(@PathVariable String msg) {
		kafkaSender.send("test", msg);
		return "msg send successfully";

	}

}
