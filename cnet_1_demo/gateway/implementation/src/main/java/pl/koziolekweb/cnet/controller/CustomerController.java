package pl.koziolekweb.cnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.koziolekweb.cnet.common.pojo.CustomerBasicView;
import pl.koziolekweb.cnet.service.interfaces.SearchCustomerService;

import java.util.Collection;

@RestController()
public class CustomerController {

	private final SearchCustomerService searchCustomerService;

	@Autowired
	public CustomerController(SearchCustomerService searchCustomerService) {
		this.searchCustomerService = searchCustomerService;
	}

	@RequestMapping(path = "customer/", method = RequestMethod.GET)
	@ResponseBody
	public Collection<CustomerBasicView> all(){
		return searchCustomerService.all();
	}
}
