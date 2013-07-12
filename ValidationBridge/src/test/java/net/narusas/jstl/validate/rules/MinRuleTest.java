package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import javax.validation.constraints.Min;

import org.junit.Test;

public class MinRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@Min(10)
		int intValue;

		@Min(12)
		Integer integerValue;

		@Min(5)
		String stringValue;

		@Min(Long.MIN_VALUE)
		long longValue;
		
		
		BigInteger bigInteger;
	}

	@Test
	public void premitiveIntType() {
		FieldAnnotaion<Min> entry = getFieldAnnotation(RuleClass1.class, "intValue", Min.class);
		MinRule rule = new MinRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals(10, rule.getMinLength());
		assertEquals("min", rule.getRuleName());
		assertEquals("min: 10", rule.toRuleString());
	}

	@Test
	public void numberObjectType() {
		FieldAnnotaion<Min> entry = getFieldAnnotation(RuleClass1.class, "integerValue", Min.class);
		MinRule rule = new MinRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals(12, rule.getMinLength());
		assertEquals("min", rule.getRuleName());
	}

	@Test
	public void stringValue() {
		FieldAnnotaion<Min> entry = getFieldAnnotation(RuleClass1.class, "stringValue", Min.class);
		MinRule rule = new MinRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals(5, rule.getMinLength());
		assertEquals("minlength", rule.getRuleName());
		assertEquals("minlength: 5", rule.toRuleString());
	}

	@Test
	public void premitiveLongType() {
		FieldAnnotaion<Min> entry = getFieldAnnotation(RuleClass1.class, "longValue", Min.class);
		MinRule rule = new MinRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals(Long.MIN_VALUE, rule.getMinLength());
		assertEquals("min", rule.getRuleName());
	}

	@Test
	public void isIntegerNumber() {
		assertTrue(Number.class.isAssignableFrom(Integer.class));
	}
}
