package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import javax.validation.constraints.Max;

import org.junit.Test;

public class RuleBaseTest {
	public static class RuleClass1 {
		@Max(10)
		int intValue;

		@Max(12)
		Integer integerValue;

	}

	@Test
	public void intCalue() {
		FieldAnnotaion<Max> entry = new RuleTestBase().getFieldAnnotation(RuleClass1.class, "intValue", Max.class);
		assertEquals(10, entry.getAnnotation().value());

	}

	@Test
	public void integerCalue() {
		FieldAnnotaion<Max> entry = new RuleTestBase().getFieldAnnotation(RuleClass1.class, "integerValue", Max.class);
		assertEquals(12, entry.getAnnotation().value());
	}

}
