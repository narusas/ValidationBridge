package net.narusas.jstl.validate.rules;

import java.lang.reflect.Field;

import javax.validation.constraints.NotNull;

import net.narusas.jstl.validate.ConvertRule;

public class NotNullRule extends ConvertRule {
	public NotNullRule(NotNull notnull, Field field) {
		super(notnull.message());
	}

	public String toRuleString() {
		return "required: true";
	}

	public String toMessageString() {
		return "required: '" + getMessageFromSource(message) + "'";
	}

}