package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import org.hibernate.validator.constraints.Email;
import org.junit.Test;

public class EmailRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@Email
		String email;
	}

	@Test
	public void email() {
		FieldAnnotaion<Email> entry = getFieldAnnotation(RuleClass1.class, "email", Email.class);
		EmailRule rule = new EmailRule(entry.getAnnotation(), entry.getField());
		assertEquals("email: true", rule.toRuleString());
	}
}
