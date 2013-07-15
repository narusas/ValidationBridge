package net.narusas.jstl.validate.rules;

import java.lang.reflect.Field;

import net.narusas.jstl.validate.ConvertRule;

import org.hibernate.validator.constraints.Email;

public class EmailRule extends ConvertRule {

	public EmailRule(Email annotation, Field field) {
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
