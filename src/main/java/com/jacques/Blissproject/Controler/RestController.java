package com.jacques.Blissproject.Controler;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.helpers.Loader;
import org.slf4j.impl.Log4jLoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jacques.Blissproject.Modele.TableMachine;

//@Controller
//@RequestMapping("/test")
public class RestController {
	
	public RestController(){
	      System.out.println("init RestController");
	  }
	/*
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody TableMachine get(HttpServletResponse res) {
		 
	      TableMachine machine = new TableMachine();
	      machine.setMachine("test");
	      
	      
	  }

*/

}
