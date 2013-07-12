package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import net.narusas.jstl.validate.ConvertRule;
import net.narusas.jstl.validate.RulesInspector;
import net.narusas.jstl.validate.rules.DateFormatRuleTest.RuleClass1;

import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

public class RuleSupportTest extends RuleTestBase{
	public static class RuleClass {
		
	}

	@Test
	public void ruleInspectorSupport() {
		FieldAnnotaion<DateTimeFormat> entry = getFieldAnnotation(RuleClass1.class, "date", DateTimeFormat.class);
		RulesInspector inspector = new RulesInspector();
		ConvertRule rule = inspector.findMatchRule(entry.getField(), entry.getAnnotation());
		assertNotNull(rule);
		assertTrue(rule instanceof DateFormatRule);
	}

}
