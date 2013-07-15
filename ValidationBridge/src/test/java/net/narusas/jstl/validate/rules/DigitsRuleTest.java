package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import javax.validation.constraints.Digits;

import org.junit.Test;

public class DigitsRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@Digits(integer=2, fraction=0)
		int intValue;
		
		@Digits(integer=2, fraction=3)
		float floatValue;
	}

	@Test
	public void intValue() {
		FieldAnnotaion<Digits> entry = getFieldAnnotation(RuleClass1.class, "intValue", Digits.class);
		DigitsRule rule = new DigitsRule(entry.getAnnotation(), entry.getField());
		assertEquals("digits: true, regex: /^[-]?\\d{0,2}$/", rule.toRuleString());
	}
	
	@Test
	public void floatValue() {
		FieldAnnotaion<Digits> entry = getFieldAnnotation(RuleClass1.class, "floatValue", Digits.class);
		DigitsRule rule = new DigitsRule(entry.getAnnotation(), entry.getField());
		assertEquals("number: true, regex: /^[-]?\\d{0,2}(\\.\\d{0,3})?$/", rule.toRuleString());
	}
	@Test
	public void regexDigit() {
		String regex = "[-]?\\d{0,2}";
		assertTrue(Pattern.matches(regex, ""));
		assertTrue(Pattern.matches(regex, "1"));
		assertTrue(Pattern.matches(regex, "2"));
		assertTrue(Pattern.matches(regex, "12"));
		assertTrue(Pattern.matches(regex, "-1"));
		assertTrue(Pattern.matches(regex, "-12"));
		
		
		assertFalse(Pattern.matches(regex, "A"));
		assertFalse(Pattern.matches(regex, "AB"));
		assertFalse(Pattern.matches(regex, "123"));
		assertFalse(Pattern.matches(regex, "-123"));
	}
	
	@Test
	public void regexNumbers() {
		String regex = "[-]?\\d{0,2}(\\.\\d{0,3})?";
		assertTrue(Pattern.matches(regex, ""));
		assertTrue(Pattern.matches(regex, "1"));
		assertTrue(Pattern.matches(regex, "-1"));
		assertTrue(Pattern.matches(regex, "2"));
		assertTrue(Pattern.matches(regex, "12"));
		assertTrue(Pattern.matches(regex, "-12"));
		assertTrue(Pattern.matches(regex, "12.1"));
		assertTrue(Pattern.matches(regex, "12.12"));
		assertTrue(Pattern.matches(regex, "12.123"));
		assertTrue(Pattern.matches(regex, "-12.123"));
		
		assertFalse(Pattern.matches(regex, "A"));
		assertFalse(Pattern.matches(regex, "AB"));
		assertFalse(Pattern.matches(regex, "123"));	
		assertFalse(Pattern.matches(regex, "123.1234"));	
		assertFalse(Pattern.matches(regex, "-123.1234"));	
	}
	
}
