package jp.co.seamark.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String hoge(){
		String ret = "hoge hoge hoge";
		return ret;
	}
}
