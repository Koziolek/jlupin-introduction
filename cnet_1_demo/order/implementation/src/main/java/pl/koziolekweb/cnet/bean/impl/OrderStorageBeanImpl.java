package pl.koziolekweb.cnet.bean.impl;

import org.springframework.stereotype.Service;
import pl.koziolekweb.cnet.bean.interfaces.OrderStorageBean;
import pl.koziolekweb.cnet.service.pojo.Order;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service(value = "orderStorageBean")
public class OrderStorageBeanImpl implements OrderStorageBean {

	private final Set<Order> orders = new HashSet<>();

	@Override
	public boolean save(Order order) {
		return this.orders.add(order);
	}

	@Override
	public Optional<Order> bySubject(String subject) {
		return orders.stream()
				.filter(c -> subject.equals(c.getSubject()))
				.findFirst();
	}

	@Override
	public Collection<Order> all() {
		return new HashSet<>(orders);
	}
}