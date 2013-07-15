package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import javax.validation.constraints.NotNull;

import org.junit.Test;

public class NotNullRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@NotNull
		Integer integerValue;

		@NotNull
		String stringValue;

	}

	@Test
	public void integerType() {
		FieldAnnotaion<NotNull> entry = getFieldAnnotation(RuleClass1.class, "integerValue", NotNull.class);
		NotNullRule rule = new NotNullRule(entry.getAnnotation(), entry.getField());
		assertEquals("required: true", rule.toRuleString());
	}
	
	@Test
	public void stringType() {
		FieldAnnotaion<NotNull> entry = getFieldAnnotation(RuleClass1.class, "stringValue", NotNull.class);
		NotNullRule rule = new NotNullRule(entry.getAnnotation(), entry.getField());
		assertEquals("required: true", rule.toRuleString());
	}

}
