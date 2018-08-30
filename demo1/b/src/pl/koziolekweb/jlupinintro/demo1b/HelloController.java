package pl.koziolekweb.jlupinintro.demo1b;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		System.out.println("+");

		RestTemplate rt = new RestTemplate();
		rt.getForEntity("http://localhost:8080/b/hello", String.class);

		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}
}