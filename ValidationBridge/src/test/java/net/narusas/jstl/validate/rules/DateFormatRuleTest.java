package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

public class DateFormatRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
		Date date;

		@DateTimeFormat(pattern = "yyyy/MM/dd")
		Date date2;

		@DateTimeFormat(pattern = "yyyy.MM.dd")
		Date date3;
	}

	@Test
	public void longValue() {
		FieldAnnotaion<DateTimeFormat> entry = getFieldAnnotation(RuleClass1.class, "date", DateTimeFormat.class);
		DateFormatRule rule = new DateFormatRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals("regex: /^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}$/", rule.toRuleString());
	}

	@Test
	public void shortValue() {
		FieldAnnotaion<DateTimeFormat> entry = getFieldAnnotation(RuleClass1.class, "date2", DateTimeFormat.class);
		DateFormatRule rule = new DateFormatRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals("regex: /^\\d{4}/\\d{1,2}/\\d{1,2}$/", rule.toRuleString());
	}

	@Test
	public void DOTValue() {
		FieldAnnotaion<DateTimeFormat> entry = getFieldAnnotation(RuleClass1.class, "date3", DateTimeFormat.class);
		DateFormatRule rule = new DateFormatRule(entry.getAnnotation(), entry.getField().getType());
		assertEquals("regex: /^\\d{4}\\.\\d{1,2}\\.\\d{1,2}$/", rule.toRuleString());
	}

	

}
