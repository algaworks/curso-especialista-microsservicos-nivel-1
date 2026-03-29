package com.algaworks.algasensors.temperature.processing;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class TemperatureProcessingApplicationTests {

	@MockitoBean
	RabbitAdmin rabbitAdmin;

	@Test
	void contextLoads() {
	}

}
