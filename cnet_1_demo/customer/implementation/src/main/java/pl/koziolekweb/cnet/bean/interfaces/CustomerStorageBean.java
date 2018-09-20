package pl.koziolekweb.cnet.bean.interfaces;

import pl.koziolekweb.cnet.service.pojo.Customer;

import java.util.Collection;
import java.util.Optional;

public interface CustomerStorageBean {

	boolean save(Customer customer);

	Optional<Customer> getByLogin(String login);

	Collection<Customer> all();
}