package com.bootDevtools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/display/{name}")
	@ResponseBody
	public String test(@PathVariable(value="name") String name) {
		return name;
	}
	
}
