package com.kakaopay.feel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kakaopay.feel.util.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeelApplicationTests {
	
	private Utils aUtils;
	
	@Before
	public void setup() {
		aUtils = new Utils();
	}

	@Test
	public void validateEmail() {
		String email = "abc@abc.com";
		assertEquals(true, aUtils.validateEmail(email));
	}
	
	@Test
	public void GeneratorCouponNo() throws Exception {
		String email = "test@test.com";
		assertEquals("ip3DBKlZFqlEYqIC", aUtils.GeneratorCouponNo(email));
	}

}
