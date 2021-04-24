package com.nekose.sampleproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
class SampleProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	public void test() {
		Function<String, Integer> f = s -> Integer.parseInt(s);
	}
}
