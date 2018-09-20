package pl.koziolekweb.cnet.service.interfaces;

import pl.koziolekweb.cnet.common.pojo.OrderBasicView;
import pl.koziolekweb.cnet.service.pojo.Order;

import java.util.List;
import java.util.Optional;

public interface SearchOrderService {

	Optional<Order> bySubject(String subject);

	List<OrderBasicView> all();

	List<OrderBasicView> allByLogins(List<String> customerLogins);

	List<OrderBasicView> allForCustomer(String customerLogin);
}