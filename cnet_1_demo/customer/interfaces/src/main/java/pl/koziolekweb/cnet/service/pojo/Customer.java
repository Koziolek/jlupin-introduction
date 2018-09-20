package pl.koziolekweb.cnet.service.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"password", "login"})
public class Customer {

	private final String login;
	private final String password;
	private final UUID id;

	public Customer(String login, String password) {
		this.login = login;
		this.password = password;
		this.id = UUID.randomUUID();
	}
}
