package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import net.narusas.jstl.validate.ValidDateTimeFormat;

import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

public class DateFormatRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@ValidDateTimeFormat
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
		Date date;

		@ValidDateTimeFormat
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		Date date2;

		@ValidDateTimeFormat
		@DateTimeFormat(pattern = "yyyy.MM.dd")
		Date date3;
	}

	@Test
	public void longValue() {
		FieldAnnotaion<ValidDateTimeFormat> entry = getFieldAnnotation(RuleClass1.class, "date", ValidDateTimeFormat.class);
		DateFormatRule rule = new DateFormatRule(entry.getAnnotation(), entry.getField());
		assertEquals("regex: /^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}$/", rule.toRuleString());
	}

	@Test
	public void shortValue() {
		FieldAnnotaion<ValidDateTimeFormat> entry = getFieldAnnotation(RuleClass1.class, "date2", ValidDateTimeFormat.class);
		DateFormatRule rule = new DateFormatRule(entry.getAnnotation(), entry.getField());
		assertEquals("regex: /^\\d{4}/\\d{1,2}/\\d{1,2}$/", rule.toRuleString());
	}

	@Test
	public void DOTValue() {
		FieldAnnotaion<ValidDateTimeFormat> entry = getFieldAnnotation(RuleClass1.class, "date3", ValidDateTimeFormat.class);
		DateFormatRule rule = new DateFormatRule(entry.getAnnotation(), entry.getField());
		assertEquals("regex: /^\\d{4}\\.\\d{1,2}\\.\\d{1,2}$/", rule.toRuleString());
	}

	

}
