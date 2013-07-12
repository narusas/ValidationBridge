package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import org.hibernate.validator.constraints.Length;
import org.junit.Test;

public class LengthRuleTest extends RuleTestBase {
	public static class Rule {
		@Length(min = 2, max = 5)
		String stringValue;
	}

	@Test
	public void test() {
		FieldAnnotaion<Length> entry = getFieldAnnotation(Rule.class, "stringValue", Length.class);
		LengthRule rule = new LengthRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals(2, rule.getMin());
		assertEquals(5, rule.getMax());
		assertEquals("rangelength: [2,5]", rule.toRuleString());
	}

}
