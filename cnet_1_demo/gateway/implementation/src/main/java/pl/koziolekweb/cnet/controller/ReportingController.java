package pl.koziolekweb.cnet.controller;

import io.github.pellse.assembler.AssemblerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.koziolekweb.cnet.common.pojo.CustomerBasicView;
import pl.koziolekweb.cnet.common.pojo.CustomerFullView;
import pl.koziolekweb.cnet.common.pojo.OrderBasicView;
import pl.koziolekweb.cnet.service.interfaces.SearchCustomerService;
import pl.koziolekweb.cnet.service.interfaces.SearchOrderService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.pellse.assembler.stream.StreamAdapter.streamAdapter;
import static io.github.pellse.util.query.MapperUtils.oneToManyAsList;

@RestController
public class ReportingController {
	private final SearchCustomerService customerService;
	private final SearchOrderService orderService;

	@Autowired
	public ReportingController(SearchCustomerService customerService, SearchOrderService orderService) {
		this.customerService = customerService;
		this.orderService = orderService;
	}

	@RequestMapping(path = "all/", method = RequestMethod.GET)
	@ResponseBody
	public Collection<CustomerFullView> all() {
		List<CustomerFullView> collect = AssemblerBuilder.assemblerOf(CustomerFullView.class)
				.withIdExtractor(CustomerBasicView::getLogin)
				.withAssemblerRules(
						oneToManyAsList(orderService::allByLogins, OrderBasicView::getCustomer, ArrayList::new),
						CustomerFullView::new)
				.using(streamAdapter(false))
				.assembleFromSupplier(customerService::all)
				.collect(Collectors.toList());
		return collect;
	}
}
