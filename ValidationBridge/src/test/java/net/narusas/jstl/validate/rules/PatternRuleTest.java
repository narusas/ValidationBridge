package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import javax.validation.constraints.Pattern;

import org.junit.Test;

public class PatternRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@Pattern(regexp="\\d+")
		String regex1;
		
		@Pattern(regexp="\\d+", flags=Pattern.Flag.DOTALL)
		String regex2;
		
		@Pattern(regexp="\\d+", flags=Pattern.Flag.MULTILINE)
		String regex3;
		
		@Pattern(regexp="\\d+", flags=Pattern.Flag.CASE_INSENSITIVE)
		String regex4;
		
		
		@Pattern(regexp="\\d+", flags={Pattern.Flag.DOTALL, Pattern.Flag.MULTILINE, Pattern.Flag.CASE_INSENSITIVE})
		String regex5;
	}

	@Test
	public void regexpValue() {
		FieldAnnotaion<Pattern> entry = getFieldAnnotation(RuleClass1.class, "regex1", Pattern.class);
		PatternRule rule = new PatternRule(entry.getAnnotation(), entry.getField());
		assertEquals("regex: /\\d+/", rule.toRuleString());
	}
	
	@Test
	public void flagsDOTALLValue() {
		
		FieldAnnotaion<Pattern> entry = getFieldAnnotation(RuleClass1.class, "regex2", Pattern.class);
		PatternRule rule = new PatternRule(entry.getAnnotation(), entry.getField());
		assertEquals("regex: /\\d+/g", rule.toRuleString());
	}
	
	@Test
	public void flagsMULTILINEValue() {
		FieldAnnotaion<Pattern> entry = getFieldAnnotation(RuleClass1.class, "regex3", Pattern.class);
		PatternRule rule = new PatternRule(entry.getAnnotation(), entry.getField());
		assertEquals("regex: /\\d+/m", rule.toRuleString());
	}
	
	@Test
	public void flagsCASE_INSENSITIVEValue() {
		FieldAnnotaion<Pattern> entry = getFieldAnnotation(RuleClass1.class, "regex4", Pattern.class);
		PatternRule rule = new PatternRule(entry.getAnnotation(), entry.getField());
		assertEquals("regex: /\\d+/i", rule.toRuleString());
	}
	
	@Test
	public void flagsMultiValue() {
		FieldAnnotaion<Pattern> entry = getFieldAnnotation(RuleClass1.class, "regex5", Pattern.class);
		PatternRule rule = new PatternRule(entry.getAnnotation(), entry.getField());
		assertEquals("regex: /\\d+/gmi", rule.toRuleString());
	}
}
