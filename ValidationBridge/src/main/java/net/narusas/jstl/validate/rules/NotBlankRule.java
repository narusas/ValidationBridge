package net.narusas.jstl.validate.rules;

import net.narusas.jstl.validate.ConvertRule;

import org.hibernate.validator.constraints.NotBlank;

public class NotBlankRule extends ConvertRule {

	public NotBlankRule(NotBlank annotation, Class<?> type) {
		super(annotation.message());
	}

	public String toRuleString() {
		return "required: true, regex: /.*\\S.*/";
	}

	public String toMessageString() {
		return "required: '" + getMessageFromSource(message) + "'";
	}
}