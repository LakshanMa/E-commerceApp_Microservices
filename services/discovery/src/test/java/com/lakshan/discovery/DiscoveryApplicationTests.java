package com.lakshan.discovery;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;

@SpringBootTest
class DiscoveryApplicationTests {

	@Autowired
	private EurekaClientConfigBean eurekaClientConfigBean;

	@Test
	void eurekaServerMustNotRegisterItselfAsClient() {
		assertThat(eurekaClientConfigBean.shouldRegisterWithEureka()).isFalse();
		assertThat(eurekaClientConfigBean.shouldFetchRegistry()).isFalse();
	}

}
