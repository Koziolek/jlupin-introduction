package pl.koziolekweb.cnet.bean.impl;

import org.springframework.stereotype.Service;
import pl.koziolekweb.cnet.bean.interfaces.CustomerStorageBean;
import pl.koziolekweb.cnet.service.pojo.Customer;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service(value = "customerStorageBean")
public class CustomerStorageBeanImpl implements CustomerStorageBean, Serializable {

	private final Set<Customer> customers = new HashSet<>();

	@Override
	public boolean save(Customer customer) {
		return customers.add(customer);
	}

	@Override
	public Optional<Customer> getByLogin(String login) {
		return customers.stream()
				.filter(c -> login.equals(c.getLogin()))
				.findFirst();
	}

	@Override
	public Collection<Customer> all() {
		return new HashSet<>(customers);
	}
}