package net.narusas.jstl.validate.rules;

import net.narusas.jstl.validate.ConvertRule;

import org.hibernate.validator.constraints.NotEmpty;

public class NotEmptyRule extends ConvertRule {
	private boolean isSupported;

	public NotEmptyRule(NotEmpty annotation, Class<?> type) {
		super(annotation.message());
		if (String.class.isAssignableFrom(type)) {
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