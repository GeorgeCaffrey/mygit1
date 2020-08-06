package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public ModelAndView hello() {

		return new ModelAndView("login.html");
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView login(String username,String password) {
		System.out.println(username+"  "+password);
		if(username.equals("admin")&&password.equals("admin")){
			return new ModelAndView("main.html");
		}else{
			return new ModelAndView("login.html","error","用户名或密码错误！！！");
		}

	}
}
