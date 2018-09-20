package pl.koziolekweb.cnet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.koziolekweb.cnet.bean.interfaces.CustomerStorageBean;
import pl.koziolekweb.cnet.common.pojo.CustomerBasicView;
import pl.koziolekweb.cnet.service.interfaces.SearchCustomerService;
import org.springframework.stereotype.Service;
import pl.koziolekweb.cnet.service.pojo.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service(value = "searchCustomerService")
public class SearchCustomerServiceImpl implements SearchCustomerService {

	private final CustomerStorageBean storage;

	@Autowired
	public SearchCustomerServiceImpl(CustomerStorageBean storage) {
		this.storage = storage;
	}


	@Override
	public Customer byLogin(String login) {
		return storage.getByLogin(login).orElse(new Customer("NULL", "NULL"));
	}

	@Override
	public Collection<CustomerBasicView> all() {
		return storage.all().stream()
				.map(c-> new CustomerBasicView(c.getLogin()))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}