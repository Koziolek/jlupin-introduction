package pl.koziolekweb.cnet.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class CustomerFullView {

	private final CustomerBasicView customer;
	private final Collection<OrderBasicView> order;

}
