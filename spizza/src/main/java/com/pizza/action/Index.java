package com.pizza.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class Index {
	
	@RequestMapping("/mvc/index")
	public void test(){
	    var list=new ArrayList<String>();
		System.out.println("MVC测试成功2");
	}
}
