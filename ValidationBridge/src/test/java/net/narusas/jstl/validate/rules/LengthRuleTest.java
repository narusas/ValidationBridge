package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import org.hibernate.validator.constraints.Length;
import org.junit.Test;

public class LengthRuleTest extends RuleTestBase {
	public static class Rule {
		@Length(min = 2, max = 5)
		String stringValue;
		
		@Length(min = 2)
		String stringValue2;
		
		
		@Length(max = 2)
		String stringValue3;
		
	}

	@Test
	public void haveMinMax() {
		FieldAnnotaion<Length> entry = getFieldAnnotation(Rule.class, "stringValue", Length.class);
		LengthRule rule = new LengthRule(entry.getAnnotation(), entry.getField());
		assertEquals(2, rule.getMin());
		assertEquals(5, rule.getMax());
		assertEquals("rangelength: [2,5]", rule.toRuleString());
	}
	
	@Test
	public void haveMin() {
		FieldAnnotaion<Length> entry = getFieldAnnotation(Rule.class, "stringValue2", Length.class);
		LengthRule rule = new LengthRule(entry.getAnnotation(), entry.getField());
		assertEquals(2, rule.getMin());
		assertEquals(Integer.MAX_VALUE, rule.getMax());
		assertEquals("rangelength: [2,"+Integer.MAX_VALUE+"]", rule.toRuleString());
	}
	
	@Test
	public void haveMax() {
		FieldAnnotaion<Length> entry = getFieldAnnotation(Rule.class, "stringValue3", Length.class);
		LengthRule rule = new LengthRule(entry.getAnnotation(), entry.getField());
		assertEquals(0, rule.getMin());
		assertEquals(2, rule.getMax());
		assertEquals("rangelength: [0,2]", rule.toRuleString());
	}

}
