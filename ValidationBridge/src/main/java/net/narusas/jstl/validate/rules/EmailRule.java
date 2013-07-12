package net.narusas.jstl.validate.rules;

import net.narusas.jstl.validate.ConvertRule;

import org.hibernate.validator.constraints.Email;

public class EmailRule extends ConvertRule {

	public EmailRule(Email annotation, Class<?> type) {
		super(annotation.message());
	}

	@Override
	public String toRuleString() {
		return "email: true";
	}

	@Override
	public String toMessageString() {
		return "email: '" + getMessageFromSource(message) + "'";
	}

}
