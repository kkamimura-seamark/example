package jp.co.seamark.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HWController {

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "Hello World!";
		
	}
}
