package org.olddriver.test;

import org.junit.jupiter.api.Test;
import org.olddriver.spring.aspect.UsageTracked;
import org.olddriver.spring.bean.ExampleBean;
import org.olddriver.spring.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(value= {ApplicationConfig.class})
public class WebApplicationTest {
	@Autowired
	private ExampleBean exampleBean;
	
	@Test
	public void test() {
		UsageTracked usageTracked = (UsageTracked) exampleBean;
		usageTracked.test();
		System.out.println(exampleBean.getClass().getName());
	}
}
