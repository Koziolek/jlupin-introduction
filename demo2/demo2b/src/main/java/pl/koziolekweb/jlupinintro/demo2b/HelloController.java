package pl.koziolekweb.jlupinintro.demo2b;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class HelloController {
	@RequestMapping("/")
	public String index() {
		System.out.println("+");

		RestTemplate rt = new RestTemplate();
		rt.getForEntity("http://localhost:8080/", String.class);
		return "Greetings from Spring Boot!";
	}
}
