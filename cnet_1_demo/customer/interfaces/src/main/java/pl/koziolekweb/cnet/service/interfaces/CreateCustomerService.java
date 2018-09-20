package pl.koziolekweb.cnet.service.interfaces;

import pl.koziolekweb.cnet.service.pojo.Customer;

public interface CreateCustomerService {

	Customer createCustomer(String login, String password);
}