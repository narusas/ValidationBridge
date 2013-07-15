package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import javax.validation.constraints.Max;

import org.junit.Test;

public class MaxRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@Max(10)
		int intValue;

		@Max(12)
		Integer integerValue;

		@Max(5)
		String stringValue;

		@Max(Long.MAX_VALUE)
		long longValue;
		
		
		BigInteger bigInteger;
	}

	@Test
	public void premitiveIntType() {
		FieldAnnotaion<Max> entry = getFieldAnnotation(RuleClass1.class, "intValue", Max.class);
		MaxRule rule = new MaxRule(entry.getAnnotation(), entry.getField());
		assertEquals(10, rule.getMaxLength());
		assertEquals("max", rule.getRuleName());
		assertEquals("max: 10", rule.toRuleString());
	}

	@Test
	public void numberObjectType() {
		FieldAnnotaion<Max> entry = getFieldAnnotation(RuleClass1.class, "integerValue", Max.class);
		MaxRule rule = new MaxRule(entry.getAnnotation(), entry.getField());
		assertEquals(12, rule.getMaxLength());
		assertEquals("max", rule.getRuleName());
	}

	@Test
	public void stringValue() {
		FieldAnnotaion<Max> entry = getFieldAnnotation(RuleClass1.class, "stringValue", Max.class);
		MaxRule rule = new MaxRule(entry.getAnnotation(), entry.getField());
		assertEquals(5, rule.getMaxLength());
		assertEquals("max", rule.getRuleName());
		assertEquals("max: 5", rule.toRuleString());
	}

	@Test
	public void premitiveLongType() {
		FieldAnnotaion<Max> entry = getFieldAnnotation(RuleClass1.class, "longValue", Max.class);
		MaxRule rule = new MaxRule(entry.getAnnotation(), entry.getField());
		assertEquals(Long.MAX_VALUE, rule.getMaxLength());
		assertEquals("max", rule.getRuleName());
	}

	@Test
	public void isIntegerNumber() {
		assertTrue(Number.class.isAssignableFrom(Integer.class));
	}
}
