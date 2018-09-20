package pl.koziolekweb.cnet.configuration;

import com.jlupin.impl.client.util.JLupinClientUtil;
import com.jlupin.interfaces.client.delegator.JLupinDelegator;
import com.jlupin.interfaces.common.enums.PortType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.koziolekweb.cnet.service.interfaces.SearchCustomerService;
import pl.koziolekweb.cnet.service.interfaces.SearchOrderService;

@Configuration
@ComponentScan({
		"pl.koziolekweb.cnet",
		"com.jlupin.servlet.monitor.configuration"
})
public class GatewaySpringConfiguration {
	@Bean
	public JLupinDelegator getJLupinDelegator() {
		return JLupinClientUtil.generateInnerMicroserviceLoadBalancerDelegator(PortType.JLRMC);
	}

	// @Bean(name = "exampleService")
	// public ExampleService getExampleService() {
	//     return JLupinClientUtil.generateRemote(getJLupinDelegator(), "example-microservice", ExampleService.class);
	// }

	@Bean(name ="SearchCustomerService")
	public SearchCustomerService searchCustomerService(){
		return JLupinClientUtil.generateRemote(getJLupinDelegator(), "customer", SearchCustomerService.class);
	}

	@Bean(name ="SearchOrderService")
	public SearchOrderService searchOrderService(){
		return JLupinClientUtil.generateRemote(getJLupinDelegator(), "order", SearchOrderService.class);
	}
}

