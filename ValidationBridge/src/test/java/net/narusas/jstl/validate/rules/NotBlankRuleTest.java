package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import org.hibernate.validator.constraints.NotBlank;
import org.junit.Test;

public class NotBlankRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@NotBlank
		String stringValue;
	}
	
	@Test
	public void stringType() {
		FieldAnnotaion<NotBlank> entry = getFieldAnnotation(RuleClass1.class, "stringValue", NotBlank.class);
		NotBlankRule rule = new NotBlankRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals("required: true, regex: /.*\\S.*/", rule.toRuleString());
	}
}
