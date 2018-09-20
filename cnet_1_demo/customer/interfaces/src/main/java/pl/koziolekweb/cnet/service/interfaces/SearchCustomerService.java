package pl.koziolekweb.cnet.service.interfaces;

import pl.koziolekweb.cnet.common.pojo.CustomerBasicView;
import pl.koziolekweb.cnet.service.pojo.Customer;

import java.util.Collection;

public interface SearchCustomerService {

	Customer byLogin(String login);

	Collection<CustomerBasicView> all();
}