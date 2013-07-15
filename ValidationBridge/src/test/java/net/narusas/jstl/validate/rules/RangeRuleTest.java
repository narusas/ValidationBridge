package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import org.hibernate.validator.constraints.Range;
import org.junit.Test;

public class RangeRuleTest extends RuleTestBase {
	public static class Rule {
		@Range(min = 2, max = 5)
		String stringValue;

		@Range(min = 3, max = 6)
		int intValue;

		@Range(min = 4, max = 7)
		Integer integerValue;
	}

	@Test
	public void stringValue() {
		FieldAnnotaion<Range> entry = getFieldAnnotation(Rule.class, "stringValue", Range.class);
		RangeRule rule = new RangeRule(entry.getAnnotation(), entry.getField());
		assertEquals(2, rule.getMin());
		assertEquals(5, rule.getMax());
		assertEquals("range 는 숫자의 범위를 나타내는 것으로  String 이라고 할지라도 내용이 숫자여야 함", "range: [2,5]", rule.toRuleString());
	}
	
	@Test
	public void intValue() {
		FieldAnnotaion<Range> entry = getFieldAnnotation(Rule.class, "intValue", Range.class);
		RangeRule rule = new RangeRule(entry.getAnnotation(), entry.getField());
		assertEquals(3, rule.getMin());
		assertEquals(6, rule.getMax());
		assertEquals("range: [3,6]", rule.toRuleString());
	}
	
	@Test
	public void integerValue() {
		FieldAnnotaion<Range> entry = getFieldAnnotation(Rule.class, "integerValue", Range.class);
		RangeRule rule = new RangeRule(entry.getAnnotation(), entry.getField());
		assertEquals(4, rule.getMin());
		assertEquals(7, rule.getMax());
		assertEquals("range: [4,7]", rule.toRuleString());
	}

}
