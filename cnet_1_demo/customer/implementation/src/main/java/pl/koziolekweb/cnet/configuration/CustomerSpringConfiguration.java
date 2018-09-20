package pl.koziolekweb.cnet.configuration;

import com.jlupin.impl.client.util.JLupinClientUtil;
import com.jlupin.interfaces.client.delegator.JLupinDelegator;
import com.jlupin.interfaces.common.enums.PortType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.koziolekweb.cnet.service.impl.CreateCustomerServiceImpl;
import pl.koziolekweb.cnet.service.interfaces.CreateCustomerService;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("pl.koziolekweb.cnet")
public class CustomerSpringConfiguration {
	@Bean
	public JLupinDelegator getJLupinDelegator() {
		return JLupinClientUtil.generateInnerMicroserviceLoadBalancerDelegator(PortType.JLRMC);
	}

	// @Bean(name = "exampleService")
	// public ExampleService getExampleService() {
	//     return JLupinClientUtil.generateRemote(getJLupinDelegator(), "example-microservice", ExampleService.class);
	// }

	@Bean(name = "jLupinRegularExpressionToRemotelyEnabled")
	public List getRemotelyBeanList() {
		List<String> list = new ArrayList<>();
		list.add("createCustomerService");
		list.add("searchCustomerService");
		// list.add("<REMOTE_SERVICE_NAME>");
		return list;
	}
}

