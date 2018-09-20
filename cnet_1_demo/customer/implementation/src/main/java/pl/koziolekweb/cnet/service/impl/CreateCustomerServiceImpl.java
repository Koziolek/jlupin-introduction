package pl.koziolekweb.cnet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.koziolekweb.cnet.bean.interfaces.CustomerStorageBean;
import pl.koziolekweb.cnet.service.interfaces.CreateCustomerService;
import org.springframework.stereotype.Service;
import pl.koziolekweb.cnet.service.pojo.Customer;

@Service(value = "createCustomerService")
public class CreateCustomerServiceImpl implements CreateCustomerService {

	private final CustomerStorageBean storage;

	@Autowired
	public CreateCustomerServiceImpl(CustomerStorageBean storage) {
		this.storage = storage;
	}

	@Override
	public Customer createCustomer(String login, String password) {
		Customer customer = new Customer(login, password);
		storage.save(customer);
		return customer;
	}
}