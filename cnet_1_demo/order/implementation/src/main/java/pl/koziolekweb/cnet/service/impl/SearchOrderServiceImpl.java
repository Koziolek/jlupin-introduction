package pl.koziolekweb.cnet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.koziolekweb.cnet.bean.interfaces.OrderStorageBean;
import pl.koziolekweb.cnet.common.pojo.OrderBasicView;
import pl.koziolekweb.cnet.service.interfaces.SearchOrderService;
import org.springframework.stereotype.Service;
import pl.koziolekweb.cnet.service.pojo.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "searchOrderService")
public class SearchOrderServiceImpl implements SearchOrderService {

	private final OrderStorageBean storage;

	@Autowired
	public SearchOrderServiceImpl(OrderStorageBean storage) {
		this.storage = storage;
	}

	@Override
	public Optional<Order> bySubject(String subject) {
		return storage.bySubject(subject);
	}

	@Override
	public List<OrderBasicView> all() {
		return storage.all().stream()
				.map(o-> new OrderBasicView(o.getSubject(), o.getCustomer()))
				.collect(Collectors.toList());
	}

	@Override
	public List<OrderBasicView> allByLogins(List<String> customerLogins) {
		return storage.all().stream()
				.filter(o-> customerLogins.contains(o.getCustomer()))
				.map(o-> new OrderBasicView(o.getSubject(), o.getCustomer()))
				.collect(Collectors.toList());
	}

	@Override
	public List<OrderBasicView> allForCustomer(String customerLogin) {
		return storage.all().stream()
				.filter(o-> o.getCustomer().equals(customerLogin))
				.map(o-> new OrderBasicView(o.getSubject(), o.getCustomer()))
				.collect(Collectors.toList());
	}
}