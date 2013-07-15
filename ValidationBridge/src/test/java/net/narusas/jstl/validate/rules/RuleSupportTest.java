package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import net.narusas.jstl.validate.ConvertRule;
import net.narusas.jstl.validate.RulesInspector;
import net.narusas.jstl.validate.ValidDateTimeFormat;

import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

public class RuleSupportTest extends RuleTestBase{
	public static class RuleClass1 {
		@ValidDateTimeFormat
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
		Date date;
	}

	@Test
	public void ruleInspectorSupport() {
		FieldAnnotaion<ValidDateTimeFormat> entry = getFieldAnnotation(RuleClass1.class, "date", ValidDateTimeFormat.class);
		RulesInspector inspector = new RulesInspector();
		ConvertRule rule = inspector.findMatchRule(entry.getField(), entry.getAnnotation());
		assertNotNull(rule);
		assertTrue(rule instanceof DateFormatRule);
	}

}
