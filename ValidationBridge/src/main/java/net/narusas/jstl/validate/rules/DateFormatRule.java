package net.narusas.jstl.validate.rules;

import java.lang.reflect.Field;

import net.narusas.jstl.validate.ConvertRule;
import net.narusas.jstl.validate.ValidDateTimeFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

public class DateFormatRule extends ConvertRule {


	private String dateRegex;

	public DateFormatRule(ValidDateTimeFormat annotation, Field field) {
		super(annotation.message());
		DateTimeFormat ann = field.getAnnotation(DateTimeFormat.class);
		String datePattern = ann.pattern();
		datePattern = StringUtils.replace(datePattern, "yyyy", "\\d{4}");
		datePattern = StringUtils.replace(datePattern, "yy", "\\d{2}");
		datePattern = StringUtils.replace(datePattern, "MM", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "M", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "KK", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "k", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "kk", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "k", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "dd", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "HH", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "H", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "hh", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "h", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "mm", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "m", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "ss", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, "s", "\\d{1,2}");
		datePattern = StringUtils.replace(datePattern, ".", "\\.");
		dateRegex = datePattern;
	}

	@Override
	public String toRuleString() {
			return "regex: /^"+dateRegex+"$/";
	}

	@Override
	public String toMessageString() {
		return  "regex: '" + getMessageFromSource(message) + "'";
	}

}
