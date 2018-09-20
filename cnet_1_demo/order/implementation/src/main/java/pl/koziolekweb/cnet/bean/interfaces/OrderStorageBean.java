package pl.koziolekweb.cnet.bean.interfaces;

import pl.koziolekweb.cnet.service.pojo.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderStorageBean {

	boolean save(Order customer);

	Optional<Order> bySubject(String subject);

	Collection<Order> all();
}