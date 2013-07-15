package net.narusas.jstl.validate.rules;

import java.lang.reflect.Field;

import net.narusas.jstl.validate.ConvertRule;

import org.hibernate.validator.constraints.NotEmpty;

public class NotEmptyRule extends ConvertRule {
	private boolean isSupported;

	public NotEmptyRule(NotEmpty annotation, Field field) {
		super(annotation.message());
		if (String.class.isAssignableFrom(field.getType())) {
			isSupported = true;
		}
	}

	public String toRuleString() {
		if (isSupported) {
			return "required: true";
		} else {
			return "";
		}
	}

	public String toMessageString() {
		if (isSupported) {

			return "required: '" + getMessageFromSource(message) + "'";
		} else {
			return "";
		}
	}
}