package pl.koziolekweb.cnet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.koziolekweb.cnet.bean.interfaces.OrderStorageBean;
import pl.koziolekweb.cnet.service.interfaces.CreateOrderService;
import org.springframework.stereotype.Service;
import pl.koziolekweb.cnet.service.pojo.Order;

@Service(value = "createOrderService")
public class CreateOrderServiceImpl implements CreateOrderService {

	private final OrderStorageBean storage;

	@Autowired
	public CreateOrderServiceImpl(OrderStorageBean storage) {
		this.storage = storage;
	}

	@Override
	public boolean createOrder(String subject, String customer) {
		Order o = new Order(subject, customer);
		return storage.save(o);
	}
}