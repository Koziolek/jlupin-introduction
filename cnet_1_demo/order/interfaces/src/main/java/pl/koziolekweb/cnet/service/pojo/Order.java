package pl.koziolekweb.cnet.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"password", "login"})
public class Order {

	private final String subject;
	private final String customer;
	private final UUID id;

	public Order(String subject, String customer) {
		this.subject = subject;
		this.customer = customer;
		this.id = UUID.randomUUID();
	}
}
