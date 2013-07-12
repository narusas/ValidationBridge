package net.narusas.jstl.validate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.validation.constraints.NotNull;

import net.narusas.jstl.validate.rules.FieldAnnotaion;
import net.narusas.jstl.validate.rules.NotNullRule;
import net.narusas.jstl.validate.rules.RuleTestBase;

import org.junit.Test;

public class RuleRegistryTest extends RuleTestBase{
	
	public static class Rule {
		@NotNull
		String stringValue;
	}

	@Test
	public void test() {
		FieldAnnotaion<NotNull> entry = getFieldAnnotation(Rule.class, "stringValue", NotNull.class);
		ConvertRule rule = RuleRegistry.findMatchRule(entry.getField().getType(), entry.getAnnotation());
		assertNotNull(rule);
		assertTrue(rule instanceof NotNullRule);
	}

}
